/*
package com.example.university.config;

import com.example.university.repository.ProfessorRepository;
import com.example.university.services.implementation.ProfessorDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class ProfessorSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorSecurityConfig(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/professors/login").permitAll()
                .antMatchers("/professors/**").hasRole("PROFESSOR")
                .and()
                .formLogin()
                .loginPage("/professors/login").permitAll()
                .failureUrl("/professors/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/professors/dashboard");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        ProfessorDetailsServiceImpl professorDetailsService = new ProfessorDetailsServiceImpl(professorRepository);
        auth.userDetailsService(professorDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
*/