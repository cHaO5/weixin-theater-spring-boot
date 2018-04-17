package com.weixin.backend.controller;

import com.weixin.backend.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class ReservationController {

    @RequestMapping(value = "")
    public Result reserveSeat() {}

    @RequestMapping(value = "")
    public Result cancellation() {}
}
