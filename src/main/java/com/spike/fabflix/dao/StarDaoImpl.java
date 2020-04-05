package com.spike.fabflix.dao;

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
 * @Date: 2020-04-01 23:16
 */
@Repository
public class StarDaoImpl implements StarDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(StarDaoImpl.class);

    @Override
    public Star getSingleStarInfoById(String id) {
        String sql1 = "SELECT id, name, birthYear from stars where id=?";
        Star star = null;
        try {
            star = jdbcTemplate.queryForObject(sql1, new Object[]{id}, (rs, rowNum) ->
                    new Star(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getInt("birthYear")
                    ));
            String sql2 = "SELECT m.id, m.title, m.year, m.director from stars as s, stars_in_movies as sim, movies as m where m.id = sim.movieId and sim.starId = s.id and s.id=?";
            List movies = jdbcTemplate.query(sql2, new Object[]{id}, (rs, rowNum) ->
                    new Movie(
                            rs.getString("id"),
                            rs.getString("title"),
                            rs.getInt("year"),
                            rs.getString("director")
                    ));
            star.setMovies(movies);
            log.info("====> query single star info: " + star.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return star;
    }
}
