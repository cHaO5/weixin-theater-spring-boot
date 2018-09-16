package com.weixin.backend.service.impl;

import com.weixin.backend.dao.MovieRepository;
import com.weixin.backend.entity.Movie;
import com.weixin.backend.service.MovieService;
import com.weixin.backend.util.CalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public Movie findMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie findMovieByWeek(Date date) {
        return movieRepository.findByDateBetween(CalDate.getMonday(date), CalDate.getNextMonday(date));
    }

    @Override
    public List<Movie> findPreMovies(Date date) {
        return movieRepository.findPreMovies(date);
    }

    @Override
    public Page<Movie> hotMovies(Pageable pageable) {
        return movieRepository.findByStarGreaterThan(9, pageable);
    }

//    public List<Movie> recommendation() {
//        return movieRepository.recommendation();
//    }

    @Override
    @Transactional
    public List<Movie> findWatchedMovies(String id) {
        return movieRepository.findWatchedMovie(id);
    }
}
