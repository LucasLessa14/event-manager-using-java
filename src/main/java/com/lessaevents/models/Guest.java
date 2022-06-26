package com.lessaevents.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Guest {
    @Id
    // @NotEmpty
    private String guestRG;

    // @NotEmpty
    private String guestName;

    @ManyToOne
    private Event event;

    public String getGuestRG() {
        return guestRG;
    }
    public void setGuestRG(String guestRG) {
        this.guestRG = guestRG;
    }

    public String getGuestName() {
        return guestName;
    }
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
}
