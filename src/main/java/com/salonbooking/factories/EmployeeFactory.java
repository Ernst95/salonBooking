package com.salonbooking.factories;

import com.salonbooking.domain.Employee;

import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class EmployeeFactory {

    public static Employee getEmployee(Map<String, String> values, int age){
        Employee employee = new Employee.Builder()
                .id(values.get("id"))
                .name(values.get("name"))
                .surname(values.get("surname"))
                .age(age)
                .gender(values.get("gender"))
                .cellNumber(values.get("cellNumber"))
                .email(values.get("email"))
                .password(values.get("password"))
                .build();
        //.emp(values.get("emp"))
        //.receiptList = builder.receiptList;
        return employee;
    }
}
