package com.weixin.backend.controller;

import com.weixin.backend.service.SeatService;
import com.weixin.backend.service.UserMovieService;
import com.weixin.backend.service.UserService;
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
    UserService userService;

    @Autowired
    UserMovieService userMovieService;

    @Autowired
    SeatService seatService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result getInfo(@PathVariable String id) {
        userService.getUser(id);
    }

    @RequestMapping(value = "{id}/movies", method = RequestMethod.GET)
    public Result watchedMovies(@PathVariable String id) {
        userMovieService.findMovies(id);
    }

    @RequestMapping(value = "{id}/reservation", method = RequestMethod.GET)
    public Result reservationInfo(@PathVariable String id) {
        seatService.findReservation(id);
    }

    //Info about Weixin Theater
    @RequestMapping()
    public Result about() {}
}
