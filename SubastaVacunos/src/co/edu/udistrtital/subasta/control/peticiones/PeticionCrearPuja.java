package co.edu.udistrtital.subasta.control.peticiones;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.vista.CrearPuja;

public class PeticionCrearPuja implements IEstrategiaPeticion {
	
	private CrearPuja vista;
	private int idProducto;
	
	public PeticionCrearPuja(int idProducto) {
		this.idProducto = idProducto;
	}

	@Override
	public void procesarPeticion() {
		EventQueue.invokeLater(new InvocarVentana());			
	}

	class InvocarVentana implements Runnable {

		@Override
		public void run() {
			vista = new CrearPuja(idProducto);
			vista.setVisible(true);
		}
	}

}
