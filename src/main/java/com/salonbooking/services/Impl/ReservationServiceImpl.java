package com.salonbooking.services.Impl;

import com.salonbooking.domain.Reservation;
import com.salonbooking.repositories.Impl.ReservationRepositoryImpl;
import com.salonbooking.repositories.ReservationRepository;
import com.salonbooking.services.ReservationService;

/**
 * Created by Ernst on 2017/08/14.
 */
public class ReservationServiceImpl implements ReservationService{

    private static ReservationServiceImpl service = null;

    ReservationRepository repository = ReservationRepositoryImpl.getInstance();

    public static ReservationServiceImpl getInstance(){
        if(service == null)
            service = new ReservationServiceImpl();
        return service;
    }

    public Reservation create(Reservation reservation) {
        return repository.create(reservation);
    }

    public Reservation read(String id) {
        return repository.read(id);
    }

    public Reservation update(Reservation reservation) {
        return repository.update(reservation);
    }

    public void delete(String id) {
        repository.delete(id);

    }
}
