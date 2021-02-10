package com.abmobile.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.abmobile.domain.enums.Perfil;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Sis_Usuario")
public class Sis_Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer idusuario;
	@Column(name = "Usuario", nullable = false)
	@Getter @Setter private String usuario;
	@Getter @Setter private String nome;
	@Getter @Setter private String email;
	@Column(name = "Senha", nullable = true)
	@Getter @Setter private String senhasabe;
	@Getter @Setter private Boolean desativado;
	@Getter @Setter private Boolean liberamanifesto;
	@Getter @Setter private Boolean administrador;
	@Getter @Setter private Boolean idgrupo;
	@Getter @Setter private Boolean segundo;
	@Getter @Setter private Boolean liberaautorizacao;
	@Getter @Setter private Boolean idgrupousuario;
	
	@Column(name = "Senhamobile", nullable = true)
	@Getter @Setter private String password;
	@Column(name = "Mobileativo", nullable = true)
	@Getter @Setter private Boolean mobileativo;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "ABMobile_Perfis")
	private Set<Integer> perfis = new HashSet<>();
	

	// Construtor Vazio
	public Sis_Usuario() {
		addPerfil(Perfil.USER);
	}

	
	public Sis_Usuario(Integer idusuario, String usuario, String nome, String email, String senhasabe,
			Boolean desativado, Boolean liberamanifesto, Boolean administrador, Boolean idgrupo, Boolean segundo,
			Boolean liberaautorizacao, Boolean idgrupousuario, String password, Boolean mobileativo) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.nome = nome;
		this.email = email;
		this.senhasabe = senhasabe;
		this.desativado = desativado;
		this.liberamanifesto = liberamanifesto;
		this.administrador = administrador;
		this.idgrupo = idgrupo;
		this.segundo = segundo;
		this.liberaautorizacao = liberaautorizacao;
		this.idgrupousuario = idgrupousuario;
		this.password = password;
		this.mobileativo = mobileativo;
		addPerfil(Perfil.USER);
	}



	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	public int compareTO(Sis_Usuario obj){
		return nome.compareTo(obj.getNome());
	} 
	

	// HashCode e Equals para Verificação do conteúdo
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sis_Usuario other = (Sis_Usuario) obj;
		if (idusuario == null) {
			if (other.idusuario != null)
				return false;
		} else if (!idusuario.equals(other.idusuario))
			return false;
		return true;
	}

}
