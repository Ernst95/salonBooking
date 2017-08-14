package com.salonbooking.services;

import com.salonbooking.domain.Customer;

/**
 * Created by Ernst on 2017/08/14.
 */
public interface CustomerService {

    Customer create(Customer customer);

    Customer read(String id);

    Customer update(Customer customer);

    void delete(String id);
}
