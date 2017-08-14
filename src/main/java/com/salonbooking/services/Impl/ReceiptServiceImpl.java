package com.salonbooking.services.Impl;

import com.salonbooking.domain.Receipt;
import com.salonbooking.repositories.Impl.ReceiptRepositoryImpl;
import com.salonbooking.repositories.ReceiptRepository;
import com.salonbooking.services.ReceiptService;

/**
 * Created by Ernst on 2017/08/14.
 */
public class ReceiptServiceImpl implements ReceiptService{

    private static ReceiptServiceImpl service = null;

    ReceiptRepository repository = ReceiptRepositoryImpl.getInstance();

    public static ReceiptServiceImpl getInstance(){
        if(service == null)
            service = new ReceiptServiceImpl();
        return service;
    }

    public Receipt create(Receipt receipt) {
        return repository.create(receipt);
    }

    public Receipt read(String id) {
        return repository.read(id);
    }

    public Receipt update(Receipt receipt) {
        return repository.update(receipt);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
