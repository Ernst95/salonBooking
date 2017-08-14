package com.salonbooking.factories;

import com.salonbooking.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class ReservationFactoryTest {
    Map<String, String> values;
    Employee emp;
    Customer cust;
    Style style;
    Receipt receipt;

    @BeforeMethod
    public void setUp() throws Exception {

        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("date", "27/08/16");
        values.put("time", "12:00");
    }

    @Test
    public void testGetReservation() throws Exception {
        Reservation reservation = ReservationFactory.getReservation(values, emp, cust, style, receipt);
        assertEquals("27/08/16", reservation.getDate());
    }

}