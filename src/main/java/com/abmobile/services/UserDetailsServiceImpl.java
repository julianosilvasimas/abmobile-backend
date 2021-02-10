package com.abmobile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abmobile.domain.Sis_Usuario;
import com.abmobile.repositories.UsuarioRepository;
import com.abmobile.security.UserSS;

 @Service
 public class UserDetailsServiceImpl implements UserDetailsService {

	 	@Autowired
		private UsuarioRepository repo;
		
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			
			Sis_Usuario uso = repo.findByEmail(email);
			
			if (uso == null) {
				throw new UsernameNotFoundException("usuario não foi encontrado");
			}
			return new UserSS(uso.getIdusuario(), uso.getEmail(), uso.getPassword(), uso.getPerfis());
			
		}
			
	}
