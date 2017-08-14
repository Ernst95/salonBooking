package com.salonbooking.repositories;

import com.salonbooking.domain.Admin;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface AdminRepository {

    Admin create(Admin admin);

    Admin read(String id);

    Admin update(Admin admin);

    void delete(String id);
}
