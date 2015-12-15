package co.edu.udistrtital.subasta.modelo.subasta;

import java.math.BigDecimal;
import java.util.Date;

public class Oferta {
	
	private String oferente; //TODO: Enlazar con clase
	
	private BigDecimal valor;
	
	private Date fecha;
	
	public Oferta() {
		// TODO Auto-generated constructor stub
	}

	public Oferta(String oferente, BigDecimal valor, Date fecha) {
		super();
		this.oferente = oferente;
		this.valor = valor;
		this.fecha = fecha;
	}

	public String getOferente() {
		return oferente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Date getFecha() {
		return fecha;
	}
	
	

}
