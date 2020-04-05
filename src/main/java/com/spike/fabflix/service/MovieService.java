package com.spike.fabflix.service;

import com.spike.fabflix.dao.MovieDao;
import com.spike.fabflix.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author spike
 * @Date: 2020-04-03 20:58
 */
public interface MovieService {
    List<Movie> getTop20Movie();
    Movie getSingleMovieById(String id);
}
