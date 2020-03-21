package com.asong.dao.impl;

import com.asong.dao.AccountDao;
import com.asong.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.ws.handler.Handler;
import java.sql.SQLException;
import java.util.List;
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("Select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("Select * from account where id=?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account values(null,?,?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from  account where id=?", accountId);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 基于注解可以不配配置
     * @param runner
     */
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
}
