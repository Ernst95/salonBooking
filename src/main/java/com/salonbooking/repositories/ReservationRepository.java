package com.salonbooking.repositories;

import com.salonbooking.domain.Reservation;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface ReservationRepository {

    Reservation create(Reservation reservation);

    Reservation read(String id);

    Reservation update(Reservation reservation);

    void delete(String id);
}
