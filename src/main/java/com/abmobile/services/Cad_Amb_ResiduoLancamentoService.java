package com.abmobile.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Cad_Amb_ResiduoLancamento;
import com.abmobile.repositories.Cad_Amb_ResiduoLancamentoRepository;

@Service
public class Cad_Amb_ResiduoLancamentoService {
	
	@Autowired
	private Cad_Amb_ResiduoLancamentoRepository repo;
	
	public List<Cad_Amb_ResiduoLancamento> findAll() {
		return repo.findAll();
	}
	
	public Cad_Amb_ResiduoLancamento find(Integer id) {
		Optional<Cad_Amb_ResiduoLancamento> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Page<Cad_Amb_ResiduoLancamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	@Transactional
	public Cad_Amb_ResiduoLancamento insert(Cad_Amb_ResiduoLancamento obj) throws ParseException {

		Date d = new Date();

		SimpleDateFormat h = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date hour = in.parse("1899-12-30 "+h.format(d));
			
		obj.setIdResLan(null);
		obj.setDtRecebi(d);
		obj.setHrRecebi(hour);
		return repo.save(obj);
	}
	
	@Transactional
	public Cad_Amb_ResiduoLancamento update(Cad_Amb_ResiduoLancamento obj) {
		Cad_Amb_ResiduoLancamento oldObj = find(obj.getIdResLan());
		updateData(oldObj, obj);
		return repo.save(oldObj);
	}
	
	private void updateData(Cad_Amb_ResiduoLancamento oldObj, Cad_Amb_ResiduoLancamento obj) {
		/*oldObj.setNome(obj.getNome());
		oldObj.setEmail(obj.getEmail());
		oldObj.setUsuario(obj.getUsuario());*/
	}

}
