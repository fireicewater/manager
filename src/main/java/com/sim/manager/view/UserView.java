package com.sim.manager.view;

import com.sim.manager.validator.UserNameUnique;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class UserView {

    private Integer id;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @UserNameUnique(message = "用户名已存在")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
     * 性别
     */
    private int sex;

    /**
     * 手机
     */
    @NotEmpty(message = "手机不能为空")
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$", message = "手机错误")
    private Integer mobile;

    /**
     * 支付方式
     */
    @NotEmpty(message = "支付方式不能为空")
    private String paymethod;

    /**
     * 银行卡号
     */
    @NotEmpty(message = "银行卡号不能为空")
    private String cardno;

    /**
     * 支付宝
     */
    @NotEmpty(message = "支付宝不能为空")
    private String alipay;

    private BigDecimal salesamount;

    /**
     * 销售人员
     */
    @NotEmpty(message = "销售人员不能为空")
    private String salesman;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public BigDecimal getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(BigDecimal salesamount) {
        this.salesamount = salesamount;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }
}
