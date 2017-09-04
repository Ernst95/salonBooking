package com.salonbooking.services;

/**
 * Created by Ernst on 2017/09/03.
 */
public interface BaseService <E, ID>{

    E save(E id);
    E findById(ID id);
    E update(E id);
    void delete(E id);

}
