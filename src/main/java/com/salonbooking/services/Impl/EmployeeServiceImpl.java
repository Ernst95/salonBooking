package com.salonbooking.services.Impl;

import com.salonbooking.domain.Employee;
import com.salonbooking.repositories.EmployeeRepository;
import com.salonbooking.repositories.Impl.EmployeeRepositoryImpl;
import com.salonbooking.services.EmployeeService;

/**
 * Created by Ernst on 2017/08/14.
 */
public class EmployeeServiceImpl implements EmployeeService{

    private static EmployeeServiceImpl service = null;

    EmployeeRepository repository = EmployeeRepositoryImpl.getInstance();

    public static EmployeeServiceImpl getInstance(){
        if(service == null)
            service = new EmployeeServiceImpl();
        return service;
    }

    public Employee create(Employee employee) {
        return repository.create(employee);
    }

    public Employee read(String id) {
        return repository.read(id);
    }

    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
