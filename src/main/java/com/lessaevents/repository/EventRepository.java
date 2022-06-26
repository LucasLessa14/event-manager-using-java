package com.lessaevents.repository;

import org.springframework.data.repository.CrudRepository;

import com.lessaevents.models.Event;

public interface EventRepository extends CrudRepository<Event, String>{
    
    Event findByEventId(long eventId);
}
