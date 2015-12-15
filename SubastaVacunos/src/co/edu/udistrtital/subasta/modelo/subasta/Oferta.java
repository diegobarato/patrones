package co.edu.udistrtital.subasta.modelo.subasta;

import java.util.Date;

import co.edu.udistrtital.subasta.modelo.usuario.Usuario;

public class Oferta {
	
	private Usuario oferente; 
	
	private Double precio;
	
	private Date tiempoOferta;
	
	public Oferta() {
		// TODO Auto-generated constructor stub
	}

	public Oferta(Usuario oferente, Double precio, Date tiempoOferta) {
		super();
		this.oferente = oferente;
		this.precio = precio;
		this.tiempoOferta = tiempoOferta;
	}

	public Usuario getOferente() {
		return oferente;
	}

	public Double getPrecio() {
		return precio;
	}

	public Date getTiempoOferta() {
		return tiempoOferta;
	}

	

}
