package com.weixin.backend.controller;

import com.weixin.backend.service.SeatService;
import com.weixin.backend.service.UserService;
import com.weixin.backend.util.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    SeatService seatService;

    public Result addInfo() {}

    @ApiOperation(value = "Get user information", notes = "via User id")
    @ApiImplicitParam(name = "id", value = "User id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result getInfo(@PathVariable String id) {
        userService.getUser(id);
    }

    public Result updateInfo() {}

    @ApiOperation(value = "Get films have been watched", notes = "via User id")
    @ApiImplicitParam(name = "id", value = "User id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "{id}/movies", method = RequestMethod.GET)
    public Result watched(@PathVariable String id) {
        userService.findMovies(id);
    }

    @ApiOperation(value = "Information about Weixin Theater", notes = "")
    @RequestMapping()
    public Result about() {}
}
