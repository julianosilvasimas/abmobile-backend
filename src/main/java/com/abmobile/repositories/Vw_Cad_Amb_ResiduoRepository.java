package com.abmobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Vw_Cad_Amb_Residuo;

@Repository
public interface Vw_Cad_Amb_ResiduoRepository extends JpaRepository< Vw_Cad_Amb_Residuo , Integer>{
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Vw_Cad_Amb_Residuo obj WHERE obj.Desativado = false ORDER BY obj.Descricao")
	List<Vw_Cad_Amb_Residuo> findAllValid();
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Vw_Cad_Amb_Residuo obj WHERE obj.Desativado = false AND obj.Descricao Like :descricao ORDER BY obj.Descricao")
	List<Vw_Cad_Amb_Residuo> findByRazao(@Param("descricao") String descricao);

}
