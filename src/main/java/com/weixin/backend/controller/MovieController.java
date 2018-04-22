package com.weixin.backend.controller;

import com.weixin.backend.service.MovieService;
import com.weixin.backend.service.ScheduleService;
import com.weixin.backend.util.Result;
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

    @RequestMapping(method = RequestMethod.GET)
    public Result movieThisWeek(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        scheduleService.findByDate(date);
    }

    @RequestMapping(value = "")
    public Result mostPopular() {}

    @RequestMapping(value = "")
    public Result recommendation() {}

}
