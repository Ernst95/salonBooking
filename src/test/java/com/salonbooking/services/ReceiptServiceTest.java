package com.salonbooking.services;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import com.salonbooking.domain.Receipt;
import com.salonbooking.factories.ReceiptFactory;
import com.salonbooking.services.Impl.ReceiptServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Ernst on 2017/08/14.
 */
public class ReceiptServiceTest {
    Map<String, String> values;
    ReceiptService service;
    Date date;
    DateFormat dateFormat;
    Customer cust;
    Employee emp;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new ReceiptServiceImpl();
        values = new HashMap<String, String>();
        values.put("id", "1");
    }

    @Test
    public void create() throws Exception {
        Receipt receipt = ReceiptFactory.getReceipt(values, date, dateFormat, cust, emp);
        service.create(receipt);
        assertEquals(date,receipt.getDate());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Receipt readreceipt = service.read("1");
        assertEquals(date,readreceipt.getDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Receipt receipt = service.read("1");
        Receipt newReceipt = new Receipt.Builder()
                .id(values.get("id"))
                .date(date)
                .dateFormat(dateFormat)
                .cust(cust)
                .emp(emp)
                .build();
        service.update(newReceipt);
        Receipt UpdateReceipt = service.read("1");
        assertEquals(date,UpdateReceipt.getDate());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        service.delete("1");
        Receipt receipt = service.read("1");
        assertNull(receipt);
    }

}