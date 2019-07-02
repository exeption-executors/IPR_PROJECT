package ru.raiffeisen.ipr.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email,password, true from client where email=?")
                .authoritiesByUsernameQuery("select email, role from client where email=?");
    }


    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("select email from client where email=?").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("ADMIN");

    //        @Autowired
//        public void configAuthentication (AuthenticationManagerBuilder auth) throws Exception {
//            auth.jdbcAuthentication()
//                    .usersByUsernameQuery("select email,password, enabled from client where email=?");
//        }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin").hasRole("ADMIN")
////                    .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
////                    .permitAll();
////            http.exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }


}
