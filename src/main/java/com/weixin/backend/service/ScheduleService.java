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

    public Schedule addSchedule(int movieId, Date date) {
        return scheduleRepository.save(new Schedule(movieId, date));
    }

    public boolean deleteSchedule(int scheduleId) {
        return scheduleRepository.deleteById(scheduleId);
    }

    public boolean updateSchedule(int id, Date date, int movieId) {
        return scheduleRepository.updateSchedule(id, date, movieId);
    }

    public boolean updateScheduleState(int scheduleId, int state) {
        return scheduleRepository.updateScheduleState(scheduleId, state);
    }
}
