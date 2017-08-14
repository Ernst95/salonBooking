package com.salonbooking.repositories;

import com.salonbooking.domain.*;
import com.salonbooking.factories.ReservationFactory;
import com.salonbooking.repositories.Impl.ReservationRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class ReservationRepositoryTest {

    Map<String, String> values;
    ReservationRepository repository;
    Customer cust;
    Employee emp;
    Style style;
    Receipt receipt;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = ReservationRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("date", "27/08/16");
        values.put("time", "12:00");
    }

    @Test
    public void create() throws Exception {
        Reservation reservation = ReservationFactory.getReservation(values, emp, cust, style, receipt);
        repository.create(reservation);
        assertEquals("27/08/16",reservation.getDate());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Reservation readreservation = repository.read("1");
        assertEquals("27/08/16",readreservation.getDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Reservation reservation = repository.read("1");
        Reservation newReservation = new Reservation.Builder()
                .id(values.get("id"))
                .date("26/08/16")
                .time(values.get("time"))
                .emp(emp)
                .cust(cust)
                .style(style)
                .receipt(receipt)
                .build();
        repository.update(newReservation);
        Reservation UpdateReservation = repository.read("1");
        assertEquals("26/08/16",UpdateReservation.getDate());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Reservation reservation = repository.read("1");
        assertNull(reservation);
    }

}