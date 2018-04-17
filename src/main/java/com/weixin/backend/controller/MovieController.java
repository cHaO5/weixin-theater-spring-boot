package com.weixin.backend.controller;

import com.weixin.backend.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class MovieController {

    @RequestMapping(value = "")
    public Result movieThisWeek() {}

    @RequestMapping(value = "")
    public Result mostPopular() {}

    @RequestMapping(value = "")
    public Result recommendation() {}

}
