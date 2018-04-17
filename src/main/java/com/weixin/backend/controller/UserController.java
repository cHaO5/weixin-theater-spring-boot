package com.weixin.backend.controller;

import com.weixin.backend.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class UserController {

    @RequestMapping(value = "")
    public Result watchedMovies() {}

    @RequestMapping(value = "")
    public Result reservationInfo() {}

    @RequestMapping(value = "")
    public Result info() {}
}
