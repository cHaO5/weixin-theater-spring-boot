package com.weixin.backend.controller;

import com.weixin.backend.entity.Reservation;
import com.weixin.backend.entity.Schedule;
import com.weixin.backend.service.ReservationService;
import com.weixin.backend.service.ScheduleService;
import com.weixin.backend.util.Result;
import com.weixin.backend.util.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    ScheduleService scheduleService;

    @ApiOperation(value = "api for test", notes = "test")
    @ApiImplicitParam(value = "id", name = "admin id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result test() {
        return new Result();
    }

    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.GET)
    public Result getScheduleById(@PathVariable int id) {
        Schedule schedule = scheduleService.findById(id);
        if (schedule != null) {
            return new Result(ResultCode.SUCCESS, schedule);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public Result getSchedule() {
        List<Schedule> schedules = scheduleService.findAll();
        if (schedules != null) {
            return new Result(ResultCode.SUCCESS, schedules);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Add schedule", notes = "Create schedule based on film id and show date")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Film id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "date", value = "Show date", required = true, dataType = "Date", paramType = "path")
    })
    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.POST)
    public Result addSchedule(@PathVariable int movieId,
                              @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        Schedule res = scheduleService.addSchedule(movieId, date);
        if (res != null) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    @ApiOperation(value = "Delete Schedule", notes = "Delete schedule by film id and date")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Film id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "date", value = "Show date", required = true, dataType = "Date", paramType = "path")
    })
    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.DELETE)
    public Result deleteSchedule(@PathVariable int scheduleId) {
        boolean res = scheduleService.deleteSchedule(scheduleId);
        if (res) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    @ApiOperation(value = "Modify schedule", notes = "Modify schedule via schedule id")
    @ApiImplicitParam(name = "id", value = "Schedule id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/schedules/{id}", method = RequestMethod.PUT)
    public Result modifySchedule(@PathVariable int id,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date,
                                 @RequestParam int movieId) {
        boolean schedule = scheduleService.updateSchedule(id, date, movieId);
        if (schedule) {
            return new Result(ResultCode.SUCCESS, schedule);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    // if the schedule is finished
    @RequestMapping(value = "/schedules/{id}/state/{state}", method = RequestMethod.GET)
    public Result refreshState(@PathVariable int scheduleId,
                               @PathVariable int state) {
        boolean res = scheduleService.updateScheduleState(scheduleId, state);
        if (res) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

//    @ApiOperation(value = "Get seating of audience", notes = "")
//    @RequestMapping(value = "/audiences", method = RequestMethod.GET)
//    public Result export() {}
}
