package com.spike.fabflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @Author spike
 * @Date: 2020-04-03 18:14
 */
@Controller
public class pageController {
    @GetMapping(value = "/")
    public String getIndex() {
        return "index";
    }

    @GetMapping(value = "/star")
    public String getStar() {
        return "single-star";
    }
}
