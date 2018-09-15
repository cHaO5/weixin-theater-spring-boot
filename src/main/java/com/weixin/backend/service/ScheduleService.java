package com.weixin.backend.service;

import com.weixin.backend.entity.Schedule;

import java.sql.Date;
import java.util.List;

public interface ScheduleService {
    Schedule findById(int id);

    List<Schedule> findAll();

    Schedule addSchedule(int movieId, Date date);

    boolean deleteSchedule(int scheduleId);

    boolean updateSchedule(int id, Date date, String movieId);

    boolean updateScheduleState(int scheduleId, int state);
}
