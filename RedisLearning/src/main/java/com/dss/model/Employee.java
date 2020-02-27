package com.dss.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private String id;
    private String name;
    private String Salary;

    public Employee(String id, String name, String salary) {
        this.id = id;
        this.name = name;
        Salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }
}
