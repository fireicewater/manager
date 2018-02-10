package com.sim.manager.service;

import com.sim.manager.model.Amount;
import com.sim.manager.view.AmountView;

import java.util.List;

public interface AmountService {
    Boolean addAmount(AmountView amountView);

    List<Amount> findAmountsByUserid(int userid);

    Boolean updateStatus(Amount amount);
}
