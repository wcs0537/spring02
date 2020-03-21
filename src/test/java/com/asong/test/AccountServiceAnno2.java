package com.asong.test;

import com.asong.domain.Account;
import com.asong.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:bean_anno.xml")
public class AccountServiceAnno2 {
    @Autowired
    AccountService accountService;
     Account account;
   /* @Before
    public void init(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        accountService=applicationContext.getBean("accountService",AccountService.class);
    }*/
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
        accountService.deleteAccount(5);
    }
}
