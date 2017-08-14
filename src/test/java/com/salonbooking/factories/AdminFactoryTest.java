package com.salonbooking.factories;

import com.salonbooking.domain.Admin;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class AdminFactoryTest {

    Map<String, String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("name" , "Ernst");
        values.put("password", "1234");
    }

    @Test
    public void testGetAdmin() throws Exception {
        Admin admin = AdminFactory.getAdmin(values);
        assertEquals("Ernst", admin.getName());
    }

}