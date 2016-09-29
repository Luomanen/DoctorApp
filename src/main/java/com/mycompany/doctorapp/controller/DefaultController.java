package com.mycompany.doctorapp.controller;

import com.mycompany.doctorapp.domain.Person;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.doctorapp.repository.PatientRepository;
import com.mycompany.doctorapp.services.PatientService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class DefaultController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @RequestMapping("*")
    public String view(Model model) {
        String authName = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username",authName);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/signup")
    public String viewSignup() {
        return "signup";
    }



}
