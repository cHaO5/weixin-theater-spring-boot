package com.weixin.backend.controller;

import com.weixin.backend.entity.Movie;
import com.weixin.backend.entity.User;
import com.weixin.backend.service.ReservationService;
import com.weixin.backend.service.UserService;
import com.weixin.backend.util.Result;
import com.weixin.backend.util.ResultCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Get user information", notes = "via User id")
    @ApiImplicitParam(name = "id", value = "User id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getInfo(@PathVariable String id) {
        User user = userService.getUser(id);
        if (user != null) {
            return new Result(ResultCode.SUCCESS, user);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result updateInfo(@PathVariable String id,
                             @RequestBody Map<String, Object> info) {
        boolean user = userService.updateUser(id, info);
        if (user) {
            return new Result(ResultCode.SUCCESS, user);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    @ApiOperation(value = "Information about Weixin Theater", notes = "")
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public Result about() {
        return new Result(ResultCode.SUCCESS, "ABOUT");
    }
}
