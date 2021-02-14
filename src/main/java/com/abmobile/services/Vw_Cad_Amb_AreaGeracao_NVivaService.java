package com.abmobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.abmobile.domain.Vw_Cad_Amb_AreaGeracao_NViva;
import com.abmobile.repositories.Vw_Cad_Amb_AreaGeracao_NVivaRepository;

@Service
public class Vw_Cad_Amb_AreaGeracao_NVivaService {
	
	@Autowired
	private Vw_Cad_Amb_AreaGeracao_NVivaRepository repo;
	
	public List<Vw_Cad_Amb_AreaGeracao_NViva> findAll() {
		return repo.findAllValid();
	}
	
	public List<Vw_Cad_Amb_AreaGeracao_NViva>  findByDescricao(String descricao) {
		return repo.findByRazao("%"+descricao+"%");
	}
	
	public Vw_Cad_Amb_AreaGeracao_NViva find(Integer id) {
		Optional<Vw_Cad_Amb_AreaGeracao_NViva> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
		
	public Page<Vw_Cad_Amb_AreaGeracao_NViva> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
