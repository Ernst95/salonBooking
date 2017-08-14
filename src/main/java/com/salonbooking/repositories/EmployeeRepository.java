package com.salonbooking.repositories;

import com.salonbooking.domain.Employee;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface EmployeeRepository {

    Employee create(Employee employee);

    Employee read(String id);

    Employee update(Employee employee);

    void delete(String id);
}
