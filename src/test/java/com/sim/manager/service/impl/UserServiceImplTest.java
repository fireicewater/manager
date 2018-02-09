package com.sim.manager.service.impl;

import com.sim.manager.service.UserService;
import com.sim.manager.view.UserView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void register() {
        String username = "test";
        String password = "test";
        String name = "张三";
        int sex = 1;
        String mobile = "13800138000";
        String paymethod = "支付宝";
        String cardno = "1231314";
        String alipay = "13800138000";
        BigDecimal salesamount = new BigDecimal(500);
        String salesman = "李四";
        for (int i = 0; i < 20; i++) {
            String tempusername = username + i;
            String tempname = name + i;
            String tempsalesman = salesman + i;
            UserView userView = new UserView(tempusername, password, tempname, sex, mobile, paymethod, cardno, alipay, salesamount, tempsalesman);
            userService.register(userView);
        }

    }

    @Test
    public void validtaeUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUsers() {
    }

    @Test
    public void findUsersBySerch() {
    }
}