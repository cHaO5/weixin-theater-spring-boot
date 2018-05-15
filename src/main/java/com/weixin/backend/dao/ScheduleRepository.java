package com.weixin.backend.dao;

import com.weixin.backend.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
//    List<Schedule> findByUserId(int userId);
//
//    Schedule getByDate(Date date);
//
//    int deleteByMovieIdAndDate(int movieId, Date date);
}
