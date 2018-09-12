package com.weixin.backend.service;

import com.weixin.backend.dao.MovieRepository;
import com.weixin.backend.entity.Movie;
import com.weixin.backend.util.CalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie findMovieById(String id) {
        return movieRepository.findById(id);
    }

    public Movie findMovieByWeek(Date date) {
        return movieRepository.findByDateBetween(CalDate.getMonday(date), CalDate.getNextMonday(date));
    }

    public List<Movie> findPreMovies(Date date) {
        return movieRepository.findPreMovies(date);
    }

    public List<Movie> hotMovies() {
        return movieRepository.findByStarGreaterThan(8);
    }

//    public List<Movie> recommendation() {
//        return movieRepository.recommendation();
//    }

    @Transactional
    public List<Movie> findWatchedMovies(String id) {
        return movieRepository.findWatchedMovie(id);
    }
}
