package com.weixin.backend.dao;

import com.weixin.backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findById(String id);

    @Query("select m from Movie m, Schedule s where s.date between ?1 and ?2")
    Movie findByDateBetween(Date start, Date end);

    @Query("select m from Movie m, Schedule s where s.date < ?1 and m.id = s.movieId")
    List<Movie> findPreMovies(Date date);

    List<Movie> findByStarGreaterThan(float star);

//    List<Movie> recommendation() {}

    @Transactional
    @Query("select m from Movie m, Schedule s, Reservation r where s.id = r.scheduleId " +
            "and r.userId = ?1 and s.state = 1 and s.movieId = m.id")
    List<Movie> findWatchedMovie(String id);
}
