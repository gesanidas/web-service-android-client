package com.example.gesanidas.company;

/**
 * Created by gesanidas on 4/9/2017.
 */

public class Skill
{
    int skillID;
    int employeeID;
    String description;

    public Skill(int skillID, int employeeID, String description) {
        this.skillID = skillID;
        this.employeeID = employeeID;
        this.description = description;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
