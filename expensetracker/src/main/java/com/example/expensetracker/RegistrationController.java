package com.example.expensetracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute RegistrationForm registrationForm, Model model) {
        // In a real application, you would save the user to a database here.
        // For demonstration we're just echoing the values back.
        model.addAttribute("username", registrationForm.getUsername());
        model.addAttribute("email", registrationForm.getEmail());
        return "register-success";
    }
}