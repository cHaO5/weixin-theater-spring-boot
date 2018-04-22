package com.weixin.backend.dao;

import com.weixin.backend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
