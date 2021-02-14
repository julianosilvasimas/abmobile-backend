package com.abmobile.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abmobile.domain.Vw_Cad_Amb_Veiculo;
import com.abmobile.services.Vw_Cad_Amb_VeiculoService;

@RestController
@RequestMapping(value="/veiculos")
public class Vw_Cad_Amb_VeiculoResource {

	@Autowired
	private Vw_Cad_Amb_VeiculoService service;
	private Vw_Cad_Amb_Veiculo obj;
		
	public Vw_Cad_Amb_Veiculo getObj() {
		return obj;
	}

	public void setObj(Vw_Cad_Amb_Veiculo obj) {
		this.obj = obj;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
    public ResponseEntity<List<Vw_Cad_Amb_Veiculo>> findAll() {
        final List<Vw_Cad_Amb_Veiculo> list = this.service.findAll();
        return (ResponseEntity<List<Vw_Cad_Amb_Veiculo>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/trans/{idTrans}",method = { RequestMethod.GET })
    public ResponseEntity<List<Vw_Cad_Amb_Veiculo>> findByTrans(@PathVariable Integer idTrans) {
        final List<Vw_Cad_Amb_Veiculo> list = this.service.findByTrans(idTrans);
        return (ResponseEntity<List<Vw_Cad_Amb_Veiculo>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Vw_Cad_Amb_Veiculo obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
