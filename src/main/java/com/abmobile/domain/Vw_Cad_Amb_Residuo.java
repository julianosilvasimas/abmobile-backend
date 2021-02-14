package com.abmobile.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "idResiduo")
public class Vw_Cad_Amb_Residuo {
	
	@Id
	@Column(name = "idresiduo")
	private Integer idResiduo;
	@Column(name = "Descrição")
	private String Descricao;
	private Boolean Desativado;
	//private Double Quantidade;

}
