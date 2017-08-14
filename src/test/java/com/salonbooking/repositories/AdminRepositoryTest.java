package com.salonbooking.repositories;

import com.salonbooking.domain.Admin;
import com.salonbooking.factories.AdminFactory;
import com.salonbooking.repositories.Impl.AdminRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class AdminRepositoryTest {
    Map<String, String> values;
    AdminRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = AdminRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("name","John");
        values.put("password","1234");
    }

    @Test
    public void create() throws Exception {
        Admin admin = AdminFactory.getAdmin(values);
        repository.create(admin);
        assertEquals("John",admin.getName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Admin readadmin = repository.read("1");
        assertEquals("1234",readadmin.getPassword());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Admin admin = repository.read("1");
        Admin newAdmin = new Admin.Builder()
                .name(values.get("name"))
                .password(values.get("password"))
                .id(values.get("id"))
                .build();
        repository.update(newAdmin);
        Admin UpdateAdmin = repository.read("1");
        assertEquals("John",UpdateAdmin.getName());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Admin admin = repository.read("1");
        assertNull(admin);
    }

}