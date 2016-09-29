package com.mycompany.doctorapp.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Report extends AbstractPersistable<Long>{
    
    @OneToOne
    private Sickness sickness;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    
    private String content;
}
