package com.abmobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Cad_Amb_ResiduoLancamento;

@Repository
public interface Cad_Amb_ResiduoLancamentoRepository extends JpaRepository< Cad_Amb_ResiduoLancamento , Integer>{

	@Transactional(readOnly = true)
    @Query("SELECT obj FROM Cad_Amb_ResiduoLancamento obj WHERE obj.Desativado = false")
	List<Cad_Amb_ResiduoLancamento> findAllValid();
	
}
