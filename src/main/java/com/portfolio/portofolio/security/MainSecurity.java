package com.portfolio.portofolio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.portfolio.portofolio.security.jwt.JwtEntryPoint;
// import com.portfolio.portofolio.security.jwt.JwtProvider;
import com.portfolio.portofolio.security.jwt.JwtTokenFilter;
import com.portfolio.portofolio.security.service.UserDetailsServiceImplementation;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImplementation userDetailsService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/**").permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}


// public class MainSecurity {


//     @Autowired
//     UserDetailsServiceImplementation userDSI;

//     @Autowired
//     JwtEntryPoint jwtEntryPoint;

//     @Autowired
//     JwtProvider jwtProvider;

//     @Autowired
//     JwtTokenFilter jwtTokenFilter;

//     @Bean
//     public JwtTokenFilter jwtTokenFilter(){
//         return new JwtTokenFilter();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeRequests().anyRequest().authenticated().and()
//             .exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and()
//             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//         http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
//             .authenticationProvider((AuthenticationProvider) jwtProvider);
//         return http.build();
//     }
    
// }
