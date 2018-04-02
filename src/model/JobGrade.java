/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ignatius
 */
public class JobGrade {
    private String gradeLevel;
    private int lowestSalary;
    private int highestSalary;

    public String getGradeLevel() {
        return gradeLevel;
    }

    public JobGrade() {
    }

    public JobGrade(String gradeLevel, int lowestSalary, int highestSalary) {
        this.gradeLevel = gradeLevel;
        this.lowestSalary = lowestSalary;
        this.highestSalary = highestSalary;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public int getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(int lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public int getHighestSalary() {
        return highestSalary;
    }

    public void setHighestSalary(int highestSalary) {
        this.highestSalary = highestSalary;
    }
    
}
