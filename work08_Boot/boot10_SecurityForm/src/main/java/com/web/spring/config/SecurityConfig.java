package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("SecurityFilterChain======================>");
		http
			.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) //어떤 요청에도 무조건 인증받도록...
			//.formLogin(Customizer.withDefaults()); //폼 로그인 방식으로 인증 받겠다...디폴트..
			.formLogin(form -> form
					//.loginPage("/loginPage") //여기선 Security가 제공하는 폼을 쓰겠다.
					.loginProcessingUrl("/loginProc")
					.usernameParameter("userId")
					.passwordParameter("userPass")
					//.defaultSuccessUrl("/", false) //기본이 false, true는 항상 사용
					//.failureUrl("/failed")
					
					.successHandler((request, response, authentication) -> {
						response.sendRedirect("/home"); //성공하면 home이 출력..
					})
					.failureHandler((request, response, excetpion) -> {
						response.sendRedirect("/login");
					})
					.permitAll()
			);
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		log.info("UserDetailService=======================>");
		UserDetails user = User.withUsername("kosta")
								.password("{noop}1234")
								.roles("USER").build(); //ROLE_ 자동으로 붙는다..

		log.info("UserDetailService=======================> user :: {} ", user);
		return new InMemoryUserDetailsManager(user);
	}
}
