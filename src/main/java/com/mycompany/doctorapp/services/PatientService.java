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
import java.util.ArrayList;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

        //debug
        System.out.println("patient creation success");
        patientRepository.save(patient);
        doctorRepository.save(doc);

    }

    public void addSickness(Sickness sickness) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println(username);
        Patient authpatient = patientRepository.findByUsername(username);

        if (authpatient == null) {
            System.out.println("patient not found");
        }

        Doctor doctor = authpatient.getOwnDoctor();

        if (doctor == null) {
            System.out.println("No medic found");
        }
        //if no list of treated sicknesses exists for the patient already, create one
        if (authpatient.getSickness() == null) {
            List<Sickness> lista = new ArrayList<>();
            lista.add(sickness);
            authpatient.setSickness(lista);
        } else {
            authpatient.getSickness().add(sickness);
        }

        sickness.setTreatmentStatus(false);

        //if no list of treated sicknesses exists for the doctor already, create one
        if (doctor.getTreatedSicknesses() == null) {
            List<Sickness> lista = new ArrayList<>();
            lista.add(sickness);
            doctor.setTreatedSicknesses(lista);
        } else {
            doctor.getTreatedSicknesses().add(sickness);
        }

        sicknessRepository.save(sickness);
        patientRepository.save(authpatient);

        sickness.setPatient(authpatient);
        sickness.setDoctor((doctor));

        sicknessRepository.save(sickness);

    }

    public Doctor getRandomDoc() {
        List<Doctor> docs = doctorRepository.findAll();
        int rnd = new Random().nextInt(docs.size());
        return docs.get(rnd);
    }

    public void newSickness(Patient patient, Sickness sickness) {

        patient.getSickness().add(sickness);
        sickness.setPatient(patient);
        sickness.setDoctor(patient.getOwnDoctor());

        patientRepository.save(patient);
        sicknessRepository.save(sickness);

    }

}
