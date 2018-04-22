package com.weixin.backend.controller;

import com.sun.scenario.effect.impl.sw.RendererDelegate;
import com.weixin.backend.entity.Seat;
import com.weixin.backend.request.SeatModel;
import com.weixin.backend.service.SeatService;
import com.weixin.backend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(value = "/reservations/{id}")
public class ReservationController {
    @Autowired
    SeatService seatService;

    @RequestMapping(method = RequestMethod.POST)
    public Result reserveSeat(@PathVariable String id,
                              @RequestBody SeatModel seat) {
        seatService.reserveSeat(id, seat.getSeat(), seat.getDate());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Result cancellation(@PathVariable String id,
                               @RequestBody SeatModel seat) {
        seatService.cancellation(id, seat.getSeat(), seat.getDate());
    }
}
