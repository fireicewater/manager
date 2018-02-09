package com.sim.manager.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_detail")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private int sex;

    /**
     * 手机
     */
    private String mobile;

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

    private BigDecimal salesamount;

    /**
     * 销售人员
     */
    private String salesman;

    private Date createtime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public int getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取支付方式
     *
     * @return paymethod - 支付方式
     */
    public String getPaymethod() {
        return paymethod;
    }

    /**
     * 设置支付方式
     *
     * @param paymethod 支付方式
     */
    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    /**
     * 获取银行卡号
     *
     * @return cardno - 银行卡号
     */
    public String getCardno() {
        return cardno;
    }

    /**
     * 设置银行卡号
     *
     * @param cardno 银行卡号
     */
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    /**
     * 获取支付宝
     *
     * @return alipay - 支付宝
     */
    public String getAlipay() {
        return alipay;
    }

    /**
     * 设置支付宝
     *
     * @param alipay 支付宝
     */
    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    /**
     * @return salesamount
     */
    public BigDecimal getSalesamount() {
        return salesamount;
    }

    /**
     * @param salesamount
     */
    public void setSalesamount(BigDecimal salesamount) {
        this.salesamount = salesamount;
    }

    /**
     * 获取销售人员
     *
     * @return salesman - 销售人员
     */
    public String getSalesman() {
        return salesman;
    }

    /**
     * 设置销售人员
     *
     * @param salesman 销售人员
     */
    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}