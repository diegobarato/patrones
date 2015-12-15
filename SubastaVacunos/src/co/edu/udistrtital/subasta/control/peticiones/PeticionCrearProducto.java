package co.edu.udistrtital.subasta.control.peticiones;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.vista.CrearSemoviente;

public class PeticionCrearProducto implements IEstrategiaPeticion {
	
	CrearSemoviente vista;

	@Override
	public void procesarPeticion() {
		EventQueue.invokeLater(new InvocarVentana());	

	}

	class InvocarVentana implements Runnable {

		@Override
		public void run() {
			vista = new CrearSemoviente();
			vista.setVisible(true);
		}
	}
	
}
