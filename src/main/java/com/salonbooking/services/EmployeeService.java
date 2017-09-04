package com.salonbooking.services;

import com.salonbooking.domain.Employee;

import java.util.List;

/**
 * Created by Ernst on 2017/08/14.
 */
public interface EmployeeService extends BaseService<Employee, String>{

   List<Employee> getEmployee();
}
