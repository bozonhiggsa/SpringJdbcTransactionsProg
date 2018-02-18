package com.springApp.springJdbcTransactionsProg;

import com.springApp.springJdbcTransactionsProg.dao.jdbc.JdbcTemplateDeveloperDaoImpl;
import com.springApp.springJdbcTransactionsProg.dao.jdbc.JdbcTemplateProjectDaoImpl;
import com.springApp.springJdbcTransactionsProg.model.Developer;
import com.springApp.springJdbcTransactionsProg.model.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Entry point
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ApplicationRunner {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("jdbc_developer_config.xml");

        JdbcTemplateDeveloperDaoImpl jdbcTemplateDeveloperDao =
                (JdbcTemplateDeveloperDaoImpl) context.getBean("jdbcTemplateDeveloperDao");
        JdbcTemplateProjectDaoImpl jdbcTemplateProjectDao =
                (JdbcTemplateProjectDaoImpl) context.getBean("jdbcTemplateProjectDao");

        System.out.println("======== Creating project's records ========");
        jdbcTemplateProjectDao.createProject(2, "Project 1", "company 1");
        jdbcTemplateProjectDao.createProject(2, "Project 2", "company 2");

        System.out.println("========Creating developer's records========");
        jdbcTemplateDeveloperDao.createDeveloper("Oleg", "Java Developer", 3);
        jdbcTemplateDeveloperDao.createDeveloper("Stas", "C++ Developer", 2);
        jdbcTemplateDeveloperDao.createDeveloper("Olga", "Front-end Developer", 4);

        System.out.println("========List of Developers========");
        List<Developer> developers = jdbcTemplateDeveloperDao.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }

        System.out.println("======== Developer's Projects ========");
        List<Project> projects = jdbcTemplateDeveloperDao.listDevelopersProjects(2);
        for (Project project : projects) {
            System.out.println(project);
        }

    }
}
