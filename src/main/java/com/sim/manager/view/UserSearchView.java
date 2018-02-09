package com.sim.manager.view;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserSearchView {

    private int page = 1;

    private String username;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public BigDecimal getMinsalesamount() {
        return minsalesamount;
    }

    public void setMinsalesamount(BigDecimal minsalesamount) {
        this.minsalesamount = minsalesamount;
    }

    public BigDecimal getMaxsalesamount() {
        return maxsalesamount;
    }

    public void setMaxsalesamount(BigDecimal maxsalesamount) {
        this.maxsalesamount = maxsalesamount;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public List<Date> getCreatetime() {
        return createtime;
    }

    public void setCreatetime(List<Date> createtime) {
        this.createtime = createtime;
    }
}
