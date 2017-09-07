package com.salonbooking.factories;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class CustomerFactory {

    public static Customer buildCustomer(String id, String name, String surname, int age, String gender, String cellNumber, String email, Employee emp)
    {
        Customer cust = new Customer.Builder()
                .id(id)
                .name(name)
                .surname(surname)
                .age(age)
                .gender(gender)
                .cellNumber(cellNumber)
                .email(email)
                .emp(emp)
                .build();
        return cust;
    }
}
