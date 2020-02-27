package com.dss.model;

import com.dss.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("rest/employee")
public class EmployeeResource {

    private EmployeeRepository employeeRepository;

    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/add/{id}/{name}/{salary}")
    public Employee add(@PathVariable("id") final String id,
                        @PathVariable("name") final String name,
                        @PathVariable("salary") final String salary){

        employeeRepository.save(new Employee(id, name, salary));
        return employeeRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}/{salary}")
    public Employee update(@PathVariable("id") final String id,
                        @PathVariable("name") final String name,
                        @PathVariable("salary") final String salary){

        employeeRepository.update(new Employee(id, name, salary));
        return employeeRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String,Employee> all() {
        return employeeRepository.findAll();
    }



}
