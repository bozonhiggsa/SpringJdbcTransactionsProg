package com.springApp.springJdbcTransactionsProg.model;

/**
 * Model Project
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Project {
    private Integer developersId;
    private String projectName;
    private String companyName;

    public Integer getDevelopersId() {
        return developersId;
    }

    public void setDevelopersId(Integer developersId) {
        this.developersId = developersId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Project:" +
                "\nDeveloper's Id: " + developersId +
                "\nProject name: " + projectName +
                "\nCompanyName: " + companyName + "\n";
    }
}
