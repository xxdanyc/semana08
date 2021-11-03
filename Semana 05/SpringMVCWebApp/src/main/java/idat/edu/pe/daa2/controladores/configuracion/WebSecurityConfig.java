package idat.edu.pe.daa2.controladores.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/css/**", "/imagenes/**", "/js/**", "/", "/principal", "/home", "/inicio", "/logeo", "/login")
		.permitAll()
		.antMatchers("/peliculas/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/peliculas/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/peliculas/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/peliculas/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/peliculas/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
		.and().logout()
		.permitAll();

	}
	
	
	
}
