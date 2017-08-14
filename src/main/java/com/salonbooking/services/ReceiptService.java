package com.salonbooking.services;

import com.salonbooking.domain.Receipt;

/**
 * Created by Ernst on 2017/08/14.
 */
public interface ReceiptService {

    Receipt create(Receipt receipt);

    Receipt read(String id);

    Receipt update(Receipt receipt);

    void delete(String id);
}
