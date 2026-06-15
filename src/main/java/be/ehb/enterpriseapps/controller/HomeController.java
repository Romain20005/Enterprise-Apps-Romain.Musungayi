package be.ehb.enterpriseapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        System.out.println("INDEX CALLED");
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        System.out.println("ABOUT CALLED");
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/new")
    public String newEvent() {
        return "new";
    }
}