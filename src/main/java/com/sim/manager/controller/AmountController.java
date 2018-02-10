package com.sim.manager.controller;

import com.sim.manager.model.Amount;
import com.sim.manager.service.AmountService;
import com.sim.manager.view.AmountView;
import com.sim.manager.view.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/amount")
public class AmountController {

    @Autowired
    private AmountService amountService;

    @PostMapping("/addamount")
    public Result addCount(@RequestBody AmountView amountView) {
        if (amountView.getUserid() == 0 && null == amountView.getAmount()) {
            return new Result(Result.PARAMERROR);
        }
        Boolean flag = amountService.addAmount(amountView);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.ERROR);
        }
    }

    @GetMapping("/getAmounts")
    public Result getUserAmounts(@RequestParam("userid") int userid) {
        if (userid == 0) {
            return new Result(Result.PARAMERROR);
        }
        List<Amount> amounts = amountService.findAmountsByUserid(userid);
        if (!amounts.isEmpty()) {
            return new Result(Result.SUCCESS, amounts);
        } else {
            return new Result(Result.NOTFOND);
        }
    }

    @PutMapping("/updatestatus")
    public Result changStatus(@RequestBody Amount amount) {
        if (amount.getStatus()) {
            return new Result(Result.SUCCESS);
        }
        Boolean flag = amountService.updateStatus(amount);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.ERROR);
        }
    }
}
