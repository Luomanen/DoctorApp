/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.services;

import com.mycompany.doctorapp.domain.Sickness;
import com.mycompany.doctorapp.domain.Treatment;
import com.mycompany.doctorapp.repository.DoctorRepository;
import com.mycompany.doctorapp.repository.PatientRepository;
import com.mycompany.doctorapp.repository.SicknessRepository;
import com.mycompany.doctorapp.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juhana
 */
@Service
public class TreatmentService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SicknessRepository sicknessRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    public void treatSickness(Treatment t, Sickness s) {

        //treatment should have content already
        t.setDoctor(s.getDoctor());
        t.setPatient(s.getPatient());
        t.setSickness(s);

        treatmentRepository.saveAndFlush(t);

        s.setTreatment(t);
        s.setTreatmentStatus(true);
        System.out.println(s.getDoctor());
        System.out.println(s.getPatient());
        System.out.println(s.getTreatment().getContent());
        System.out.println(s.getTreatmentStatus());
        
      
        sicknessRepository.save(s);

    }
}
