package com.springApp.springJdbcTransactionsProg.util;

import com.springApp.springJdbcTransactionsProg.model.Developer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper for Developer
 * @author Ihor Savchenko
 * @version 1.0
 */
public class DeveloperMapper implements RowMapper<Developer> {

    public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Developer developer = new Developer();
        developer.setId(rs.getInt("id"));
        developer.setName(rs.getString("name"));
        developer.setSpeciality(rs.getString("speciality"));
        developer.setExperience(rs.getInt("experience"));
        return developer;
    }
}
