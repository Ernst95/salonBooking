package com.salonbooking.services;

import com.salonbooking.domain.Admin;

/**
 * Created by Ernst on 2017/08/14.
 */
public interface AdminService {

    Admin create(Admin admin);

    Admin read(String id);

    Admin update(Admin admin);

    void delete(String id);
}
