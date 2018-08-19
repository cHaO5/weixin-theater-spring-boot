package com.weixin.backend.service;

import com.weixin.backend.dao.ScheduleRepository;
import com.weixin.backend.entity.Movie;
import com.weixin.backend.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public Movie findByDate(Date date) {
        scheduleRepository.getByDate(date);
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public boolean save(Schedule s) {
        scheduleRepository.save(s);
    }

    public boolean deleteSchedule(int movieId, Date date) {
        return scheduleRepository.deleteByMovieIdAndDate(movieId, date);
    }
}
