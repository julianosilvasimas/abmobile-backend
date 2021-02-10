package com.abmobile.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abmobile.domain.Sis_Usuario;
import com.abmobile.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public List<Sis_Usuario> findAll() {
		return repo.findAll();
	}
	
	public Sis_Usuario find(Integer id) {
		Optional<Sis_Usuario> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	@Transactional
	public Sis_Usuario insert(Sis_Usuario obj) {
		obj.setIdusuario(null);
		obj.setSenhasabe("CadastroMobile");
		obj.setDesativado(false);
		obj.setLiberamanifesto(false);
		obj.setAdministrador(false);
		obj.setLiberaautorizacao(false);
		obj.setMobileativo(false);
		obj.setPassword(pe.encode(obj.getPassword()));
		
		return repo.save(obj);
	}
	
	private void updateData(Sis_Usuario oldObj, Sis_Usuario obj) {
		oldObj.setNome(obj.getNome());
		oldObj.setEmail(obj.getEmail());
		oldObj.setUsuario(obj.getUsuario());
	}
	
	private void updateSenha(Sis_Usuario oldObj, Sis_Usuario obj) {
		oldObj.setPassword(pe.encode(obj.getPassword()));
	}
	
	private void updateAtivo(Sis_Usuario oldObj, Sis_Usuario obj) {
		oldObj.setMobileativo(obj.getMobileativo());
	}
	
	@Transactional
	public Sis_Usuario update(Sis_Usuario obj) {
		Sis_Usuario oldObj = find(obj.getIdusuario());
		updateData(oldObj, obj);
		return repo.save(oldObj);
	}
	
	@Transactional
	public Sis_Usuario attSenha(Sis_Usuario obj) {
		Sis_Usuario oldObj = find(obj.getIdusuario());
		updateSenha(oldObj, obj);
		return repo.save(oldObj);
	}

	
	@Transactional
	public Sis_Usuario attAtivo(Sis_Usuario obj) {
		Sis_Usuario oldObj = find(obj.getIdusuario());
		updateAtivo(oldObj, obj);
		return repo.save(oldObj);
	}


}
