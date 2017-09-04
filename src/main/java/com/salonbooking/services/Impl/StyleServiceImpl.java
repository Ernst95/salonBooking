package com.salonbooking.services.Impl;

import com.salonbooking.domain.Style;
import com.salonbooking.repositories.StyleRepository;
import com.salonbooking.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ernst on 2017/08/14.
 */

@Component
public class StyleServiceImpl implements StyleService{

    @Autowired
    private StyleRepository repository;

    @Override
    public Style save(Style entity)
    {
        return repository.save(entity);
    }

    @Override
    public Style findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Style update(Style entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Style entity)
    {
        repository.delete(entity);
    }
}
