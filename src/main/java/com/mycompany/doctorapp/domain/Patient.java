package com.mycompany.doctorapp.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient extends Person{

    private int idNumber;
    
    @ManyToOne
    private Doctor ownDoctor;
    
    @OneToMany
    private List<Sickness> sickness;

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Doctor getOwnDoctor() {
        return ownDoctor;
    }

    public void setOwnDoctor(Doctor ownDoctor) {
        this.ownDoctor = ownDoctor;
    }

    public List<Sickness> getSickness() {
        return sickness;
    }

    public void setSickness(List<Sickness> sickness) {
        this.sickness = sickness;
    }
    
    
    


}
