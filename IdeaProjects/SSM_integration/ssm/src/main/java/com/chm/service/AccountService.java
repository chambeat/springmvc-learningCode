package com.chm.service;

import com.chm.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /* 查询所有账户 */
    List<Account> findAll();

    /* 保存账户 */
    void saveAccount(Account account);
}
