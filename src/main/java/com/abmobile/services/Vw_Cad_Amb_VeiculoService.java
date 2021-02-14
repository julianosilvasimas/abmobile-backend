package com.abmobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.abmobile.domain.Vw_Cad_Amb_Veiculo;
import com.abmobile.repositories.Vw_Cad_Amb_VeiculoRepository;

@Service
public class Vw_Cad_Amb_VeiculoService {
	
	@Autowired
	private Vw_Cad_Amb_VeiculoRepository repo;
	
	public List<Vw_Cad_Amb_Veiculo> findAll() {
		return repo.findAllValid();
	}
	
	public List<Vw_Cad_Amb_Veiculo>  findByTrans(Integer idTrans) {
		return repo.findByTrans(idTrans);
	}
	
	public Vw_Cad_Amb_Veiculo find(Integer id) {
		Optional<Vw_Cad_Amb_Veiculo> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	
	
	public Page<Vw_Cad_Amb_Veiculo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
