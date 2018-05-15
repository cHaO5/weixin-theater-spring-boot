package com.weixin.backend.controller;

import com.sun.scenario.effect.impl.sw.RendererDelegate;
import com.weixin.backend.entity.Seat;
import com.weixin.backend.request.SeatModel;
import com.weixin.backend.service.SeatService;
import com.weixin.backend.util.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(value = "/reservations/{id}")
public class ReservationController {
//    @Autowired
//    SeatService seatService;

//    @ApiOperation(value = "Reserve seat", notes = "Reserve seat for user")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "User id", required = true, dataType = "String", paramType = "path"),
//            @ApiImplicitParam(name = "seat", value = "Theater seat", required = true, dataType = "SeatModel", paramType = "body")
//    })
//    @RequestMapping(method = RequestMethod.POST)
//    public Result reserveSeat(@PathVariable String id,
//                              @RequestBody SeatModel seat) {
//        seatService.reserveSeat(id, seat.getSeat(), seat.getDate());
//    }
//
//    @ApiOperation(value = "Cancel reservation", notes = "Cancel reservation for user")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "User id", required = true, dataType = "String", paramType = "path"),
//            @ApiImplicitParam(name = "seat", value = "Theater seat", required = true, dataType = "SeatModel", paramType = "body")
//    })
//    @RequestMapping(method = RequestMethod.DELETE)
//    public Result cancellation(@PathVariable String id,
//                               @RequestBody SeatModel seat) {
//        seatService.cancellation(id, seat.getSeat(), seat.getDate());
//    }
}
