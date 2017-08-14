package com.salonbooking.repositories;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import com.salonbooking.domain.Receipt;
import com.salonbooking.factories.ReceiptFactory;
import com.salonbooking.repositories.Impl.ReceiptRepositoryImpl;
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
public class ReceiptRepositoryTest {
    Map<String, String> values;
    ReceiptRepository repository;
    Date date;
    DateFormat dateFormat;
    Customer cust;
    Employee emp;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = ReceiptRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id", "1");
    }

    @Test
    public void create() throws Exception {
        Receipt receipt = ReceiptFactory.getReceipt(values, date, dateFormat, cust, emp);
        repository.create(receipt);
        assertEquals(date,receipt.getDate());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Receipt readreceipt = repository.read("1");
        assertEquals(date,readreceipt.getDate());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Receipt receipt = repository.read("1");
        Receipt newReceipt = new Receipt.Builder()
                .id(values.get("id"))
                .date(date)
                .dateFormat(dateFormat)
                .cust(cust)
                .emp(emp)
                .build();
        repository.update(newReceipt);
        Receipt UpdateReceipt = repository.read("1");
        assertEquals(date,UpdateReceipt.getDate());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Receipt receipt = repository.read("1");
        assertNull(receipt);
    }

}