package co.edu.udistrtital.subasta.entidad;

import java.math.BigDecimal;
import java.util.Date;

public class Puja {
	
	private String litigante;
	
	private BigDecimal valorInicial;
	
	private Date horaInicial;
	
	private Date horaFinal;

	public Puja(String litigante, BigDecimal valorInicial, Date horaInicial, Date horaFinal) {
		super();
		this.litigante = litigante;
		this.valorInicial = valorInicial;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}

	public String getLitigante() {
		return litigante;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}
	
	
	

}
