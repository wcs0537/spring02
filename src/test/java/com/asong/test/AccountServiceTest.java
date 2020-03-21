package com.asong.test;

import com.asong.domain.Account;
import com.asong.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    AccountService accountService;
    Account account;
    @Before
    public void init(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
         accountService=applicationContext.getBean("accountService",AccountService.class);
    }
    @Test
    public void testFindAll(){

        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){

         account = accountService.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account=new Account();
        account.setMoney((float) 11.0);
        account.setName("11");
         accountService.saveAccount(account);
    }
    @Test
    public void testUpdate(){
         account = accountService.findAccountById(1);
         account.setName("222");
        accountService.updateAccount(account);

    }
    @Test
    public void testDelete(){
        accountService.deleteAccount(4);
    }
}
