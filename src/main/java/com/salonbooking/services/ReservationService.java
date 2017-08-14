package com.salonbooking.services;

import com.salonbooking.domain.Reservation;

/**
 * Created by Ernst on 2017/08/14.
 */
public interface ReservationService {

    Reservation create(Reservation reservation);

    Reservation read(String id);

    Reservation update(Reservation reservation);

    void delete(String id);
}
