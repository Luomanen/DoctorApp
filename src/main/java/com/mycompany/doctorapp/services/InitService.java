/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.services;

import com.mycompany.doctorapp.domain.Doctor;
import com.mycompany.doctorapp.domain.Patient;
import com.mycompany.doctorapp.domain.Person;
import com.mycompany.doctorapp.repository.DoctorRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mycompany.doctorapp.repository.PatientRepository;

/**
 *
 * @author Juhana
 */
@Component

public class InitService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @PostConstruct
    public void init() {


        Patient patient = new Patient();
        patient.setName("patient");
        patient.setUsername("patient");
        patient.setPassword("patient");
        
        patientRepository.save(patient);
        
       Doctor doctor = new Doctor();
       doctor.setName("Doc");
       doctor.setPassword("Doc");
       doctor.setUsername("Doc");
       doctorRepository.save(doctor);

    }
}
