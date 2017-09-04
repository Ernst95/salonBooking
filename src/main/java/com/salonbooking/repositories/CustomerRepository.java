package com.salonbooking.repositories;

import com.salonbooking.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface CustomerRepository extends CrudRepository<Customer, String>{


}
