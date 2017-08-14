package com.salonbooking.factories;

import com.salonbooking.domain.*;

import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class ReservationFactory {

    public static Reservation getReservation(Map<String, String> values, Employee emp, Customer cust, Style style, Receipt receipt)
    {
        Reservation reservation = new Reservation.Builder()
                .id(values.get("id"))
                .date(values.get("date"))
                .time(values.get("time"))
                .emp(emp)
                .cust(cust)
                .style(style)
                .receipt(receipt)
                .build();

        return reservation;
    }
}
