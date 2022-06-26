package com.lessaevents.repository;

import org.springframework.data.repository.CrudRepository;

import com.lessaevents.models.Event;
import com.lessaevents.models.Guest;

public interface GuestRepository extends CrudRepository<Guest, String> {
    
    Iterable<Guest> findByEvent(Event event);
    Guest findByGuestRG(String guestRG);
}
