package com.salonbooking.repositories.Impl;

import com.salonbooking.domain.Customer;
import com.salonbooking.repositories.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ernst on 2017/07/14.
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private static CustomerRepositoryImpl respository = null;

    private Map<String, Customer> customerTable;

    private CustomerRepositoryImpl() {

        customerTable = new HashMap<String, Customer>();
    }

    public static CustomerRepositoryImpl getInstance(){
        if(respository==null)
            respository = new CustomerRepositoryImpl();
        return respository;
    }

    public Customer create(Customer customer) {
        customerTable.put(customer.getId(),customer);
        Customer savedCustomer = customerTable.get(customer.getId());
        return savedCustomer;
    }

    public Customer read(String id) {
        Customer customer = customerTable.get(id);
        return customer;
    }

    public Customer update(Customer customer) {
        customerTable.put(customer.getId(),customer);
        Customer savedCustomer = customerTable.get(customer.getId());
        return savedCustomer;
    }

    public void delete(String id) {
        customerTable.remove(id);

    }
}
