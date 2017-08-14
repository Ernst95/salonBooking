package com.salonbooking.factories;

import com.salonbooking.domain.Style;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class StyleFactoryTest {
    Map<String, String> values;

    @BeforeMethod
    public void setUp() throws Exception {

        values = new HashMap<String, String>();
        values.put("id", "1");
        values.put("name", "Mohawk");
    }

    @Test
    public void testGetReservation() throws Exception {
        Style style = StyleFactory.getStyle(values, 40, 1 );
        assertEquals("Mohawk", style.getName());
    }

}