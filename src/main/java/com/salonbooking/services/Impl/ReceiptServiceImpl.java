package com.salonbooking.services.Impl;

import com.salonbooking.domain.Receipt;
import com.salonbooking.repositories.ReceiptRepository;
import com.salonbooking.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ernst on 2017/08/14.
 */

@Component
public class ReceiptServiceImpl implements ReceiptService{

    @Autowired
    private ReceiptRepository repository;

    @Override
    public Receipt save(Receipt entity)
    {
        return repository.save(entity);
    }

    @Override
    public Receipt findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Receipt update(Receipt entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Receipt entity)
    {
        repository.delete(entity);
    }

}
