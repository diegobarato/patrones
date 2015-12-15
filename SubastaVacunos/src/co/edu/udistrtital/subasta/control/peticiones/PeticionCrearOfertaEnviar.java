package co.edu.udistrtital.subasta.control.peticiones;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.vista.CrearOferta;
import co.edu.udistrtital.subasta.vista.CrearOfertaEnviar;

public class PeticionCrearOfertaEnviar implements IEstrategiaPeticion {
	
	private CrearOfertaEnviar vista;
	private int idProducto;

	public PeticionCrearOfertaEnviar(int idProducto) {
		this.idProducto = idProducto;
	}
	
	@Override
	public void procesarPeticion() {
		EventQueue.invokeLater(new InvocarVentana());	

	}

	class InvocarVentana implements Runnable {

		@Override
		public void run() {
			vista = new CrearOfertaEnviar(idProducto);
			vista.setVisible(true);
		}
	}

}
