package com.salonbooking.factories;

import com.salonbooking.domain.*;

import java.util.Date;
import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class ReservationFactory {

    public static Reservation buildReservation(String id, String date, String time)
    {
        Reservation reservation = new Reservation.Builder()
                .id(id)
                .date(date)
                .time(time)
                .build();
        return reservation;
    }
}
