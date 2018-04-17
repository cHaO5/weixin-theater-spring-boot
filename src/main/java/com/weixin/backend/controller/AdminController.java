package com.weixin.backend.controller;

import com.weixin.backend.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class AdminController {

    @RequestMapping(value = "")
    public Result addSchedule() {}

    @RequestMapping(value = "")
    public Result deleteSchedule() {}

    @RequestMapping(value = "")
    public Result modifySchedule() {}

    @RequestMapping(value = "")
    public Result getSchedule() {}

    @RequestMapping(value = "")
    public Result getAudience() {}
}
