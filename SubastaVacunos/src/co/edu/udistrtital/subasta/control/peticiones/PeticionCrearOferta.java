package co.edu.udistrtital.subasta.control.peticiones;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.vista.CrearOferta2;

public class PeticionCrearOferta implements IEstrategiaPeticion {
	
	CrearOferta2 vista = new CrearOferta2();

	@Override
	public void procesarPeticion() {
		EventQueue.invokeLater(new InvocarVentana());	

	}

	class InvocarVentana implements Runnable {

		@Override
		public void run() {
			vista = new CrearOferta2();
			vista.setVisible(true);
		}
	}

}
