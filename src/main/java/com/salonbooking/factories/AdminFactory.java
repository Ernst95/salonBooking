package com.salonbooking.factories;

import com.salonbooking.domain.Admin;

/**
 * Created by Ernst on 2017/06/14.
 */
public class AdminFactory {

    public static Admin buildAdmin(String id, String name, String password)
    {
        Admin admin = new Admin.Builder()
                .id(id)
                .name(name)
                .password(password)
                .build();
        return admin;
    }
}
