package com.spike.fabflix.dao;

import com.spike.fabflix.entities.Genre;
import com.spike.fabflix.entities.Movie;
import com.spike.fabflix.entities.Star;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author spike
 * @Date: 2020-04-03 19:47
 */
@Repository
public class MovieDaoImpl implements MovieDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(StarDaoImpl.class);

    @Override
    public List<Movie> getTop20Movie() {
        String sql1 = "SELECT m.id, m.title, m.year, m.director, r.rating from movies m, ratings r where m.id = r.movieId order by r.rating desc limit 20;";
        String sql2 = "SELECT s.id, s.name from stars s, stars_in_movies sim where sim.movieId = ? and s.id = sim.starId limit 3;";
        String sql3 = "SELECT g.id, g.name from genres g, genres_in_movies gim where gim.movieId = ? and g.id = gim.genreId limit 3;";
        List<Movie> movies = null;
        try {
            // populate movie info
            movies = jdbcTemplate.query(sql1, (rs, rowNum) ->
                    new Movie(
                            rs.getString("id"),
                            rs.getString("title"),
                            rs.getInt("year"),
                            rs.getString("director"),
                            rs.getDouble("rating")
                    ));

            // populate first 3 stars and genres for each movie
            List stars, genres;
            for (Movie m : movies) {
                stars = jdbcTemplate.query(sql2, new Object[]{m.getId()}, (rs, rowNum) ->
                        new Star(
                                rs.getString("id"),
                                rs.getString("name")
                        ));
                genres = jdbcTemplate.query(sql3, new Object[]{m.getId()}, (rs, rowNum) ->
                        new Genre(
                                rs.getInt("id"),
                                rs.getString("name")
                        ));
                m.setStars(stars);
                m.setGenres(genres);
            }
            log.info("====> query top 20 movies: " + movies.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getSingleMovieById(String id) {
        Movie movie = null;
        String sql1 = "SELECT m.id, m.title, m.year, m.director, r.rating from movies m, ratings r where m.id = ? and m.id = r.movieId;";
        String sql2 = "SELECT s.id, s.name from stars s, stars_in_movies sim where sim.movieId = ? and s.id = sim.starId;";
        String sql3 = "SELECT g.id, g.name from genres g, genres_in_movies gim where gim.movieId = ? and g.id = gim.genreId;";
        try {
            movie = jdbcTemplate.queryForObject(sql1, new Object[]{id}, (rs, rowNum) ->
                    new Movie(
                            rs.getString("id"),
                            rs.getString("title"),
                            rs.getInt("year"),
                            rs.getString("director"),
                            rs.getDouble("rating")
                    ));
            List stars = jdbcTemplate.query(sql2, new Object[]{id}, (rs, rowNum) ->
                    new Star(
                            rs.getString("id"),
                            rs.getString("name")
                    ));
            List genres = jdbcTemplate.query(sql3, new Object[]{id}, (rs, rowNum) ->
                    new Genre(
                            rs.getInt("id"),
                            rs.getString("name")
                    ));
            movie.setStars(stars);
            movie.setGenres(genres);
            log.info("====> query single movie info: " + movie.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }
}
