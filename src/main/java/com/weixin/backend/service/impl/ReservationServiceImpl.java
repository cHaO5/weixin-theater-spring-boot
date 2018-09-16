package com.weixin.backend.service.impl;

import com.weixin.backend.dao.ReservationRepository;
import com.weixin.backend.entity.Reservation;
import com.weixin.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(String userId, String seat, int scheduleId) {
        return reservationRepository.save(new Reservation(userId, seat, scheduleId));
    }

    @Override
    public boolean cancellation(int id) {
        return reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findAllByUserId(String userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> findByDate(Date date) {
        return reservationRepository.findByDate(date);
    }

    @Override
    public Reservation findById(int id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findResBySchId(int id) {
        return reservationRepository.findByScheduleId(id);
    }

    @Override
    public boolean updateReservation(int id, String seat, Date date) {
        return reservationRepository.updateReservation(id, seat, date);
    }
}
