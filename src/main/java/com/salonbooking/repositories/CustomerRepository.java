package com.salonbooking.repositories;

import com.salonbooking.domain.Customer;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface CustomerRepository {

    Customer create(Customer customer);

    Customer read(String id);

    Customer update(Customer customer);

    void delete(String id);
}
