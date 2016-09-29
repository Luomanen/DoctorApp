/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.services;

import com.mycompany.doctorapp.domain.Person;
import com.mycompany.doctorapp.repository.DoctorRepository;
import com.mycompany.doctorapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juhana
 */
@Service
public class PersonService {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private PatientRepository patientRepository;
    
    //finds a person from doctor or patient repo
    public Person findByUsername(String username){
        Person person = patientRepository.findByUsername(username);
        
        if (person==null){
            person = doctorRepository.findByUsername(username);
        }
        
        return person;
    }
    
}
