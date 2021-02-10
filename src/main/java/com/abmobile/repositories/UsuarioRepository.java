package com.abmobile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Sis_Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository< Sis_Usuario , Integer>{
	
	@Transactional(readOnly=true)
	Sis_Usuario findByEmail(String email);

}
