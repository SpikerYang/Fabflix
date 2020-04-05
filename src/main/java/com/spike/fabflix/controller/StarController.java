package com.spike.fabflix.controller;

import com.spike.fabflix.entities.Star;
import com.spike.fabflix.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


/**
 * @Author spike
 * @Date: 2020-04-01 22:06
 */
@RestController
public class StarController {
    @Autowired
    StarService starService;


    @GetMapping(value = "/api/single-star/{id}")
    public Star getSingleStarInfo(@PathVariable("id") String id) {
        return starService.getSingleStarInfoById(id);
    }
}
