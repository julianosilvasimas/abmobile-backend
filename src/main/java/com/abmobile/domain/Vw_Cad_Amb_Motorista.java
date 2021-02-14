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
@EqualsAndHashCode(of = "idMotorista")
public class Vw_Cad_Amb_Motorista {
	
	@Id
	@Column(name = "idmotorista")
	private Integer idMotorista;
	private String Nome;
	private Boolean Desativado;
	@Column(name = "idtransportador")
	private Integer idTransportador;

}
