/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.controller;

import com.mycompany.doctorapp.domain.Patient;
import com.mycompany.doctorapp.services.PatientService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Juhana
 */
@Controller
public class SignupController {
   
    @Autowired
    private PatientService patientService; 
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Valid @ModelAttribute Patient patient) {        
        patientService.newPatient(patient);
        return "redirect:/login";
    }
}
