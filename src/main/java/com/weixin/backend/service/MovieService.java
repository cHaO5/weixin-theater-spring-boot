package com.weixin.backend.service;

import com.weixin.backend.dao.MovieRepository;
import com.weixin.backend.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie findMovieById(int id) {
        return movieRepository.findMovieById(id);
    }

    public Movie findMovieByWeek(Date date) {
        return movieRepository.findMovieByWeek(date);
    }

    public List<Movie> findPreMovies(Date date) {
        return movieRepository.findPreMovies(date);
    }

    public List<Movie> hotMovies() {
        return movieRepository.hotMovies();
    }

    public List<Movie> recommendation() {
        return movieRepository.recommendation();
    }

    public List<Movie> findWatchedMovies(String id) {
        return movieRepository.findWatchedMovies(id);
    }
}
