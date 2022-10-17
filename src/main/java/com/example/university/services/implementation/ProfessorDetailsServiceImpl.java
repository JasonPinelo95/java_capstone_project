package com.example.university.services.implementation;

import com.example.university.model.Professor;
import com.example.university.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProfessorDetailsServiceImpl implements UserDetailsService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorDetailsServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Professor professor = professorRepository.findByEmail(email);
        if (professor == null) {
            throw new UsernameNotFoundException(email + " not found");
        }

        return User.builder()
                .username(professor.getUsername())
                .password(professor.getPassword())
                .disabled(!professor.isEnabled())
                .accountExpired(!professor.isAccountNonExpired())
                .accountLocked(!professor.isAccountNonLocked())
                .credentialsExpired(!professor.isCredentialsNonExpired())
                .roles("PROFESSOR")
                .build();
    }


}

