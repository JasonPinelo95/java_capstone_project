package com.example.university.services;

import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class StudentDetailsServiceImpl implements UserDetailsService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentDetailsServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(email);
        if (student == null) {
            throw new UsernameNotFoundException(email + " not found");
        }

        return User.builder()
                .username(student.getUsername())
                .password(student.getPassword())
                .disabled(!student.isEnabled())
                .accountExpired(!student.isAccountNonExpired())
                .accountLocked(!student.isAccountNonLocked())
                .credentialsExpired(!student.isCredentialsNonExpired())
                .roles("STUDENT")
                .build();
    }



}
