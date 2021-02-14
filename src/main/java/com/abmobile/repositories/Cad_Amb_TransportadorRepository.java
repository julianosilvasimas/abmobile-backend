package com.abmobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Cad_Amb_Transportador;

@Repository
public interface Cad_Amb_TransportadorRepository extends JpaRepository< Cad_Amb_Transportador , Integer>{
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Cad_Amb_Transportador obj WHERE obj.Desativado = false ORDER BY obj.Razao")
	List<Cad_Amb_Transportador> findAllValid();
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Cad_Amb_Transportador obj WHERE obj.Desativado = false AND obj.Razao Like :razao ORDER BY obj.Razao")
	List<Cad_Amb_Transportador> findByRazao(@Param("razao") String razao);

}
