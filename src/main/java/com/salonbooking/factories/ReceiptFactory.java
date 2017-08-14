package com.salonbooking.factories;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import com.salonbooking.domain.Receipt;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class ReceiptFactory {

    public static Receipt getReceipt(Map<String, String> values, Date date, DateFormat dateFormat, Customer cust, Employee emp){
        Receipt receipt = new Receipt.Builder()
                .id(values.get("id"))
                .date(date)
                .dateFormat(dateFormat)
                .cust(cust)
                .emp(emp)
                .build();

        return receipt;
    }
}
