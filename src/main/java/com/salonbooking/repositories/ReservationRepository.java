package com.salonbooking.repositories;

import com.salonbooking.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ernst on 2017/07/14.
 */
public interface ReservationRepository extends CrudRepository<Reservation, String>{


}
