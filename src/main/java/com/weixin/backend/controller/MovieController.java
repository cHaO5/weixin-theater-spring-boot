package com.weixin.backend.controller;

import com.weixin.backend.entity.Movie;
import com.weixin.backend.service.MovieService;
import com.weixin.backend.service.ScheduleService;
import com.weixin.backend.util.Result;
import com.weixin.backend.util.ResultCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getMovie(@PathVariable int id) {
        Movie movie = movieService.findMovieById(id);
        if (movie != null) {
            return new Result(ResultCode.SUCCESS, movie);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Movie to be shown in this week", notes = "")
    @ApiImplicitParam()
    @RequestMapping(method = RequestMethod.GET)
    public Result movieThisWeek(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        Movie movie = movieService.findMovieByWeek(date);
        if (movie != null) {
            return new Result(ResultCode.SUCCESS, movie);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/previous", method = RequestMethod.GET)
    public Result previousMovis(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        List<Movie> movies = movieService.findPreMovies(date);
        if (movies != null) {
            return new Result(ResultCode.SUCCESS, movies);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Most popular movies", notes = "Based on rate")
    @RequestMapping(value = "/hot")
    public Result hot() {
        List<Movie> movies = movieService.hotMovies();
        if (movies != null) {
            return new Result(ResultCode.SUCCESS, movies);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Recommended movies", notes = "From Weixin Theater")
    @RequestMapping(value = "/recommendation")
    public Result recommendation() {
        List<Movie> movies = movieService.recommendation();
        if (movies != null) {
            return new Result(ResultCode.SUCCESS, movies);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get films have been watched", notes = "via User id")
    @ApiImplicitParam(name = "id", value = "User id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Result watched(@PathVariable String id) {
        List<Movie> movies = movieService.findWatchedMovies(id);
        if (movies != null) {
            return new Result(ResultCode.SUCCESS, movies);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }
}
