package com.salonbooking.services.Impl;

import com.salonbooking.domain.Style;
import com.salonbooking.repositories.Impl.StyleRepositoryImpl;
import com.salonbooking.repositories.StyleRepository;
import com.salonbooking.services.StyleService;

/**
 * Created by Ernst on 2017/08/14.
 */
public class StyleServiceImpl implements StyleService{

    private static StyleServiceImpl service = null;

    StyleRepository repository = StyleRepositoryImpl.getInstance();

    public static StyleServiceImpl getInstance(){
        if(service == null)
            service = new StyleServiceImpl();
        return service;
    }

    public Style create(Style style) {
        return repository.create(style);
    }

    public Style read(String id) {
        return repository.read(id);
    }

    public Style update(Style style) {
        return repository.update(style);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
