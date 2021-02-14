package com.abmobile.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@EqualsAndHashCode(of = "idResLan")
@Table(name="Cad_Amb_Residuolancamento")
public class Cad_Amb_ResiduoLancamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "idreslan")
	private Integer	idResLan;
	@Column(name = "idresiduo")
	private Integer	idResiduo;
	//private Integer	idOrigem;
	@Column(name = "idareageracao")
	private Integer	idAreaGeracao;
	//private String	ResponsavelColeta;
	//private String	AreaGeracao;
	private Double	Qtde;
	@Column(name = "Dtrecebi")
	private Date DtRecebi;
	@Column(name = "Hrrecebi")
	private Date HrRecebi;
	private Boolean	Desativado;
	//private Integer	idGeracao;
	@Column(name = "idgerador")
	private Integer	idGerador;
	private Boolean	Gravado;
	//private Integer	idEmpresa;
	private Double	Tonelada;
	@Column(name = "idtransportador")
	private Integer	idTransportador;
	@Column(name = "idveiculo")
	private Integer	idVeiculo;
	@Column(name = "idmotorista")
	private Integer	idMotorista;
	private Integer	Numero;
	//datetime	DtDisposicao;
	//datetime	HrDisposicao;
	private String	Pedido;
	//private Double	ValorUnitario;
	//private Integer	idPagtoAreaGeracao;
	//private Integer	idPagtoGerador;
	//private Integer	idPagtoTransportador;
	//private Integer	idObra;
	//private Integer	idNotaServico;
	//private Integer	idNFiscalTotal;
	//private String	CNPJ;
	private String	Observacao;
	//private String	Cacamba;
	private Boolean	Recompra;
	//private Integer	CTRTemporario;
	//datetime	DtLancadoNuvem;
	@Column(name = "Lancadonuvem")
	private Boolean	LancadoNuvem;
	@Column(name = "Numerotemporario")
	private Integer	NumeroTemporario;
	private String	MTR;

}
