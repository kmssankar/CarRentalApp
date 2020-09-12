package com.cts.fse.car.rental.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/searchcars","/home","/register","/").permitAll()
		.antMatchers("/manageusers").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/managefleet","/viewreviews").hasAnyAuthority("ROLE_ADMIN","ROLE_VENDOR")
		.antMatchers("/bookcar","/returncar").hasAnyAuthority("ROLE_ADMIN","ROLE_VENDOR","ROLE_USER")
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
				  .authenticated().and().formLogin().loginPage("/login")
	              .defaultSuccessUrl("/")
	              .failureUrl("/login?error")
	              .permitAll().and().logout().permitAll().and().httpBasic();
	}
}
