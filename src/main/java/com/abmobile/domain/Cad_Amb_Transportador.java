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
@EqualsAndHashCode(of = "idTransportardor")
public class Cad_Amb_Transportador {
	
	@Id
	@Column(name = "idtransportador")
	private Integer idTransportardor;
	//private Integer Cnpj;
	private String Razao;
	private Boolean Desativado;
	

}
