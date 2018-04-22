package com.weixin.backend.service;

import com.weixin.backend.dao.SeatRepository;
import com.weixin.backend.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SeatService {
    @Autowired
    SeatRepository seatRepository;

    public void reserveSeat(String id, String seat, Date date) {}

    public void cancellation(String id, String seat, Date date) {}

    public List<Seat> findReservation(String userId) {
        return seatRepository.findByUserId(userId);
    }
}
