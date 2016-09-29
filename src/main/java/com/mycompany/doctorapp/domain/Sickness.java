package com.mycompany.doctorapp.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Sickness extends AbstractPersistable<Long>{
private String nimi;
private String treatment;
@ManyToOne
private Doctor doctor;

@ManyToOne
private Patient patient;




    public String getNimi() {
        return nimi;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Doctor getDoctor() {
        return doctor;
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

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getHoitoOhje() {
        return treatment;
    }

    public void setHoitoOhje(String treatment) {
        this.treatment = treatment;
    }

}
