/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.repository;

import com.mycompany.doctorapp.domain.Treatment;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Juhana
 */
public interface TreatmentRepository extends JpaRepository<Treatment, Long>{
    
}
