/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.services;

import com.mycompany.doctorapp.domain.Doctor;
import com.mycompany.doctorapp.domain.Patient;
import com.mycompany.doctorapp.domain.Person;
import com.mycompany.doctorapp.domain.Sickness;
import com.mycompany.doctorapp.repository.DoctorRepository;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.doctorapp.repository.PatientRepository;
import com.mycompany.doctorapp.repository.SicknessRepository;

/**
 *
 * @author Juhana
 */
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SicknessRepository sicknessRepository;
    
    public void newPatient(Person person) {
        Patient patient = new Patient();
        patient.setName(person.getName());
        patient.setUsername(person.getUsername());
        patient.setPwAndSalt(person.getPassword(), person.getSalt());
        
        Doctor doc = getRandomDoc();
        patient.setOwnDoctor(doc);
        doc.addPatient(patient);
        
        patientRepository.save(patient);
        doctorRepository.save(doc);

    }

    public Doctor getRandomDoc() {
        List<Doctor> docs = doctorRepository.findAll();
        int rnd = new Random().nextInt(docs.size());
        return docs.get(rnd);
    }
    
    public void newSickness(Patient patient, Sickness sickness){
        
        patient.getSickness().add(sickness);
        sickness.setPatient(patient);        
        sickness.setDoctor(patient.getOwnDoctor());
        
        patientRepository.save(patient);
        sicknessRepository.save(sickness);
        

    }
}
