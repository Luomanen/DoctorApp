/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doctorapp.repository;

import com.mycompany.doctorapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author null
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
    
}
