package com.abmobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.abmobile.domain.Cad_Amb_Transportador;
import com.abmobile.repositories.Cad_Amb_TransportadorRepository;

@Service
public class Cad_Amb_TransportadorService {
	
	@Autowired
	private Cad_Amb_TransportadorRepository repo;
	
	public List<Cad_Amb_Transportador> findAll() {
		return repo.findAllValid();
	}
	
	public List<Cad_Amb_Transportador>  findByRazao(String razao) {
		return repo.findByRazao("%"+razao+"%");
	}
	
	public Cad_Amb_Transportador find(Integer id) {
		Optional<Cad_Amb_Transportador> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
		
	public Page<Cad_Amb_Transportador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
