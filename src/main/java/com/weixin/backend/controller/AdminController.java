package com.weixin.backend.controller;

import com.weixin.backend.entity.Schedule;
import com.weixin.backend.service.ScheduleService;
import com.weixin.backend.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
//    @Autowired
//    ScheduleService scheduleService;

    @ApiOperation(value = "api for test", notes = "test")
    @ApiImplicitParam(value = "id", name = "admin id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result test() {
        return new Result();
    }

//    @ApiOperation(value = "Add schedule", notes = "Create schedule based on film id and show date")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "Film id", required = true, dataType = "int", paramType = "path"),
//            @ApiImplicitParam(name = "date", value = "Show date", required = true, dataType = "Date", paramType = "path")
//    })
//    @RequestMapping(value = "schedules/{id}", method = RequestMethod.POST)
//    public Result addSchedule(@PathVariable int id,
//                              @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
//        scheduleService.save(new Schedule(id, date));
//    }
//
//    @ApiOperation(value = "Delete Schedule", notes = "Delete schedule by film id and date")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "Film id", required = true, dataType = "int", paramType = "path"),
//            @ApiImplicitParam(name = "date", value = "Show date", required = true, dataType = "Date", paramType = "path")
//    })
//    @RequestMapping(value = "schedules/{id}", method = RequestMethod.DELETE)
//    public Result deleteSchedule(@PathVariable int id,
//                                 @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
//        scheduleService.deleteSchedule(id, date);
//    }
//
//    @ApiOperation(value = "Modify schedule", notes = "Modify schedule via schedule id")
//    @ApiImplicitParam(name = "id", value = "Schedule id", required = true, dataType = "int", paramType = "path")
//    @RequestMapping(value = "schedules/{id}", method = RequestMethod.POST)
//    public Result modifySchedule() {}
//
//    @ApiOperation(value = "Get all schedule", notes = "")
//    @RequestMapping(method = RequestMethod.GET)
//    public Result getSchedule() {
//        scheduleService.findAll();
//    }
//
//    @ApiOperation(value = "Get seating of audience", notes = "")
//    @RequestMapping(value = "/audiences", method = RequestMethod.GET)
//    public Result getAudience() {}
}
