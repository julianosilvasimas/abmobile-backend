package com.abmobile.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abmobile.domain.Vw_Cad_Amb_Residuo;
import com.abmobile.services.Vw_Cad_Amb_ResiduoService;

@RestController
@RequestMapping(value="/residuo")
public class Vw_Cad_Amb_ResiduoResource {

	@Autowired
	private Vw_Cad_Amb_ResiduoService service;
	private Vw_Cad_Amb_Residuo obj;
		
	public Vw_Cad_Amb_Residuo getObj() {
		return obj;
	}

	public void setObj(Vw_Cad_Amb_Residuo obj) {
		this.obj = obj;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
    public ResponseEntity<List<Vw_Cad_Amb_Residuo>> findAll() {
        final List<Vw_Cad_Amb_Residuo> list = this.service.findAll();
        return (ResponseEntity<List<Vw_Cad_Amb_Residuo>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/desc/{descricao}",method = { RequestMethod.GET })
    public ResponseEntity<List<Vw_Cad_Amb_Residuo>> findByDesc(@PathVariable String descricao) {
        final List<Vw_Cad_Amb_Residuo> list = this.service.findByDescricao(descricao);
        return (ResponseEntity<List<Vw_Cad_Amb_Residuo>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Vw_Cad_Amb_Residuo obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
