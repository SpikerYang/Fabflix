package com.spike.fabflix.dao;

import com.spike.fabflix.entities.Movie;

import java.util.List;

/**
 * @Author spike
 * @Date: 2020-04-03 19:47
 */
public interface MovieDao {
    List<Movie> getTop20Movie();
    Movie getSingleMovieById(String id);
}
