package com.salonbooking.repositories;

import com.salonbooking.domain.Style;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface StyleRepository {

    Style create(Style style);

    Style read(String id);

    Style update(Style style);

    void delete(String id);
}
