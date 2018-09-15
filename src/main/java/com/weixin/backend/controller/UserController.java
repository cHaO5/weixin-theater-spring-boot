package com.weixin.backend.controller;

import com.weixin.backend.entity.User;
import com.weixin.backend.service.impl.UserServiceImpl;
import com.weixin.backend.util.Result;
import com.weixin.backend.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getInfo(@PathVariable String id) {
        User user = userServiceImpl.getUser(id);
        if (user != null) {
            return new Result(ResultCode.SUCCESS, user);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result updateInfo(@PathVariable String id,
                             @RequestBody Map<String, Object> info) {
        boolean user = userServiceImpl.updateUser(id, info);
        if (user) {
            return new Result(ResultCode.SUCCESS, user);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public Result about() {
        return new Result(ResultCode.SUCCESS, "ABOUT");
    }
}
