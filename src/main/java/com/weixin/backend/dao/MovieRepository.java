package com.weixin.backend.dao;

import com.weixin.backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findById(int id);

    Movie findMovieThisWeek(Date start, Date end);

    @Query("select m from Movie m, Schedule s where s.date < ?1 and m.id = s.movieId")
    List<Movie> findPreMovies(Date date);

    List<Movie> findByStarGreaterThan(float star);

//    List<Movie> recommendation() {}

    @Query("select m from Movie m, Schedule s where s.userId = id " +
            "and s.state = 1 and s.movieId = m.id")
    List<Movie> findWatchedMovie(String id);
}
