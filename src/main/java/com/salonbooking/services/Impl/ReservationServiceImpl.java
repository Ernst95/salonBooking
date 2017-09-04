package com.salonbooking.services.Impl;

import com.salonbooking.domain.Reservation;
import com.salonbooking.repositories.ReservationRepository;
import com.salonbooking.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ernst on 2017/08/14.
 */

@Component
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository repository;

    @Override
    public Reservation save(Reservation entity)
    {
        return repository.save(entity);
    }

    @Override
    public Reservation findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Reservation update(Reservation entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Reservation entity)
    {
        repository.delete(entity);
    }
}
