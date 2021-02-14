package com.abmobile.domain;

import java.io.Serializable;

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
@EqualsAndHashCode(of = "idVeiculo")
public class Vw_Cad_Amb_Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idveiculo")
	private Integer idVeiculo;
	private String Placa;
	private Boolean Desativado;
	@Column(name = "idtransportador")
	private Integer idTransportador;

}
