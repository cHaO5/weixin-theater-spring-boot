package com.weixin.backend.controller;

import com.weixin.backend.entity.Reservation;
import com.weixin.backend.service.impl.ReservationServiceImpl;
import com.weixin.backend.util.Result;
import com.weixin.backend.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {
    @Autowired
    ReservationServiceImpl reservationServiceImpl;

    // for admin
    // get reservation by date
    @RequestMapping(method = RequestMethod.GET)
    public Result getReservationByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        List<Reservation> reservation = reservationServiceImpl.findByDate(date);
        if (reservation != null) {
            return new Result(ResultCode.SUCCESS, reservation);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    // for users to check their  res history
    @RequestMapping(value = "/{id}/all", method = RequestMethod.GET)
    public Result getAllReservationByUserId(@RequestParam String id) {
        List<Reservation> reservations = reservationServiceImpl.findAllByUserId(id);
        if (reservations != null) {
            return new Result(ResultCode.SUCCESS, reservations);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    // return single res info
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getReservationByUserId(@RequestParam int id) {
        Reservation reservation = reservationServiceImpl.findById(id);
        if (reservation != null) {
            return new Result(ResultCode.SUCCESS, reservation);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    // user id
   @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Result addReservation(@PathVariable String id,
                                 @RequestParam String seat,
                                 @RequestParam int scheduleId) {
        Reservation res = reservationServiceImpl.addReservation(id, seat, scheduleId);
        if (res != null) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    // user change reservation info
    // id here is reservation id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result updateReservation(@PathVariable int id,
                                    @RequestParam String seat) {
        Date date = new Date(System.currentTimeMillis());
        boolean reservation = reservationServiceImpl.updateReservation(id, seat, date);
        if (reservation) {
            return new Result(ResultCode.SUCCESS, reservation);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    // id here is reservation id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result cancellation(@PathVariable int id) {
        boolean res = reservationServiceImpl.cancellation(id);
        if (res) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    // return certain reservation tables of a schedule
    @RequestMapping(value = "/schedules/{id}/reservations", method = RequestMethod.GET)
    public Result checkReservation(@PathVariable int id) {
        List<Reservation> reservations = reservationServiceImpl.findResBySchId(id);
        if (reservations != null) {
            return new Result(ResultCode.SUCCESS, reservations);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }
}
