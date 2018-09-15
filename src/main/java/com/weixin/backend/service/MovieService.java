package com.weixin.backend.service;

import com.weixin.backend.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface MovieService {
    Page<Movie> findAll(Pageable pageable);

    Movie findMovieById(String id);

    Movie findMovieByWeek(Date date);

    List<Movie> findPreMovies(Date date);

    Page<Movie> hotMovies(Pageable pageable);

    List<Movie> findWatchedMovies(String id);
}
