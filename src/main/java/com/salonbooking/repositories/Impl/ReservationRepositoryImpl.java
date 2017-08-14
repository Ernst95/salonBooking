package com.salonbooking.repositories.Impl;

import com.salonbooking.domain.Reservation;
import com.salonbooking.repositories.ReservationRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ernst on 2017/07/14.
 */
public class ReservationRepositoryImpl implements ReservationRepository{

    private static ReservationRepositoryImpl respository = null;

    private Map<String, Reservation> reservationTable;

    private ReservationRepositoryImpl() {

        reservationTable = new HashMap<String, Reservation>();
    }

    public static ReservationRepositoryImpl getInstance(){
        if(respository==null)
            respository = new ReservationRepositoryImpl();
        return respository;
    }

    public Reservation create(Reservation reservation) {
        reservationTable.put(reservation.getId(),reservation);
        Reservation savedReservation = reservationTable.get(reservation.getId());
        return savedReservation;
    }

    public Reservation read(String id) {
        Reservation reservation = reservationTable.get(id);
        return reservation;
    }

    public Reservation update(Reservation reservation) {
        reservationTable.put(reservation.getId(),reservation);
        Reservation savedReservation = reservationTable.get(reservation.getId());
        return savedReservation;
    }

    public void delete(String id) {
        reservationTable.remove(id);

    }
}
