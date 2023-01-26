package com.deliverybusiness.controller;

import com.deliverybusiness.model.Weekday;
import com.deliverybusiness.service.WeekdayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/WeekDay")
public class WeekdayController {

    private WeekdayServiceImpl weekdayService;

    @Autowired
    public WeekdayController(WeekdayServiceImpl weekdayService) {
        this.weekdayService = weekdayService;
    }
    @RequestMapping(method = RequestMethod.GET,produces = "application/json ")
    public List<Weekday> getAll(){
        return weekdayService.findAll();
    }
}
