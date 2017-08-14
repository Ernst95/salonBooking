package com.salonbooking.services;

import com.salonbooking.domain.Admin;
import com.salonbooking.factories.AdminFactory;
import com.salonbooking.services.Impl.AdminServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Ernst on 2017/08/14.
 */
public class AdminServiceTest {
    Map<String, String> values;
    AdminService service;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new AdminServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("name","John");
        values.put("password","1234");
    }

    @Test
    public void create() throws Exception {
        Admin admin = AdminFactory.getAdmin(values);
        service.create(admin);
        assertEquals("John",admin.getName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Admin readadmin = service.read("1");
        assertEquals("1234",readadmin.getPassword());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Admin admin = service.read("1");
        Admin newAdmin = new Admin.Builder()
                .name(values.get("name"))
                .password(values.get("password"))
                .id(values.get("id"))
                .build();
        service.update(newAdmin);
        Admin UpdateAdmin = service.read("1");
        assertEquals("John",UpdateAdmin.getName());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        service.delete("1");
        Admin admin = service.read("1");
        assertNull(admin);
    }

}