/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.repository;

import com.mycompany.doctorapp.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author null
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByUsername(String username);

}
