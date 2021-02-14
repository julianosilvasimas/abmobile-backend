package com.abmobile.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abmobile.domain.Vw_Cad_Amb_Motorista;
import com.abmobile.services.Vw_Cad_Amb_MotoristaService;

@RestController
@RequestMapping(value="/motoristas")
public class Vw_Cad_Amb_MotoristaResource {

	@Autowired
	private Vw_Cad_Amb_MotoristaService service;
	private Vw_Cad_Amb_Motorista obj;
		
	public Vw_Cad_Amb_Motorista getObj() {
		return obj;
	}

	public void setObj(Vw_Cad_Amb_Motorista obj) {
		this.obj = obj;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
    public ResponseEntity<List<Vw_Cad_Amb_Motorista>> findAll() {
        final List<Vw_Cad_Amb_Motorista> list = this.service.findAll();
        return (ResponseEntity<List<Vw_Cad_Amb_Motorista>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/razao/{idTrans}",method = { RequestMethod.GET })
    public ResponseEntity<List<Vw_Cad_Amb_Motorista>> findByTrans(@PathVariable Integer idTrans) {
        final List<Vw_Cad_Amb_Motorista> list = this.service.findByTrans(idTrans);
        return (ResponseEntity<List<Vw_Cad_Amb_Motorista>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Vw_Cad_Amb_Motorista obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
