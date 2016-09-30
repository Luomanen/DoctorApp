package com.mycompany.doctorapp.controller;

import com.mycompany.doctorapp.domain.Doctor;
import com.mycompany.doctorapp.domain.Patient;
import com.mycompany.doctorapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Autowired
    private DoctorRepository doctorRepository;

    @RequestMapping("*")
    public String view(Model model) {
        String authName = SecurityContextHolder.getContext().getAuthentication().getName();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Patient authpatient = patientRepository.findByUsername(username);
        //debug
        /*
       
        model.addAttribute("doctors",doctorRepository.findAll());
        model.addAttribute("patients",patientRepository.findAll());
         */

        if (authpatient != null) { //if authenticated person is a patient
            model.addAttribute("sicknesses", authpatient.getSickness());
            model.addAttribute("user", authpatient);
        }

        Doctor authdoctor = doctorRepository.findByUsername(username);
        if (authdoctor != null) { // if authenticated person is a doctor
            model.addAttribute("sicknesses", authdoctor.getTreatedSicknesses());
            System.out.println(authdoctor.getTreatedSicknesses());
            model.addAttribute("user", authdoctor);
        }

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
