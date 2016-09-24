package com.mycompany.doctorapp.domain;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class Person {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotNull
    @NotBlank
    private String password;
    private String salt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.salt = BCrypt.gensalt();
        this.password = BCrypt.hashpw(password, this.salt);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Doctor getOmaLaakari() {
        return omaLaakari;
    }

    public void setOmaLaakari(Doctor omaLaakari) {
        this.omaLaakari = omaLaakari;
    }
    private Doctor omaLaakari;
    
}
