package com.salonbooking.factories;

import com.salonbooking.domain.Admin;

import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class AdminFactory {

    public static Admin getAdmin(Map<String, String> values)
    {
        Admin admin = new Admin.Builder()
                .id(values.get("id"))
                .name(values.get("name"))
                .password(values.get("password"))
                .build();
        return admin;
    }
}
