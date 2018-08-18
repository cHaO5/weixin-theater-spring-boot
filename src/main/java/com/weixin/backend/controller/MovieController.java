package com.weixin.backend.controller;

import com.weixin.backend.service.MovieService;
import com.weixin.backend.service.ScheduleService;
import com.weixin.backend.util.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    ScheduleService scheduleService;

    public Result getMovie() {}

    @ApiOperation(value = "Movie to be shown in this week", notes = "")
    @ApiImplicitParam()
    @RequestMapping(method = RequestMethod.GET)
    public Result movieThisWeek(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        scheduleService.findByDate(date);
    }

    public Result previousMovis() {}

    @ApiOperation(value = "Most popular movies", notes = "Based on rate")
    @RequestMapping(value = "")
    public Result hot() {}

    @ApiOperation(value = "Recommended movies", notes = "From Weixin Theater")
    @RequestMapping(value = "")
    public Result recommendation() {}

}
