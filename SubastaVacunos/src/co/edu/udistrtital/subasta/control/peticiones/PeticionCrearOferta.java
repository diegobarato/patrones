package co.edu.udistrtital.subasta.control.peticiones;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.vista.CrearOferta;

public class PeticionCrearOferta implements IEstrategiaPeticion {
	
	private CrearOferta vista;

	@Override
	public void procesarPeticion() {
		EventQueue.invokeLater(new InvocarVentana());	

	}

	class InvocarVentana implements Runnable {

		@Override
		public void run() {
			vista = new CrearOferta();
			vista.setVisible(true);
		}
	}

}
