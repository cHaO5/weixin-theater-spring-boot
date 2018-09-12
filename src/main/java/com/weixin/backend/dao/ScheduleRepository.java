package com.weixin.backend.dao;

import com.weixin.backend.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findById(int id);

    List<Schedule> findAll();

    boolean deleteById(int id);

    @Query("update Schedule set date = ?1, movieId = ?3 where id = ?1")
    boolean updateSchedule(int id, Date date, String movieId);

    @Query("update Schedule set state = ?2 where id = ?1")
    boolean updateScheduleState(int schedule, int state);
}
