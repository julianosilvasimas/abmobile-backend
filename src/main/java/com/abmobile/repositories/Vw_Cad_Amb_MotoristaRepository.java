package com.abmobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Vw_Cad_Amb_Motorista;

@Repository
public interface Vw_Cad_Amb_MotoristaRepository extends JpaRepository< Vw_Cad_Amb_Motorista , Integer>{
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Vw_Cad_Amb_Motorista obj WHERE obj.Desativado = false ORDER BY obj.Nome")
	List<Vw_Cad_Amb_Motorista> findAllValid();
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Vw_Cad_Amb_Motorista obj WHERE obj.Desativado = false AND obj.idTransportador = :idTransportador ORDER BY obj.Nome")
	List<Vw_Cad_Amb_Motorista> findByTrans(@Param("idTransportador") Integer idTransportador);
	
}
