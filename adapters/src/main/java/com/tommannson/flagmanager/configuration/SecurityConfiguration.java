package com.tommannson.flagmanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfiguration {
//public class SecurityConfiguration
//        extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/flags").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }


//public class SecurityConfiguration {
    //        extends KeycloakWebSecurityConfigurerAdapter {
//
//    @Bean
//    KeycloakSpringBootConfigResolver configResolver(){
//        return new KeycloakSpringBootConfigResolver();
//    }
//
//    @Autowired
//    void configureGlobal(AuthenticationManagerBuilder builder) {
//        SimpleAuthorityMapper authMapper = new SimpleAuthorityMapper();
//        authMapper.setPrefix("ROLE_");
//        authMapper.setConvertToUpperCase(true);
//
//        KeycloakAuthenticationProvider authProvider = new KeycloakAuthenticationProvider();
//        authProvider.setGrantedAuthoritiesMapper(authMapper);
//
//        builder.authenticationProvider(authProvider);
//    }
//
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http
//                .authorizeRequests()
//                .antMatchers("/authpath/*")
//                .hasRole("USER")
//                .anyRequest()
//                .permitAll();
//    }
}
