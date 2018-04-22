package com.weixin.backend.controller;

import com.weixin.backend.service.UserMovieService;
import com.weixin.backend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserMovieService userMovieService;

    @RequestMapping(value = "/{id}/movies", method = RequestMethod.GET)
    public Result watchedMovies(@PathVariable String id) {
        userMovieService.
    }

    @RequestMapping(value = "")
    public Result reservationInfo() {}

    @RequestMapping(value = "")
    public Result info() {}
}
