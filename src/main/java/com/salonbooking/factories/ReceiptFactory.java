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

    public static Receipt buildReceipt(String id, Date date)
    {
        Receipt receipt = new Receipt.Builder()
                .id(id)
                .date(date)
                .build();
        return receipt;
    }
}
