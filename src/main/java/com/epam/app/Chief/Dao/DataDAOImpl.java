package com.epam.app.Chief.Dao;

import com.epam.app.Chief.Enums.Taste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public class DataDAOImpl implements DataDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Double getWeightrById(String id) {
        return jdbcTemplate.queryForObject("select weight from table where id=?", new Object[]{id}, Double.class);
    }

    @Override
    public Taste getTasteById(String id) {
        return jdbcTemplate.queryForObject("select taste from table where id=?", new Object[]{id}, Taste.class);
    }
}
