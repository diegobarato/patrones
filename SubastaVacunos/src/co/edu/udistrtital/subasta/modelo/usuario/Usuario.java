package co.edu.udistrtital.subasta.modelo.usuario;

import co.edu.udistrtital.subasta.modelo.subasta.Subasta;
import co.edu.udistrtital.subasta.observer.Observador;

public class Usuario extends Persona implements Observador {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void actualizar(Subasta subasta) {
		System.out.println(subasta.toString());
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.codigo==((Usuario)obj).codigo;
	}
	
	
}
