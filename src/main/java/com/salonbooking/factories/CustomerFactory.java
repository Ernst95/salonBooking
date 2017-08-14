package com.salonbooking.factories;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;

import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class CustomerFactory {

    public static Customer getCustomer(Map<String, String> values, int age, Employee emp){
        Customer customer = new Customer.Builder()
                .id(values.get("id"))
                .name(values.get("name"))
                .surname(values.get("surname"))
                .age(age)
                .gender(values.get("gender"))
                .cellNumber(values.get("cellNumber"))
                .email(values.get("email"))
                .emp(emp)
                //.receiptList = builder.receiptList;
                .build();

        return customer;
    }
}
