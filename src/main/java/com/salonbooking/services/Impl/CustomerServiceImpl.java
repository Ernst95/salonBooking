package com.salonbooking.services.Impl;

import com.salonbooking.domain.Customer;
import com.salonbooking.repositories.CustomerRepository;
import com.salonbooking.repositories.Impl.CustomerRepositoryImpl;
import com.salonbooking.services.CustomerService;

/**
 * Created by Ernst on 2017/08/14.
 */
public class CustomerServiceImpl implements CustomerService{

    private static CustomerServiceImpl service = null;

    CustomerRepository repository = CustomerRepositoryImpl.getInstance();

    public static CustomerServiceImpl getInstance(){
        if(service == null)
            service = new CustomerServiceImpl();
        return service;
    }

    public Customer create(Customer customer) {
        return repository.create(customer);
    }

    public Customer read(String id) {
        return repository.read(id);
    }

    public Customer update(Customer customer) {
        return repository.update(customer);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
