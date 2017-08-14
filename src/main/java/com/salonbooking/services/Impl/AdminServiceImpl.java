package com.salonbooking.services.Impl;

import com.salonbooking.domain.Admin;
import com.salonbooking.repositories.Impl.AdminRepositoryImpl;
import com.salonbooking.services.AdminService;
import com.salonbooking.repositories.AdminRepository;

/**
 * Created by Ernst on 2017/08/14.
 */
public class AdminServiceImpl implements AdminService {

    private static AdminServiceImpl service = null;

    AdminRepository repository = AdminRepositoryImpl.getInstance();

    public static AdminServiceImpl getInstance(){
        if(service == null)
            service = new AdminServiceImpl();
        return service;
    }

    public Admin create(Admin admin) {
        return repository.create(admin);
    }

    public Admin read(String id) {
        return repository.read(id);
    }

    public Admin update(Admin admin) {
        return repository.update(admin);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
