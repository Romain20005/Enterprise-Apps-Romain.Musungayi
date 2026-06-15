package be.ehb.enterpriseapps.controller;

import be.ehb.enterpriseapps.model.Event;
import be.ehb.enterpriseapps.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute(
                "events",
                eventRepository.findAll()
        );

        return "index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {

        model.addAttribute("event", new Event());

        return "new";
    }

    @PostMapping("/new")
    public String saveEvent(@ModelAttribute Event event) {

        eventRepository.save(event);

        return "redirect:/";
    }
}