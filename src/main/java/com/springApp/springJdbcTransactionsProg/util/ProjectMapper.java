package com.springApp.springJdbcTransactionsProg.util;

import com.springApp.springJdbcTransactionsProg.model.Project;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper for Project
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ProjectMapper implements RowMapper<Project> {

    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();

        project.setDevelopersId(rs.getInt("DEVELOPERS_ID"));
        project.setProjectName(rs.getString("NAME"));
        project.setCompanyName(rs.getString("COMPANY"));

        return project;
    }
}
