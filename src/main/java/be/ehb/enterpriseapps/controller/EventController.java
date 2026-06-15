package be.ehb.enterpriseapps.controller;

import be.ehb.enterpriseapps.model.Event;
import be.ehb.enterpriseapps.repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String saveEvent(
            @Valid @ModelAttribute Event event,
            BindingResult result) {

        if (result.hasErrors()) {
            return "new";
        }

        eventRepository.save(event);

        return "redirect:/";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id,
                          Model model) {

        Event event =
                eventRepository.findById(id)
                        .orElseThrow();

        model.addAttribute("event", event);

        return "details";
    }
}
