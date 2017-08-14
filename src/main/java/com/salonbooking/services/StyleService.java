package com.salonbooking.services;

import com.salonbooking.domain.Style;

/**
 * Created by Ernst on 2017/08/14.
 */
public interface StyleService {

    Style create(Style style);

    Style read(String id);

    Style update(Style style);

    void delete(String id);
}
