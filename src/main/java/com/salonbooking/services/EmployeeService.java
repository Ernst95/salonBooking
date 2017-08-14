package com.salonbooking.services;

import com.salonbooking.domain.Employee;

/**
 * Created by Ernst on 2017/08/14.
 */
public interface EmployeeService {

    Employee create(Employee employee);

    Employee read(String id);

    Employee update(Employee employee);

    void delete(String id);
}
