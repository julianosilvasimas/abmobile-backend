package com.abmobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Sis_Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository< Sis_Usuario , Integer>{
	
	@Transactional(readOnly=true)
	Sis_Usuario findByEmail(String email);
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Sis_Usuario obj WHERE obj.desativado = false ORDER BY obj.nome")
	List<Sis_Usuario> findAllValid();

}
