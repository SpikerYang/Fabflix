package com.spike.fabflix.controller;

import com.spike.fabflix.entities.Movie;
import com.spike.fabflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author spike
 * @Date: 2020-04-03 19:45
 */
@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping(value = "/api/movie-list")
    public List<Movie> getTop20Movie() {
        return movieService.getTop20Movie();
    }

    @GetMapping(value = "/api/single-movie/{id}")
    public Movie getSingleMovieById(@PathVariable("id") String id) {
        return movieService.getSingleMovieById(id);
    }
}
