/*
package com.example.university.config;
import com.example.university.repository.StudentRepository;
import com.example.university.services.implementation.StudentDetailsServiceImpl;
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
@Order(1)
public class StudentSecurityConfig extends WebSecurityConfigurerAdapter {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentSecurityConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/students/login").permitAll()
                .antMatchers("/students/**").hasRole("STUDENT")
                .and()
                .formLogin()
                .loginPage("/students/login").permitAll()
                .failureUrl("/students/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/students/dashboard");
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        StudentDetailsServiceImpl studentDetailsService = new StudentDetailsServiceImpl(studentRepository);
        auth.userDetailsService(studentDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


}

*/