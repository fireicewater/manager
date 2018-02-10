package com.sim.manager.view;

import java.math.BigDecimal;

public class AmountView {

    private int userid;

    private BigDecimal amount;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
