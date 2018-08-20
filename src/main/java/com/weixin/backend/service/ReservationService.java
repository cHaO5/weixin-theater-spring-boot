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

    public boolean cancellation(int id) {
        reservationRepository.deleteByUserIdAndSeatAndDate(id);
    }

    public List<Reservation> findReservation(String userId) {
        return reservationRepository.findByUserId(userId);
    }

    public List<Reservation> findByDate(Date date) {
        return reservationRepository.findByDate(date);
    }

    public List<Reservation> findAllByUserId(String id) {
        return reservationRepository.findAddByUserId(id);
    }

    public Reservation findByUserId(String id) {
        return reservationRepository.findAddByUserId(id);
    }

    public List<Reservation> findResBySchId(int id) {
        return reservationRepository.findResBySchId(id);
    }

    public boolean addReservation(String id, String seat, Date date) {
        reservationRepository.addReservation(id, seat, date);
    }

    public Reservation updateReservation(int id, String seat, Date date) {
        return reservationRepository.updateReservation(id, seat, date);
    }
}
