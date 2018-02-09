package com.sim.manager.controller;

import com.github.pagehelper.PageInfo;
import com.sim.manager.service.UserService;
import com.sim.manager.view.Result;
import com.sim.manager.view.UserSearchView;
import com.sim.manager.view.UserView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getuserlist")
    public Result getuserlist(@RequestBody UserSearchView userSearchView) {
        PageInfo<UserView> result= userService.findUsersBySerch(userSearchView);
        if (null == result) {
            return new Result(Result.NOTAUTH);
        }
        return new Result(Result.SUCCESS, result);
    }

    @PostMapping("/register")
    public Result addUser(@RequestBody @Validated UserView userView, BindingResult result) {
        if (result.hasErrors()) {
            return new Result(Result.PARAMERROR);
        }
        Boolean haveuser = userService.validtaeUser(userView.getUsername());
        if (!haveuser) {
            return new Result(Result.PARAMERROR);
        }
        //用户注册
        Boolean flag = userService.register(userView);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.ERROR);
        }
    }

    @GetMapping("/validateuser")
    public Result validatorUsername(@RequestParam("username") String username) {
        Boolean flag = userService.validtaeUser(username);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.NOTFOND);
        }
    }

    @PutMapping("/updateuser")
    public Result updateUser(@RequestBody @Validated UserView userView, BindingResult result) {
        if (result.hasErrors()) {
            return new Result(Result.PARAMERROR);
        }
        Boolean flag = userService.updateUser(userView);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.ERROR);
        }
    }

    @PostMapping("/deleteusers")
    public Result deleteUsers(@RequestBody List<Integer> userids) {
        if (userids.isEmpty()) {

        }
        Boolean flag = userService.deleteUsers(userids);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.ERROR);
        }
    }

    @PostMapping("/resetpassword")
    public Result resetPassword(@RequestParam Integer userid, @RequestParam String password) {
        if (null == userid && StringUtils.isBlank(password)) {
            return new Result(Result.PARAMERROR);
        }
        Boolean flag = userService.changpassword(userid, password);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.ERROR);
        }
    }

    @PostMapping("/validatpassword")
    public Result validatePassword(@RequestParam Integer userid, @RequestParam String password) {
        if (null == userid && StringUtils.isBlank(password)) {
            return new Result(Result.PARAMERROR);
        }
        Boolean flag = userService.validaePassword(userid, password);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.NOTFOND);
        }
    }
}
