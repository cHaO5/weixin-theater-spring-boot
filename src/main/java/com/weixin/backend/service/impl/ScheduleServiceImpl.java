package com.weixin.backend.service.impl;

import com.weixin.backend.dao.ScheduleRepository;
import com.weixin.backend.entity.Movie;
import com.weixin.backend.entity.Schedule;
import com.weixin.backend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule findById(int id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule addSchedule(int movieId, Date date) {
        return scheduleRepository.save(new Schedule(movieId, date));
    }

    @Override
    public boolean deleteSchedule(int scheduleId) {
        return scheduleRepository.deleteById(scheduleId);
    }

    @Override
    public boolean updateSchedule(int id, Date date, String movieId) {
        return scheduleRepository.updateSchedule(id, date, movieId);
    }

    @Override
    public boolean updateScheduleState(int scheduleId, int state) {
        return scheduleRepository.updateScheduleState(scheduleId, state);
    }
}
