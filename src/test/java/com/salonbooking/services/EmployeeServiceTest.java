package com.salonbooking.services;

import com.salonbooking.domain.Employee;
import com.salonbooking.factories.EmployeeFactory;
import com.salonbooking.services.Impl.EmployeeServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Ernst on 2017/08/14.
 */
public class EmployeeServiceTest {
    Map<String, String> values;
    EmployeeService service;
    Employee emp;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new EmployeeServiceImpl();
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
    public void create() throws Exception {
        Employee employee = EmployeeFactory.getEmployee(values, 30);
        service.create(employee);
        assertEquals("Ernst",employee.getName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Employee reademployee = service.read("1");
        assertEquals("0746",reademployee.getCellNumber());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Employee employee = service.read("1");
        Employee newEmployee = new Employee.Builder()
                .id(values.get("id"))
                .name(values.get("name"))
                .surname(values.get("surname"))
                .age(35)
                .gender(values.get("gender"))
                .cellNumber(values.get("cellNumber"))
                .email(values.get("email"))
                .password(values.get("password"))
                .build();
        service.update(newEmployee);
        Employee UpdateEmployee = service.read("1");
        assertEquals(35,UpdateEmployee.getAge());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        service.delete("1");
        Employee employee = service.read("1");
        assertNull(employee);
    }


}