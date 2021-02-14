package com.abmobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Vw_Cad_Amb_Veiculo;

@Repository
public interface Vw_Cad_Amb_VeiculoRepository extends JpaRepository< Vw_Cad_Amb_Veiculo , Integer>{
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Vw_Cad_Amb_Veiculo obj WHERE obj.Desativado = false")
	List<Vw_Cad_Amb_Veiculo> findAllValid();
	
	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Vw_Cad_Amb_Veiculo obj WHERE obj.Desativado = false AND obj.idTransportador = :idTransportador")
	List<Vw_Cad_Amb_Veiculo> findByTrans(@Param("idTransportador") Integer idTransportador);

}
