package com.salonbooking.services.Impl;

import com.salonbooking.domain.Admin;
import com.salonbooking.domain.Customer;
import com.salonbooking.repositories.CustomerRepository;
import com.salonbooking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ernst on 2017/08/14.
 */

@Component
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getCustomer(int age)
    {
        return repository.findByAge(age);
    }

    @Override
    public Customer save(Customer entity)
    {
        return repository.save(entity);
    }

    @Override
    public Customer findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Customer update(Customer entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Customer entity)
    {
        repository.delete(entity);
    }


}
