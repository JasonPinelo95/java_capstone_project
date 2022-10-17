package com.example.university.config;

import com.example.university.repository.ProfessorRepository;
import com.example.university.repository.StudentRepository;
import com.example.university.services.implementation.ProfessorDetailsServiceImpl;
import com.example.university.services.implementation.StudentDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    @Autowired
    public SecurityConfig(StudentRepository studentRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/students/**").hasRole("STUDENT")
                .antMatchers("/professors/**").hasRole("PROFESSOR")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        StudentDetailsServiceImpl studentDetailsService = new StudentDetailsServiceImpl(studentRepository);
        ProfessorDetailsServiceImpl professorDetailsService = new ProfessorDetailsServiceImpl(professorRepository);
        auth.userDetailsService(studentDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
        auth.userDetailsService(professorDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}