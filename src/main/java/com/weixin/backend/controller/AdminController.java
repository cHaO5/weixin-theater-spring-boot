package com.weixin.backend.controller;

import com.weixin.backend.entity.Schedule;
import com.weixin.backend.service.ScheduleService;
import com.weixin.backend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "schedules/{id}", method = RequestMethod.POST)
    public Result addSchedule(@PathVariable int id,
                              @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        scheduleService.save(new Schedule(id, date));
    }

    @RequestMapping(value = "schedules/{id}", method = RequestMethod.DELETE)
    public Result deleteSchedule(@PathVariable int id,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        scheduleService.deleteSchedule(id, date);
    }

    @RequestMapping(value = "schedules/{id}", method = RequestMethod.POST)
    public Result modifySchedule() {}

    @RequestMapping(method = RequestMethod.GET)
    public Result getSchedule() {
        scheduleService.findAll();
    }

    @RequestMapping(value = "/audiences", method = RequestMethod.GET)
    public Result getAudience() {}
}
