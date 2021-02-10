package com.abmobile.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abmobile.domain.Sis_Usuario;
import com.abmobile.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	 
	@Autowired
	private UsuarioService service;
	private Sis_Usuario obj;
	
	
		
	public Sis_Usuario getObj() {
		return obj;
	}

	public void setObj(Sis_Usuario obj) {
		this.obj = obj;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
    public ResponseEntity<List<Sis_Usuario>> findAll() {
        final List<Sis_Usuario> list = this.service.findAll();
        return (ResponseEntity<List<Sis_Usuario>>)ResponseEntity.ok().body(list);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Sis_Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Sis_Usuario obj) {
		System.out.println(obj.getPassword());
		setObj(service.insert(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getIdusuario()).toUri();
		return ResponseEntity.created(uri).build();
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Sis_Usuario obj, @PathVariable Integer id) {
		obj.setIdusuario(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/attsenha/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateSenha(@RequestBody Sis_Usuario obj, @PathVariable Integer id) {
		obj.setIdusuario(id);
		obj = service.attSenha(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/attativo/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateAtivo(@RequestBody Sis_Usuario obj, @PathVariable Integer id) {
		obj.setIdusuario(id);
		obj = service.attAtivo(obj);
		return ResponseEntity.noContent().build();
	}
		
}
