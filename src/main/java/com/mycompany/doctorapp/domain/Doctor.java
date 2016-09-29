package com.mycompany.doctorapp.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class Doctor extends Person {

    @OneToMany(mappedBy="ownDoctor")
    private List<Patient> patients;
    
    @OneToMany(mappedBy="")
    private List<Sickness> treatedSciknesses;
    
    @OneToMany
    private List<Report> writtenReports;

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Sickness> getTreatedSciknesses() {
        return treatedSciknesses;
    }

    public void setTreatedSciknesses(List<Sickness> treatedSciknesses) {
        this.treatedSciknesses = treatedSciknesses;
    }

    public List<Report> getWrittenReports() {
        return writtenReports;
    }

    public void setWrittenReports(List<Report> writtenReports) {
        this.writtenReports = writtenReports;
    }
    
    public void addPatient(Patient patient){
        this.patients.add(patient);
    }
}
