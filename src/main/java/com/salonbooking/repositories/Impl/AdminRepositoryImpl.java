package com.salonbooking.repositories.Impl;

import com.salonbooking.domain.Admin;
import com.salonbooking.repositories.AdminRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ernst on 2017/07/14.
 */
public class AdminRepositoryImpl implements AdminRepository {

    private static AdminRepositoryImpl respository = null;

    private Map<String, Admin> adminTable;

    private AdminRepositoryImpl() {

        adminTable = new HashMap<String, Admin>();
    }

    public static AdminRepositoryImpl getInstance(){
        if(respository==null)
            respository = new AdminRepositoryImpl();
        return respository;
    }

    public Admin create(Admin admin) {
        adminTable.put(admin.getId(),admin);
        Admin savedAdmin = adminTable.get(admin.getId());
        return savedAdmin;
    }

    public Admin read(String id) {
        Admin admin = adminTable.get(id);
        return admin;
    }

    public Admin update(Admin admin) {
        adminTable.put(admin.getId(),admin);
        Admin savedAdmin = adminTable.get(admin.getId());
        return savedAdmin;
    }

    public void delete(String id) {
        adminTable.remove(id);

    }
}
