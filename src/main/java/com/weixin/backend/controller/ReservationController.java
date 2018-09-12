package com.weixin.backend.controller;

import com.weixin.backend.entity.Reservation;
import com.weixin.backend.request.SeatModel;
import com.weixin.backend.service.ReservationService;
import com.weixin.backend.util.Result;
import com.weixin.backend.util.ResultCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    // for admin
    // get reservation by date
    @RequestMapping(method = RequestMethod.GET)
    public Result getReservationByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        List<Reservation> reservation = reservationService.findByDate(date);
        if (reservation != null) {
            return new Result(ResultCode.SUCCESS, reservation);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    // for users to check their  res history
    @RequestMapping(value = "/{id}/all", method = RequestMethod.GET)
    public Result getAllReservationByUserId(@RequestParam String id) {
        List<Reservation> reservations = reservationService.findAllByUserId(id);
        if (reservations != null) {
            return new Result(ResultCode.SUCCESS, reservations);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    // return single res info
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getReservationByUserId(@RequestParam int id) {
        Reservation reservation = reservationService.findById(id);
        if (reservation != null) {
            return new Result(ResultCode.SUCCESS, reservation);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }

    // user id
    @ApiOperation(value = "Reserve seat", notes = "Reserve seat for user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Reservation id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "seat", value = "Theater seat", required = true, dataType = "SeatModel", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Result addReservation(@PathVariable String id,
                                 @RequestParam String seat,
                                 @RequestParam int scheduleId) {
        Reservation res = reservationService.addReservation(id, seat, scheduleId);
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
        boolean reservation = reservationService.updateReservation(id, seat, date);
        if (reservation) {
            return new Result(ResultCode.SUCCESS, reservation);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    // id here is reservation id
    @ApiOperation(value = "Cancel reservation", notes = "Cancel reservation for user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Reservation id", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "seat", value = "Theater seat", required = true, dataType = "SeatModel", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result cancellation(@PathVariable int id) {
        boolean res = reservationService.cancellation(id);
        if (res) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.SYS_ERROR);
        }
    }

    // return certain reservation tables of a schedule
    @RequestMapping(value = "/schedules/{id}/reservations", method = RequestMethod.GET)
    public Result checkReservation(@PathVariable int id) {
        List<Reservation> reservations = reservationService.findResBySchId(id);
        if (reservations != null) {
            return new Result(ResultCode.SUCCESS, reservations);
        } else {
            return new Result(ResultCode.NOT_FOUND);
        }
    }
}
