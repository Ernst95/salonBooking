package com.salonbooking.services;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import com.salonbooking.factories.CustomerFactory;
import com.salonbooking.services.Impl.CustomerServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Ernst on 2017/08/14.
 */
public class CustomerServiceTest {
    Map<String, String> values;
    CustomerService service;
    Employee emp;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new CustomerServiceImpl();
        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("name" , "Ernst");
        values.put("surname", "Chapman");
        values.put("gender", "Male");
        values.put("cellNumber", "0746");
        values.put("email", "ernst@gmail.com");
    }

    @Test
    public void create() throws Exception {
        Customer customer = CustomerFactory.getCustomer(values, 22, emp);
        service.create(customer);
        assertEquals("Ernst",customer.getName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Customer readcustomer = service.read("1");
        assertEquals("0746",readcustomer.getCellNumber());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Customer customer = service.read("1");
        Customer newCustomer = new Customer.Builder()
                .id(values.get("id"))
                .name(values.get("name"))
                .surname(values.get("surname"))
                .age(23)
                .gender(values.get("gender"))
                .cellNumber(values.get("cellNumber"))
                .email(values.get("email"))
                .emp(emp)
                .build();
        service.update(newCustomer);
        Customer UpdateCustomer = service.read("1");
        assertEquals(23,UpdateCustomer.getAge());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        service.delete("1");
        Customer customer = service.read("1");
        assertNull(customer);
    }

}