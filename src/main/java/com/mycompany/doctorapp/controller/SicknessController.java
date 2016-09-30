/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.controller;

import com.mycompany.doctorapp.domain.Sickness;
import com.mycompany.doctorapp.domain.Treatment;
import com.mycompany.doctorapp.repository.DoctorRepository;
import com.mycompany.doctorapp.repository.PatientRepository;
import com.mycompany.doctorapp.repository.SicknessRepository;
import com.mycompany.doctorapp.services.PatientService;
import com.mycompany.doctorapp.services.TreatmentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Juhana
 */
@Controller
public class SicknessController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SicknessRepository sicknessRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private TreatmentService treatmentService;

    @RequestMapping(value = "/sickness", method = RequestMethod.POST)
    
    //post a new sickness as a patient
    public String newSickness(@Valid @ModelAttribute("sicknes") Sickness sickness, BindingResult bindingresult) {
        if (bindingresult.hasErrors()) {
            return "redirect:/index";
        }
        patientService.addSickness(sickness);
        return "redirect:/index";
    }

    //show sickness page
    @RequestMapping(value = "/sickness/{id}", method = RequestMethod.GET)
    public String showSickness(@PathVariable Long id, Model model) {

        Sickness sickness = sicknessRepository.findOne(id);
        model.addAttribute("sickness", sickness);

        return "sickness";
    }

    
    //doctors can order treatments to sicknesses
    @RequestMapping(value = "/sickness/{id}", method = RequestMethod.POST)
    public String orderTreatment(@Valid @ModelAttribute Treatment treatment, @PathVariable Long id, BindingResult bindingresult) {

        if (bindingresult.hasErrors()) {
            return "sickness/" + id;
        }
        Sickness sickness = sicknessRepository.findOne(id);
        treatmentService.treatSickness(treatment, sickness);

        return "redirect:/index";

    }
}
