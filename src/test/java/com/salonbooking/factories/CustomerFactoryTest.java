package com.salonbooking.factories;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class CustomerFactoryTest {

    Map<String, String> values;
    Employee emp;

    @BeforeMethod
    public void setUp() throws Exception {

        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("name" , "Ernst");
        values.put("surname", "Chapman");
        values.put("gender", "Male");
        values.put("cellNumber", "0746");
        values.put("email", "ernst@gmail.com");
    }

    @Test
    public void testGetCustomer() throws Exception {
        Customer customer = CustomerFactory.getCustomer(values, 22, emp);
        assertEquals("Ernst", customer.getName());
    }

}