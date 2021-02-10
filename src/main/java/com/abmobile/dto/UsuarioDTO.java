package com.abmobile.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idusuario;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private Boolean ativo;
	
	private Set<Integer> perfis;
	
	private List<Integer> centrosDeCustos = new  ArrayList<>();
	
	private List<Integer> supervisoes = new  ArrayList<>();
	
	private Integer idgerencia;
	
}
