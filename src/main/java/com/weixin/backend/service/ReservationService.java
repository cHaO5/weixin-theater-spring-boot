package com.weixin.backend.service;

import com.weixin.backend.entity.Reservation;

import java.sql.Date;
import java.util.List;

public interface ReservationService {
    Reservation addReservation(String userId, String seat, int scheduleId);

    boolean cancellation(int id);

    List<Reservation> findAllByUserId(String userId);

    List<Reservation> findByDate(Date date);

    Reservation findById(int id);

    List<Reservation> findResBySchId(int id);

    boolean updateReservation(int id, String seat, Date date);
}
