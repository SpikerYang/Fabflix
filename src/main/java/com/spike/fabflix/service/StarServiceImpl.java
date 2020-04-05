package com.spike.fabflix.service;

import com.spike.fabflix.dao.StarDaoImpl;
import com.spike.fabflix.entities.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author spike
 * @Date: 2020-04-01 23:14
 */
@Service
public class StarServiceImpl implements StarService{
    @Autowired
    private StarDaoImpl starDao;

    @Override
    public Star getSingleStarInfoById(String id) {
        return starDao.getSingleStarInfoById(id);
    }
}
