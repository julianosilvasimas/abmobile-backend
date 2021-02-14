package com.abmobile.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abmobile.domain.Cad_Amb_Transportador;
import com.abmobile.services.Cad_Amb_TransportadorService;

@RestController
@RequestMapping(value="/transportador")
public class Cad_Amb_TransportadorResource {

	@Autowired
	private Cad_Amb_TransportadorService service;
	private Cad_Amb_Transportador obj;
		
	public Cad_Amb_Transportador getObj() {
		return obj;
	}

	public void setObj(Cad_Amb_Transportador obj) {
		this.obj = obj;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
    public ResponseEntity<List<Cad_Amb_Transportador>> findAll() {
        final List<Cad_Amb_Transportador> list = this.service.findAll();
        return (ResponseEntity<List<Cad_Amb_Transportador>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/razao/{razao}",method = { RequestMethod.GET })
    public ResponseEntity<List<Cad_Amb_Transportador>> findByTrans(@PathVariable String razao) {
        final List<Cad_Amb_Transportador> list = this.service.findByRazao(razao);
        return (ResponseEntity<List<Cad_Amb_Transportador>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cad_Amb_Transportador obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
