package com.salonbooking.factories;

import com.salonbooking.domain.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Ernst on 2017/06/14.
 */
public class ReceiptFactory {

    public static Receipt buildReceipt(String id, Date date, Reservation reservation)
    {
        Receipt receipt = new Receipt.Builder()
                .id(id)
                .date(date)
                .reservation(reservation)
                .build();
        return receipt;
    }
}
