package com.weixin.backend.controller;

import com.weixin.backend.service.ScheduleService;
import com.weixin.backend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.POST)
    public Result addSchedule() {
        scheduleService.
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Result deleteSchedule() {}

    @RequestMapping(method = RequestMethod.POST)
    public Result modifySchedule() {}

    @RequestMapping(method = RequestMethod.GET)
    public Result getSchedule() {}

    @RequestMapping(value = "/audiences", method = RequestMethod.GET)
    public Result getAudience() {}
}
