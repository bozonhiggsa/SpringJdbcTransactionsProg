package com.springApp.springJdbcTransactionsProg.dao.jdbc;

import com.springApp.springJdbcTransactionsProg.dao.ProjectDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Implementation Project DAO based on JdbcTemplate and TransactionTemplate
 * @author Ihor Savchenko
 * @version 1.0
 */
public class JdbcTemplateProjectDaoImpl implements ProjectDao {

    private JdbcTemplate jdbcTemplate;

    private TransactionTemplate transactionTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void createProject(final Integer developerId, final String projectName, final String companyName) {

        final String SQL = "INSERT INTO PROJECTS (DEVELOPERS_ID, NAME, COMPANY) VALUES (?,?,?)";

        transactionTemplate.execute(new TransactionCallback<Void>() {

            public Void doInTransaction(TransactionStatus status) {
                try{
                    jdbcTemplate.update(SQL, developerId, projectName, companyName);
                    System.out.println("Project record created successfully. Project name: " +
                            projectName + ", Company: " + companyName + "\n");
                    System.out.println("Status - transaction is completed: " + status.isCompleted());
                    System.out.println("Status - transaction has savepoint: " + status.hasSavepoint());
                    System.out.println("Status - transaction is new: " + status.isNewTransaction());
                    System.out.println("Status - transaction is rollback-only: " + status.isRollbackOnly());
                }
                catch (RuntimeException e){
                    status.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }
}
