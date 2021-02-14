package com.abmobile.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.abmobile.security.JWTAuthenticationFilter;
import com.abmobile.security.JWTAuthorizationFilter;
import com.abmobile.security.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private Environment env;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	// Permissão para alteração
	private static final String[] PUBLIC_MATCHERS = {
			//Comentar esses endpoints para que possam ser acessados com envio da chave pelo header da requisição
			"/usuarios/**",
			"/reslan/**",
			"/veiculos/**",
			"/motoristas/**",
			"/transportador/**",
			"/area/**",
			"/residuo/**"
	};
	
	// Permissão somente Leitura
 	private static final String[] PUBLIC_MATCHERS_GET = {
			
 	};

	private static final String[] PUBLIC_MATCHERS_POST = {
			
	};
	

	
 	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			//Aqui permito apenas o método POST
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			//Aqui permito apenas o método GET 
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			//Aqui permito todo tipo de transação
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
