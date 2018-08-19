package com.weixin.backend.dao;

import com.weixin.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserId(String userId);

    void deleteByUserIdAndSeatAndDate(String userId, String seat, Date date);
}
