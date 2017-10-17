package com.sergeeva.simpleSpringSecurityApp.security;

import com.sergeeva.simpleSpringSecurityApp.repository.UsersRepository;
import com.sergeeva.simpleSpringSecurityApp.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //User --> Roles
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER")
//                .and().withUser("user").password("user").roles("USER");

        auth.userDetailsService(userDetailsService);
        // TODO: 17.10.2017 разобраться с bcryptencoder 
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Roles -> Access
        http
                .authorizeRequests()
                .antMatchers("**/secured/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                .and().csrf().disable();

        /*
        .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/secured/**").hasRole("USER") //к данному узлу есть доступ у user
                .antMatchers("/**").hasRole("ADMIN") // у admin есть доступ к любому урлу
                .and().csrf().disable()
                .headers().frameOptions().disable();
         */
    }
}
