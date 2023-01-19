package ru.maxima.springmvc.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/a")
    public String a(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println(name + " " + surname);
        return null;
    }

    @GetMapping("/b")
    public String a(@RequestParam(value = "name", required = false) String name,
                    @RequestParam(value = "surname", required = false) String surname,
                    Model model) {
        model.addAttribute("message", "Hello, " + name + " " + surname);
        System.out.println();
        return "first/b";
    }

}
