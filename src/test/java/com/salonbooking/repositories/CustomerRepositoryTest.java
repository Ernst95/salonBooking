package com.salonbooking.repositories;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import com.salonbooking.factories.CustomerFactory;
import com.salonbooking.repositories.Impl.CustomerRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class CustomerRepositoryTest {
    Map<String, String> values;
    CustomerRepository repository;
    Employee emp;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = CustomerRepositoryImpl.getInstance();
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
        repository.create(customer);
        assertEquals("Ernst",customer.getName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Customer readcustomer = repository.read("1");
        assertEquals("0746",readcustomer.getCellNumber());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Customer customer = repository.read("1");
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
        repository.update(newCustomer);
        Customer UpdateCustomer = repository.read("1");
        assertEquals(23,UpdateCustomer.getAge());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Customer customer = repository.read("1");
        assertNull(customer);
    }

}