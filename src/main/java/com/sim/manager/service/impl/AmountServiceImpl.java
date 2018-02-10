package com.sim.manager.service.impl;

import com.sim.manager.mapper.AmountMapper;
import com.sim.manager.model.Amount;
import com.sim.manager.service.AmountService;
import com.sim.manager.view.AmountView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class AmountServiceImpl implements AmountService {

    @Autowired
    private AmountMapper amountMapper;

    @Override
    public Boolean addAmount(AmountView amountView) {
        Amount amount = new Amount();
        BeanUtils.copyProperties(amountView, amount);
        amount.setStatus(false);
        amount.setCreatetime(new Date());
        int i = amountMapper.insertUseGeneratedKeys(amount);
        return i != 0;
    }

    @Override
    public List<Amount> findAmountsByUserid(int userid) {
        Example example = new Example(Amount.class);
        example.orderBy("createtime").desc();
        example.createCriteria().andEqualTo("userid", userid);
        return amountMapper.selectByExample(example);
    }

    @Override
    public Boolean updateStatus(Amount amount) {
        amount.setAmount(null);
        amount.setStatus(true);
        int i = amountMapper.updateByPrimaryKeySelective(amount);
        return i != 0;
    }
}
