package com.springApp.springJdbcTransactionsProg.dao;

import com.springApp.springJdbcTransactionsProg.model.Developer;
import com.springApp.springJdbcTransactionsProg.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Interface for Developer DAO
 * @author Ihor Savchenko
 * @version 1.0
 */
public interface DeveloperDao {

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    void createDeveloper(String name, String speciality, Integer experience);

    List<Developer> listDevelopers();

    List<Project> listDevelopersProjects(Integer id);

}
