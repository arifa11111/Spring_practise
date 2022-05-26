package com.Thymeleaf.thymeleaf.config;
import com.Thymeleaf.thymeleaf.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
     /*auth.inMemoryAuthentication()
        .withUser("arifa").password("{noop}arifa").roles("ADMIN")
                .and()
                .withUser("asha").password("{noop}asha").roles("USER")
                .and()
                .withUser("tc").password("{noop}tc").roles("TC");
    }*/

   @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
             //   .withDefaultSchema().withUser("user").password("pass").roles("USER");
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/user/**").permitAll()

                .antMatchers("/book","/passengers/showFormForAdd","/bookedSuccess").hasAnyRole("USER","TC","ADMIN")
                .antMatchers("/passengers/list").hasRole("TC")

                .antMatchers("/user/list").hasRole("ADMIN")

                .anyRequest().authenticated()
                .and()
                .formLogin()
               // .loginProcessingUrl("/authenticateTheUser")
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/405");
    }
}

