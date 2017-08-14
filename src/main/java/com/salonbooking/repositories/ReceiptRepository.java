package com.salonbooking.repositories;

import com.salonbooking.domain.Receipt;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface ReceiptRepository {

    Receipt create(Receipt receipt);

    Receipt read(String id);

    Receipt update(Receipt receipt);

    void delete(String id);
}
