package co.edu.udistrtital.subasta.modelo.subasta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.udistrtital.subasta.modelo.catalogo.Producto;

public class Puja extends Subasta {
	
	private Integer idPuja;
	
	private Double precioInicial;
	
	private Date fechaInicio;
	
	private Date fechaTerminacion;
	
	private Producto producto;
	
	private List<Oferta> ofertas = new ArrayList<>();
	
	public Puja(Integer idPuja, Double precioInicial, Date fechaInicio, Date fechaTerminacion, Producto producto) {
		super();
		this.idPuja = idPuja;
		this.precioInicial = precioInicial;
		this.fechaInicio = fechaInicio;
		this.fechaTerminacion = fechaTerminacion;
		this.producto = producto;
	}

	public void adicionarOferta(Oferta oferta){
		ofertas.add(oferta);
		this.notificar();
	}

	public Oferta getUltimaOferta() {
		try {
			return ofertas.get(ofertas.size()-1);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public Integer getIdPuja() {
		return idPuja;
	}

	public Double getPrecioInicial() {
		return precioInicial;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaTerminacion() {
		return fechaTerminacion;
	}

	public Producto getProducto() {
		return producto;
	}

}
