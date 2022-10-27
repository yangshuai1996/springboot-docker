package com.estone.it.controller;

import com.estone.it.common.Result;
import com.estone.it.entity.User;
import com.estone.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findList")
    public Result<List<User>> findList(){
        return Result.success(userService.findList());
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success();
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }
}
