package com.chm.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /*
     * 跨服务器文件上传
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(@RequestParam(name = "upload") MultipartFile multipartFile) throws Exception {
        System.out.println("跨服务器文件上传");
        //定义文件上传位置：文件服务器的指定目录下
        String path = "http://localhost:9090/uploads/";

        String fileName = multipartFile.getOriginalFilename();//获取初始的文件名
        //把文件名设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("_", "");
        fileName = uuid + "_" + fileName;
        /* 文件上传关键步骤 */
        //1.创建客户端的对象
        Client client = Client.create();
        //2.连接到文件服务器
        WebResource webResource = client.resource(path + fileName);
        //3.上传文件
        webResource.put(multipartFile.getBytes());
        return "success";
    }

    /*
     * SpringMVC方式的文件上传
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, @RequestParam(name = "upload") MultipartFile multipartFile) throws Exception {
        System.out.println("fileUpload_2执行了");
        /* 1.文件上传前的操作 */
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        //判断，/uploads目录是否存在
        if (!file.exists()) {//若目录不存在，则创建该目录
            file.mkdirs();
        }

        /* 2.进行文件上传 */
        String fileName = multipartFile.getOriginalFilename();//获取初始的文件名
        //把文件名设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("_", "");
        fileName = uuid + "_" + fileName;
        //完成文件上传（上传完成后，会自动删除临时文件）
        multipartFile.transferTo(new File(path, fileName));
        System.out.println("文件已成功上传到 " + path + " 路径下。");
        return "success";
    }


    /*
     * 文件上传（传统JavaWeb方式）
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload_1执行了");
        /* 使用fileupload组件完成文件上传 */
        //指定上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        //判断，/uploads目录是否存在
        if (!file.exists()) {//若目录不存在，则创建该目录
            file.mkdirs();
        }

        /* 解析request对象，获取"上传文件项" */
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //判断，当前item对象是否为上传文件项
            if (item.isFormField()) {  //说明item对象为普通表单项
                System.out.println("当前item对象为普通表单项，非文件上传项！");
            } else {  //说明item对象为文件上传项
                //获取上传文件的名称
                String itemName = item.getName();
                //把文件名设置为唯一值，uuid。这样的好处是：在多次上传相同文件时，不覆盖原有的文件。
                String uuid = UUID.randomUUID().toString().replace("_", "");
                itemName = uuid + "_" + itemName;
                //完成文件上传
                item.write(new File(path, itemName));
                //删除临时文件（注意：当上传文件的大小超过10KB，就会产生临时文件。若不超过10KB则在内存中生成缓存的文件。）
                item.delete();
            }
        }
        System.out.println("文件已成功上传到 " + path + " 路径下。");
        return "success";
    }
}
