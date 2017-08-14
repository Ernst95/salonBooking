package com.salonbooking.factories;

import com.salonbooking.domain.Employee;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class EmployeeFactoryTest {
    Map<String, String> values;

    @BeforeMethod
    public void setUp() throws Exception {

        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("name" , "Ernst");
        values.put("surname", "Chapman");
        values.put("gender", "Male");
        values.put("cellNumber", "0746");
        values.put("email", "ernst@gmail.com");
        values.put("password", "1234");
    }

    @Test
    public void testGetEmployee() throws Exception {
        Employee employee = EmployeeFactory.getEmployee(values, 22);
        assertEquals("Male", employee.getGender());
    }

}