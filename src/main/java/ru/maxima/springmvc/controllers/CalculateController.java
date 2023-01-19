package ru.maxima.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

    @GetMapping("/calculate")
    public String numbers(@RequestParam(value = "a", required = false) double a,
                          @RequestParam(value = "b", required = false) double b,
                          @RequestParam(value = "op", required = false) String op,
                          Model model) {

        String output = "";

        switch (op) {
            case "add" :
                output = a + " " + op + " " + b + " = " + (a + b);
                break;
            case "sub" :
                output = a + " " + op + " " + b + " = " + (a - b);
                break;
            case "mul" :
                output = a + " " + op + " " + b + " = " + (a * b);
                break;
            case "div" :
                if (b == 0)
                    output = "Division by zero!";
                else
                    output = a + " " + op + " " + b + " = " + (a / b);
                break;
            default:
                output = "Incorrect operator (add, sub, mul, div)!";
        }

        model.addAttribute("result", output);

        return "second/calculate";
    }

}
