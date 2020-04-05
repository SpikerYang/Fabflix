package com.spike.fabflix.service;

import com.spike.fabflix.dao.MovieDao;
import com.spike.fabflix.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author spike
 * @Date: 2020-04-03 20:59
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDao movieDao;

    @Override
    public List<Movie> getTop20Movie() {
        return movieDao.getTop20Movie();
    }

    @Override
    public Movie getSingleMovieById(String id) {
        return movieDao.getSingleMovieById(id);
    }
}
