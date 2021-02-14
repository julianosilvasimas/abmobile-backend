package com.abmobile.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abmobile.domain.Vw_Cad_Amb_AreaGeracao_NViva;
import com.abmobile.services.Vw_Cad_Amb_AreaGeracao_NVivaService;

@RestController
@RequestMapping(value="/area")
public class Vw_Cad_Amb_AreaGeracao_NVivaResource {

	@Autowired
	private Vw_Cad_Amb_AreaGeracao_NVivaService service;
	private Vw_Cad_Amb_AreaGeracao_NViva obj;
		
	public Vw_Cad_Amb_AreaGeracao_NViva getObj() {
		return obj;
	}

	public void setObj(Vw_Cad_Amb_AreaGeracao_NViva obj) {
		this.obj = obj;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
    public ResponseEntity<List<Vw_Cad_Amb_AreaGeracao_NViva>> findAll() {
        final List<Vw_Cad_Amb_AreaGeracao_NViva> list = this.service.findAll();
        return (ResponseEntity<List<Vw_Cad_Amb_AreaGeracao_NViva>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/desc/{descricao}",method = { RequestMethod.GET })
    public ResponseEntity<List<Vw_Cad_Amb_AreaGeracao_NViva>> findByDesc(@PathVariable String descricao) {
        final List<Vw_Cad_Amb_AreaGeracao_NViva> list = this.service.findByDescricao(descricao);
        return (ResponseEntity<List<Vw_Cad_Amb_AreaGeracao_NViva>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Vw_Cad_Amb_AreaGeracao_NViva obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
