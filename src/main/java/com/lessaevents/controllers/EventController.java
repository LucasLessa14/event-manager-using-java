package com.lessaevents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
// import org.springframework.boot.context.properties.bind.BindResult;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lessaevents.models.Event;
import com.lessaevents.models.Guest;
import com.lessaevents.repository.EventRepository;
import com.lessaevents.repository.GuestRepository;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GuestRepository guestRepository;
    
    @RequestMapping(value="/createEvent", method = RequestMethod.GET)
    public String form() {
        
        return "event/formEvent";
    }

    @RequestMapping(value="/createEvent", method = RequestMethod.POST)
    public String form(Event event) {
        eventRepository.save(event);

        return "redirect:/events";
    }

    @RequestMapping("/events")
    public ModelAndView eventList() {
        ModelAndView modelAndView = new ModelAndView("index");
        
        Iterable<Event> events = eventRepository.findAll();

        modelAndView.addObject("events", events);

        return modelAndView;
    }

    @RequestMapping(value="/{eventId}", method=RequestMethod.GET)
    public ModelAndView eventDetails(@PathVariable("eventId") long eventId) {

        Event event = eventRepository.findByEventId(eventId);
        
        ModelAndView modelAndView = new ModelAndView("event/eventDetail");

        modelAndView.addObject("event", event);

        Iterable<Guest> guests = guestRepository.findByEvent(event);

        modelAndView.addObject("guests", guests);

        return modelAndView;
    }

    @RequestMapping("/deleteEvent")
	public String deleteEvent(long eventId){
		Event event = eventRepository.findByEventId(eventId);
		eventRepository.delete(event);
		return "redirect:/events";
	}

    @RequestMapping(value="/{eventId}", method=RequestMethod.POST)
    public String eventDetailsPost(@PathVariable("eventId") long eventId, Guest guest) {
    // public String eventDetailsPost(@PathVariable("eventId") long eventId, @Valid Guest guest, BindResult result, RedirectAttributes attributes) {

        // if (result.hasErros()) {
        //     attributes.addFlashAttribute("mensagem", "Verifique seus campos");
        //     return "redirect:/{eventId}";
        // }
        Event event = eventRepository.findByEventId(eventId);

        System.out.println("============================================");
        System.out.println(guest.getGuestName());
        System.out.println(guest.getGuestRG());
        System.out.println(event.getEventName());
        System.out.println("============================================");

        guest.setEvent(event);

        guestRepository.save(guest);

        // attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso");

        return "redirect:/" + eventId;
    }

    @RequestMapping("/deleteGuest")
	public String deleteGuest(String guestRG){
		Guest guest = guestRepository.findByGuestRG(guestRG);
		guestRepository.delete(guest);
		
		Event event = guest.getEvent();
		long codigoLong = event.getEventId();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}
}
