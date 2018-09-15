package com.weixin.backend.controller;

import com.weixin.backend.entity.Movie;
import com.weixin.backend.service.impl.MovieServiceImpl;
import com.weixin.backend.service.impl.ScheduleServiceImpl;
import com.weixin.backend.util.Result;
import com.weixin.backend.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    MovieServiceImpl movieServiceImpl;

    @Autowired
    ScheduleServiceImpl scheduleServiceImpl;

    @RequestMapping(method = RequestMethod.GET)
    public Result getAllMovies(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return new Result(ResultCode.SUCCESS, movieServiceImpl.findAll(pageable));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getMovie(@PathVariable String id) {
        Movie movie = movieServiceImpl.findMovieById(id);
        if (movie != null) {
            return new Result(ResultCode.SUCCESS, movie);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/this", method = RequestMethod.GET)
    public Result movieThisWeek(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        Movie movie = movieServiceImpl.findMovieByWeek(date);
        if (movie != null) {
            return new Result(ResultCode.SUCCESS, movie);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/previous", method = RequestMethod.GET)
    public Result previousMovies() {
        List<Movie> movies = movieServiceImpl.findPreMovies(new Date(System.currentTimeMillis()));
        if (movies != null) {
            return new Result(ResultCode.SUCCESS, movies);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/hot")
    public Result hot(@RequestParam(value = "page", defaultValue = "0") Integer page,
                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "star");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Movie> movies = movieServiceImpl.hotMovies(pageable);
        if (movies != null) {
            return new Result(ResultCode.SUCCESS, movies);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

//    @ApiOperation(value = "Recommended movies", notes = "From Weixin Theater")
//    @RequestMapping(value = "/recommendation")
//    public Result recommendation() {
//        List<Movie> movies = movieService.recommendation();
//        if (movies != null) {
//            return new Result(ResultCode.SUCCESS, movies);
//        } else {
//            return new Result(ResultCode.NOT_FOUND);
//        }
//    }

    // movies watched by user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Result watched(@PathVariable String id) {
        List<Movie> movies = movieServiceImpl.findWatchedMovies(id);
        if (movies != null) {
            return new Result(ResultCode.SUCCESS, movies);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }
}
