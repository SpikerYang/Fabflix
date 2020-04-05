package com.spike.fabflix.dao;

import com.spike.fabflix.entities.Star;

/**
 * @Author spike
 * @Date: 2020-04-01 23:15
 */
public interface StarDao {
    Star getSingleStarInfoById(String id);
}
