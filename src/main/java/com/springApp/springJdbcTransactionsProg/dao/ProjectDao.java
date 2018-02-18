package com.springApp.springJdbcTransactionsProg.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Interface for Project DAO
 * @author Ihor Savchenko
 * @version 1.0
 */
public interface ProjectDao {

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    void createProject(Integer developersId, String projectName, String companyName);

}
