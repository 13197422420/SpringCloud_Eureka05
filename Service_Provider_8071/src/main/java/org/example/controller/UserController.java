package org.example.controller;

import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    @GetMapping("/hello")
    String Hello() {
        return "hello world!!!";
    }

    @Value("${msg}")
    private String msg;

    @GetMapping("/getUserById/{userId}")
    public CommonResult<User> getUserById(@PathVariable Integer userId) {
        User u = new User(userId, "小明", "123456");
        return new CommonResult<>(200, "success(8071) msg("+ msg +")", u);
    }

    @PostMapping("/addUser")
    public CommonResult<User> addUser(@RequestBody User user) {
        return new CommonResult<>(200, "add success(8071)", user);
    }

    @PutMapping("/updateUser")
    public CommonResult<User> updateUser(@RequestBody User user) {
        return new CommonResult<>(200, "update success(8071)", user);
    }

    @DeleteMapping("/removeUserById/{userId}")
    public CommonResult<User> removeUserById(@PathVariable Integer userId) {
        User u = new User(userId, "小明", "123456");
        return new CommonResult<>(200, "delete success(8071)", u);
    }
}
