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

    public Schedule findById(int id) {
        return scheduleRepository.findById(id);
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public boolean save(Schedule s) {
        return scheduleRepository.save(s);
    }

    public boolean deleteSchedule(int movieId, Date date) {
        return scheduleRepository.deleteByMovieIdAndDate(movieId, date);
    }

    public Schedule updateSchedule(int id, Date date, int movieId) {
        return scheduleRepository.updateSchedule(id, date, movieId);
    }

    public boolean refresh() {
        return scheduleRepository.refresh();
    }
}
