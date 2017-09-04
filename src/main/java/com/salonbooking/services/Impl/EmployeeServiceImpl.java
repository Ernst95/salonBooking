package com.salonbooking.services.Impl;

import com.salonbooking.domain.Employee;
import com.salonbooking.repositories.EmployeeRepository;
import com.salonbooking.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ernst on 2017/08/14.
 */

@Component
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee save(Employee entity)
    {
        return repository.save(entity);
    }

    @Override
    public Employee findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Employee update(Employee entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Employee entity)
    {
        repository.delete(entity);
    }

    public List<Employee> getEmployee() {
        List<Employee> allcources = new ArrayList<Employee>();

        Iterable<Employee> courses = repository.findAll();
        for (Employee course : courses) {
            allcources.add(course);
        }
        return allcources;
    }
}
