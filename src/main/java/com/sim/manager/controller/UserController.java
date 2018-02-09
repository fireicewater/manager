package com.sim.manager.controller;

import com.sim.manager.service.UserService;
import com.sim.manager.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity addUser(@Validated UserView userView, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("参数有错误");
        }
        //用户注册
        Boolean flag = userService.register(userView);
        if (flag) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入失败");
        }
    }

    @GetMapping("/validateuser")
    public ResponseEntity validatorUsername(@RequestParam("username") String username) {
        Boolean flag = userService.validtaeUser(username);
        if (flag) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @PutMapping("/updateuser")
    public ResponseEntity updateUser(@Validated UserView userView, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("参数有错误");
        }
        Boolean flag = userService.updateUser(userView);
        if (flag) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新失败");
        }
    }

    @DeleteMapping("/deleteusers")
    public ResponseEntity deleteUsers(@RequestBody List<Integer> userids) {
        if (userids.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("删除列表为空");
        }
        Boolean flag = userService.deleteUsers(userids);
        if (flag) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新失败");
        }
    }
}
