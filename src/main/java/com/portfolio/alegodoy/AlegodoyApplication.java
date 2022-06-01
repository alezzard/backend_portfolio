package com.portfolio.alegodoy;

import com.portfolio.alegodoy.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class AlegodoyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlegodoyApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter{

		protected void configure(HttpSecurity http) throws Exception{
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					/*.antMatchers(HttpMethod.GET,"/**").permitAll() ORIGINALES
					.antMatchers(HttpMethod.POST,"/**").authenticated()
					.antMatchers(HttpMethod.PUT,"/**").authenticated()
					.antMatchers(HttpMethod.DELETE,"/**").authenticated();*/
					.antMatchers(HttpMethod.GET,"/**").permitAll()//PRUEBA
					.antMatchers(HttpMethod.POST,"/login").permitAll()
					.antMatchers(HttpMethod.POST,"/**").authenticated()
					.antMatchers(HttpMethod.PUT,"/**").permitAll()
					.antMatchers(HttpMethod.DELETE,"/**").permitAll();
		}

		/*@Override//
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// Creamos una cuenta de usuario por default
			auth.inMemoryAuthentication()
					.withUser("gabriel.alegodoy92@gmail.com")
					.password("gabriel.alegodoy92")
					.roles("ADMIN");
		}*/

	}
}
