package com.mycompany.doctorapp.auth;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import com.mycompany.doctorapp.domain.Person;
import com.mycompany.doctorapp.repository.DoctorRepository;
import com.mycompany.doctorapp.repository.PatientRepository;

@Component
public class JpaAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String username = a.getPrincipal().toString();
        String password = a.getCredentials().toString();
        boolean isDoc = false;
        Person person = patientRepository.findByUsername(username);

        if (person == null) {
            person = doctorRepository.findByUsername(username);
            isDoc = true;
            if (person == null) {
                throw new AuthenticationException("Unable to authenticate user " + username) {
                };
            }

        }

        if (!BCrypt.hashpw(password, person.getSalt()).equals(person.getPassword())) {
            throw new AuthenticationException("Unable to authenticate user " + username) {
            };
        }

        //if not doctor, aka is a patient
        if (!isDoc) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("USER"));
            return new UsernamePasswordAuthenticationToken(person.getUsername(), password, grantedAuths);
        }
        //is doctor
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("DOCTOR"));
        return new UsernamePasswordAuthenticationToken(person.getUsername(), password, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }

}
