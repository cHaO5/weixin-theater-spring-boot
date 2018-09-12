package com.weixin.backend.dao;

import com.weixin.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserId(String userId);

    boolean deleteById(int id);

    List<Reservation> findByDate(Date date);

    Reservation findById(int id);

    List<Reservation> findByScheduleId(int scheduleId);

    @Query("update Reservation set seat = ?2, date = ?3 where id = ?1")
    boolean updateReservation(int id, String seat, Date date);
}
