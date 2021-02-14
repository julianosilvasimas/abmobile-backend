package com.abmobile.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "idAreaGeracao")
@Table(name="vw_cad_amb_areageracao_nviva")
public class Vw_Cad_Amb_AreaGeracao_NViva {
	
	@Id
	@Column(name = "idareageracao")
	private Integer idAreaGeracao;
	@Column(name = "Descrição")
	private String Descricao;
	private Boolean Desativado;

}
