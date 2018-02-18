package com.springApp.springJdbcTransactionsProg.dao.jdbc;

import com.springApp.springJdbcTransactionsProg.dao.DeveloperDao;
import com.springApp.springJdbcTransactionsProg.model.Developer;
import com.springApp.springJdbcTransactionsProg.model.Project;
import com.springApp.springJdbcTransactionsProg.util.DeveloperMapper;
import com.springApp.springJdbcTransactionsProg.util.ProjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * Implementation Developer DAO based on JdbcTemplate and  TransactionManager
 * @author Ihor Savchenko
 * @version 1.0
 */
public class JdbcTemplateDeveloperDaoImpl implements DeveloperDao {

    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void createDeveloper(String name, String speciality, Integer experience) {

        DefaultTransactionDefinition definition =
                new DefaultTransactionDefinition();
        //definition.setIsolationLevel(8);
        definition.setIsolationLevelName("ISOLATION_Serializable");
        //definition.setPropagationBehavior(0);
        definition.setPropagationBehaviorName("PROPAGATION_Required");
        TransactionStatus status = transactionManager.getTransaction(definition);
        System.out.println("Status - transaction is completed: " + status.isCompleted());
        System.out.println("Status - transaction has savepoint: " + status.hasSavepoint());
        System.out.println("Status - transaction is new: " + status.isNewTransaction());
        System.out.println("Status - transaction is rollback-only: " + status.isRollbackOnly());
        System.out.println("Definition - transaction has propagation behaviour: " + definition.getPropagationBehavior());
        System.out.println("Definition - transaction has isolation level: " + definition.getIsolationLevel());
        System.out.println("Definition - transaction has timeout: " + definition.getTimeout());

        String SQL = "INSERT INTO DEVELOPERS (name, speciality, experience) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, speciality, experience);
        System.out.println("Developer successfully created.\nName: " + name + ";\nSpeciality: " +
                speciality + ";\nExperience: " + experience + "\n");
        transactionManager.commit(status);
        System.out.println("Status - transaction is completed: " + status.isCompleted());

    }

    public List<Developer> listDevelopers() {
        String SQL = "SELECT * FROM DEVELOPERS";
        List<Developer> developers = jdbcTemplate.query(SQL, new DeveloperMapper());
        return developers;
    }

    public List<Project> listDevelopersProjects(Integer id) {
        String SQL = "SELECT * FROM PROJECTS WHERE DEVELOPERS_ID = " + id;
        List<Project> projectList = jdbcTemplate.query(SQL, new ProjectMapper());
        return projectList;
    }


}
