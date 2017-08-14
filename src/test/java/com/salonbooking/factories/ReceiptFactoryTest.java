package com.salonbooking.factories;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import com.salonbooking.domain.Receipt;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Ernst on 2017/08/14.
 */
public class ReceiptFactoryTest {
    Map<String, String> values;
    Employee emp;
    Date date;
    DateFormat dateFormat;
    Customer cust;

    @BeforeMethod
    public void setUp() throws Exception {

        values = new HashMap<String, String>();
        values.put("id", "1");
    }

    @Test
    public void testGetReceipt() throws Exception {
        Receipt receipt = ReceiptFactory.getReceipt(values, date, dateFormat, cust, emp);
        assertEquals(date, receipt.getDate());
    }

}