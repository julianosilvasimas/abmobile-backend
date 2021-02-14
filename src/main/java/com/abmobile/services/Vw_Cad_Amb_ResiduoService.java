package com.abmobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.abmobile.domain.Vw_Cad_Amb_Residuo;
import com.abmobile.repositories.Vw_Cad_Amb_ResiduoRepository;

@Service
public class Vw_Cad_Amb_ResiduoService {
	
	@Autowired
	private Vw_Cad_Amb_ResiduoRepository repo;
	
	public List<Vw_Cad_Amb_Residuo> findAll() {
		return repo.findAllValid();
	}
	
	public List<Vw_Cad_Amb_Residuo>  findByDescricao(String descricao) {
		return repo.findByRazao("%"+descricao+"%");
	}
	
	public Vw_Cad_Amb_Residuo find(Integer id) {
		Optional<Vw_Cad_Amb_Residuo> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
		
	public Page<Vw_Cad_Amb_Residuo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
