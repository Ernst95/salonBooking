package com.salonbooking.services;

import com.salonbooking.domain.*;
import com.salonbooking.factories.ReservationFactory;
import com.salonbooking.services.Impl.ReservationServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Ernst on 2017/08/14.
 */
public class ReservationServiceTest {

    Map<String, String> values;
    ReservationService service;
    Customer cust;
    Employee emp;
    Style style;
    Receipt receipt;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new ReservationServiceImpl();
        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("date", "27/08/16");
        values.put("time", "12:00");
    }

    @Test
    public void create() throws Exception {
        Reservation reservation = ReservationFactory.getReservation(values, emp, cust, style, receipt);
        service.create(reservation);
        assertEquals("27/08/16",reservation.getDate());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Reservation readreservation = service.read("1");
        assertEquals("27/08/16",readreservation.getDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Reservation reservation = service.read("1");
        Reservation newReservation = new Reservation.Builder()
                .id(values.get("id"))
                .date("26/08/16")
                .time(values.get("time"))
                .emp(emp)
                .cust(cust)
                .style(style)
                .receipt(receipt)
                .build();
        service.update(newReservation);
        Reservation UpdateReservation = service.read("1");
        assertEquals("26/08/16",UpdateReservation.getDate());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        service.delete("1");
        Reservation reservation = service.read("1");
        assertNull(reservation);
    }

}