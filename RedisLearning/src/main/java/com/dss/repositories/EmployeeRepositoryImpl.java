package com.dss.repositories;

import com.dss.model.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private RedisTemplate<String, Employee> redisTemplate;

    private HashOperations hashOperations;

    public EmployeeRepositoryImpl(RedisTemplate<String, Employee> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Employee> findAll() {
        return hashOperations.entries("EMPLOYEE");
    }

    @Override
    public Employee findById(String id) {
        return (Employee) hashOperations.get("EMPLOYEE", id);
    }

    @Override
    public void save(Employee employee) {

        hashOperations.put("EMPLOYEE", employee.getId(), employee);
    }

    @Override
    public void update(Employee employee) {
        save(employee);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("EMPLOYEE", id);
    }
}
