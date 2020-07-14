package in.nit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@SuppressWarnings("deprecation")

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("rohit").password("gupta").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("rohit").password("gupta2").roles("USER");
	}

	/*
	// Ssecurity for all API
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	}
	*/
	
	// security for each API particularly(security based on URL)
	/*
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/rest/**").anyRequest().fullyAuthenticated().and().httpBasic();
		http.authorizeRequests().antMatchers("/userAuth/**").anyRequest().fullyAuthenticated().and().httpBasic();
	}
	*/
	
	// Security based on user
	// here there is two authentication , one is user(and access URL starting with /rest/) and another admin(can access URL starting with /userAuth)
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").and().authorizeRequests().antMatchers("/userAuth/**").hasAnyRole("USER").anyRequest().fullyAuthenticated().and().httpBasic();
		
	}




	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder()
	{
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
