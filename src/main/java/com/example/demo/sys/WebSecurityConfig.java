package com.example.demo.sys;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin", "/admin/*").authenticated()
                .antMatchers("/userｓ", "/userｓ/*").authenticated()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .loginProcessingUrl("/loginProc")
                .successForwardUrl("/GS/list?pagenum=1&contentnum=10&searchtype=tosyo_num&keyword=")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()	
            	.logoutUrl("/logout")
            	.logoutSuccessUrl("/login");
             http.cors().and();
             http.csrf().disable();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from user where username = ?")
				.authoritiesByUsernameQuery("select username, authority from user where username = ?")
				.passwordEncoder(new BCryptPasswordEncoder());
	}
}