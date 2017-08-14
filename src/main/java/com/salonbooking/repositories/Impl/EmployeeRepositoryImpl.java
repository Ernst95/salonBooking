package com.salonbooking.repositories.Impl;

import com.salonbooking.domain.Employee;
import com.salonbooking.repositories.EmployeeRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ernst on 2017/07/14.
 */
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private static EmployeeRepositoryImpl respository = null;

    private Map<String, Employee> employeeTable;

    private EmployeeRepositoryImpl() {

        employeeTable = new HashMap<String, Employee>();
    }

    public static EmployeeRepositoryImpl getInstance(){
        if(respository==null)
            respository = new EmployeeRepositoryImpl();
        return respository;
    }

    public Employee create(Employee employee) {
        employeeTable.put(employee.getId(),employee);
        Employee savedEmployee = employeeTable.get(employee.getId());
        return savedEmployee;
    }

    public Employee read(String id) {
        Employee employee = employeeTable.get(id);
        return employee;
    }

    public Employee update(Employee employee) {
        employeeTable.put(employee.getId(),employee);
        Employee savedEmployee = employeeTable.get(employee.getId());
        return savedEmployee;
    }

    public void delete(String id) {
        employeeTable.remove(id);

    }
}
