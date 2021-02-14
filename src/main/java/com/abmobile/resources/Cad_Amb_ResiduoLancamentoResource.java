package com.abmobile.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abmobile.domain.Cad_Amb_ResiduoLancamento;
import com.abmobile.services.Cad_Amb_ResiduoLancamentoService;

@RestController
@RequestMapping(value="/reslan")
public class Cad_Amb_ResiduoLancamentoResource {
	
	@Autowired
	private Cad_Amb_ResiduoLancamentoService service;
	private Cad_Amb_ResiduoLancamento obj;
		
	public Cad_Amb_ResiduoLancamento getObj() {
		return obj;
	}

	public void setObj(Cad_Amb_ResiduoLancamento obj) {
		this.obj = obj;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
    public ResponseEntity<List<Cad_Amb_ResiduoLancamento>> findAll() {
        final List<Cad_Amb_ResiduoLancamento> list = this.service.findAll();
        return (ResponseEntity<List<Cad_Amb_ResiduoLancamento>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cad_Amb_ResiduoLancamento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cad_Amb_ResiduoLancamento obj) throws ParseException {
		
		setObj(service.insert(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getIdResLan()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cad_Amb_ResiduoLancamento obj, @PathVariable Integer id) {
		obj.setIdResLan(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Cad_Amb_ResiduoLancamento>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="idResLan") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Cad_Amb_ResiduoLancamento> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}

}
