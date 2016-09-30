package com.mycompany.doctorapp.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Sickness extends AbstractPersistable<Long> {

    @NotEmpty
    private String symptoms;

    @OneToOne
    private Treatment treatment;
    
    private boolean treatmentStatus;
    

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    public boolean isTreatmentStatus() {
        return treatmentStatus;
    }

    public boolean getTreatmentStatus() {
        return treatmentStatus;
    }

    public void setTreatmentStatus(boolean treatmentStatus) {
        this.treatmentStatus = treatmentStatus;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
