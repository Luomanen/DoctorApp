/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.services;

import com.mycompany.doctorapp.domain.Doctor;
import com.mycompany.doctorapp.domain.Patient;
import com.mycompany.doctorapp.domain.Sickness;
import com.mycompany.doctorapp.repository.DoctorRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mycompany.doctorapp.repository.PatientRepository;
import com.mycompany.doctorapp.repository.SicknessRepository;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private PatientService patientService;

    @Autowired
    private SicknessRepository sicknessRepository;

    @PostConstruct
    public void init() {

        Doctor doctor = new Doctor();
        doctor.setName("doc");
        doctor.setPassword("doc");
        doctor.setUsername("doc");

        doctorRepository.save(doctor);

        Sickness sick = new Sickness();
        sick.setDoctor(doctor);
        sick.setSymptoms("headache");
        sick.setTreatmentStatus(false);

        sicknessRepository.save(sick);
        
        List<Sickness> sicklist= new ArrayList<>();
        sicklist.add(sick);
       
        Patient patient = new Patient();
        patient.setName("pat");
        patient.setUsername("pat");
        patient.setPassword("pat");
        patient.setOwnDoctor(doctor);
        patient.setSickness(sicklist);
        
        
        
        patientRepository.save(patient);
        
        sick.setPatient(patient);
        
        sicknessRepository.save(sick);
        List<Sickness> sicklistDoc= new ArrayList<>();
        sicklistDoc.add(sick);
        doctor.setTreatedSicknesses(sicklist);

        doctorRepository.save(doctor);

    }
}
