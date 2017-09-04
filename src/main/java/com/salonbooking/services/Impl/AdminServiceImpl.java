package com.salonbooking.services.Impl;

import com.salonbooking.domain.Admin;
import com.salonbooking.services.AdminService;
import com.salonbooking.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ernst on 2017/08/14.
 */

@Component
public class AdminServiceImpl implements AdminService {

   @Autowired
    private AdminRepository repository;

   @Override
    public Admin save(Admin entity)
   {
       return repository.save(entity);
   }

   @Override
    public Admin findById(String s)
   {
       return repository.findOne(s);
   }

   @Override
    public Admin update(Admin entity)
   {
       return repository.save(entity);
   }

   @Override
    public void delete(Admin entity)
   {
       repository.delete(entity);
   }
}
