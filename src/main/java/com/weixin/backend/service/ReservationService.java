package com.weixin.backend.service;

import com.weixin.backend.dao.ReservationRepository;
import com.weixin.backend.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public Reservation reservation(String userId, String seat, Date date) {
        return reservationRepository.save(new Reservation(userId, seat, date));
    }

    public void cancellation(String userId, String seat, Date date) {
        reservationRepository.deleteByUserIdAndSeatAndDate(userId, seat, date);
    }

    public List<Reservation> findReservation(String userId) {
        return reservationRepository.findByUserId(userId);
    }
}
