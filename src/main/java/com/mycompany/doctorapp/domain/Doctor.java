package com.mycompany.doctorapp.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class Doctor extends Person {

    @OneToMany(mappedBy="ownDoctor")
    private List<Patient> patients;
    
    @OneToMany(mappedBy="")
    private List<Sickness> treatedSicknesses;
    
    @OneToMany
    private List<Treatment> writtenReports;

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Sickness> getTreatedSicknesses() {
        return treatedSicknesses;
    }

    public void setTreatedSicknesses(List<Sickness> treatedSicknesses) {
        this.treatedSicknesses = treatedSicknesses;
    }

    public List<Treatment> getWrittenReports() {
        return writtenReports;
    }

    public void setWrittenReports(List<Treatment> writtenReports) {
        this.writtenReports = writtenReports;
    }
    
    public void addPatient(Patient patient){
        if(this.patients.isEmpty()){
            patients = new ArrayList<>();
        }
        patients.add(patient);
    }
}
