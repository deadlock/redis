package com.dss.repositories;

import com.dss.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    Map<String, Employee> findAll();

    Employee findById(String id);

    void save(Employee employee);

    void update(Employee employee);

    void delete(String id);
}
