package com.sim.manager.view;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserSearchView {

    private String username;
    private String password;
    private String name;
    /**
     * 性别
     */
    private int sex;

    /**
     * 手机
     */
    private Integer mobile;

    /**
     * 支付方式
     */
    private String paymethod;

    /**
     * 银行卡号
     */
    private String cardno;

    /**
     * 支付宝
     */
    private String alipay;

    private BigDecimal minsalesamount;

    private BigDecimal maxsalesamount;

    /**
     * 销售人员
     */
    private String salesman;

    private List<Date> createtime;
}
