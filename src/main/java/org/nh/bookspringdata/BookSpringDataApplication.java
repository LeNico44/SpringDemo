package org.nh.bookspringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class BookSpringDataApplication {
	@Configuration
	static class SecuityConfig extends WebSecurityConfigurerAdapter{

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception {
			auth.inMemoryAuthentication()
					.withUser("nicolas").password("{noop} ").roles("USER", "USER_API", "ADMIN").and()
					.withUser("api").password("{noop}pwd").roles("USER_API");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
					.antMatchers("/**").hasAnyRole("ADMIN", "USER").and()
					.httpBasic().and()
					.csrf().disable();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(BookSpringDataApplication.class, args);
	}
}
