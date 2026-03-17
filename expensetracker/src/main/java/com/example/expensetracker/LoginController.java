package com.example.expensetracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute LoginForm loginForm, Model model) {
        // In a real app we'd authenticate the user.
        model.addAttribute("username", loginForm.getUsername());
        return "login-success";
    }
}