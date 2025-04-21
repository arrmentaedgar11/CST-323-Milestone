package com.gcu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.models.LoginModel;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {
    @GetMapping("/login")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login");
            return "login";
        }
        return "redirect:/";
    }
}
