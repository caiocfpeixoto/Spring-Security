package ifce.edu.br.MeuPrimeiroSpringBoot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ifce.edu.br.MeuPrimeiroSpringBoot.service.UsuarioService;

@EnableWebSecurity
public class SegurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService service;
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception { 
		http.authorizeRequests()
		// acessos publicos liberados 
		.antMatchers("/webjars/**", "/css/**", "/image/**", "/js/**").permitAll()
		.antMatchers("/","/home","/alunos/listar").permitAll()  
		
		// acessos privados admin
		.antMatchers("/u/**").hasAuthority("ADMIN")
		
		// acessos privados alunos
		.antMatchers("/alunos/**").hasAuthority("ALUNOS")
		
		.anyRequest().authenticated()
		.and() 
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/", true) 
		.failureUrl("/login-error") 
		.permitAll() 
	.and() 
		.logout() 
		.logoutSuccessUrl("/"); 
    }


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}   
     
	
}
