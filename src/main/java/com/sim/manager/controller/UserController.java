package com.sim.manager.controller;

import com.github.pagehelper.PageInfo;
import com.sim.manager.service.UserService;
import com.sim.manager.view.ChangePasswordView;
import com.sim.manager.view.Result;
import com.sim.manager.view.UserSearchView;
import com.sim.manager.view.UserView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getuserlist")
    public Result getuserlist(@RequestBody UserSearchView userSearchView) {
        PageInfo<UserView> result = userService.findUsersBySerch(userSearchView);
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
        if (haveuser) {
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

    @GetMapping("/getuserinfo")
    public Result getUserinfo(@RequestParam("userid") Integer userid) {
        if (null == userid) {
            return new Result(Result.PARAMERROR);
        }
        UserView userView = userService.findUserByid(userid);
        if (null == userView) {
            return new Result(Result.NOTFOND);
        } else {
            return new Result(Result.SUCCESS, userView);
        }
    }

    @PostMapping("/changpassword")
    public Result changePassword(@RequestBody ChangePasswordView changePasswordView) {
        int id = changePasswordView.getId();
        String newpassword = changePasswordView.getNewpassword();
        String password = changePasswordView.getPassword();
        String repassword = changePasswordView.getRepassword();
        if (id == 0 || StringUtils.isBlank(newpassword) || StringUtils.isBlank(password) || StringUtils.isBlank(repassword)) {
            return new Result(Result.PARAMERROR, "参数不能为空");
        }
        if (!userService.validaePassword(id, password)) {
            return new Result(Result.PARAMERROR, "原密码不正确");
        }
        if (!newpassword.equals(repassword)) {
            return new Result(Result.PARAMERROR, "两次输入密码不相同");
        }
        Boolean flag = userService.changpassword(id, newpassword);
        if (flag) {
            return new Result(Result.SUCCESS);
        } else {
            return new Result(Result.NOTFOND);
        }
    }
}
