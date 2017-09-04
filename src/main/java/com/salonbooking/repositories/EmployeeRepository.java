package com.salonbooking.repositories;

import com.salonbooking.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface EmployeeRepository extends CrudRepository<Employee, String>{


}
