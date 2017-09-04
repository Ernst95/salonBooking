package com.salonbooking.factories;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class EmployeeFactory {

    public static Employee buildEmployee(String id, String name, String surname, int age, String gender, String cellNumber, String email, String password, List<Customer> custList)
    {
        Employee emp = new Employee.Builder()
            .id(id)
            .name(name)
            .surname(surname)
            .age(age)
            .gender(gender)
            .cellNumber(cellNumber)
            .email(email)
            .password(password)
            .custList(custList)
            .build();
        return emp;
    }
}
