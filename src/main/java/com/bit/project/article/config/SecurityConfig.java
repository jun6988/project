package com.bit.project.article.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//public class SecurityConfig {
////localhost8080/articles 찍으면 login page 안나온다.
// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// return http
// .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
// .formLogin().and()
// .build();
// }
////}
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
////                        .mvcMatchers(
////                                HttpMethod.GET,
////                                "/",
////                                "/articles",
////                                "/articles/search-hashtag"
////                        ).permitAll()
////                        .anyRequest().authenticated()
////                )
////                .formLogin().and()
////                .logout()
////                        .logoutSuccessUrl("/")
////                        .and()
////                .build();
////    }
//
//    @Bean
//    public UserDetailsService userDetailsService(AccountRepository accountRepository) {
//        return username -> accountRepository
//                .findById(username)
//                .map(AccountDto::from)
//                .map(BoardPrincipal::from)
//                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: " + username));
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//}

//----

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
// 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // configure security settings
//    }
// 
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/**");
//    }
// 
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
// 
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
// 
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager();
//    }
// 
//}

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();
    }
 
}
