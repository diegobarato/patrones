package co.edu.udistrtital.subasta.modelo.catalogo;

import co.edu.udistrtital.subasta.modelo.catalogo.estadoproducto.IEstadoProducto;
import co.edu.udistrtital.subasta.modelo.usuario.Usuario;

/**
 * @author useche
 *
 */
public abstract class Producto extends Catalogo {

	private int idProducto;
	
	private String nombre;
	
	private double precio;
	
	private Usuario propietario;
	
	private IEstadoProducto estado;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public IEstadoProducto getEstado() {
		return estado;
	}

	public void setEstado(IEstadoProducto estado) {
		this.estado = estado;
	}
	
}
