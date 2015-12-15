package co.edu.udistrtital.subasta.control.peticiones;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.vista.CrearSemoviente;
import co.edu.udistrtital.subasta.vista.CrearUsuario;

public class PeticionCrearUsuario implements IEstrategiaPeticion {
	
	CrearUsuario vista = new CrearUsuario();

	@Override
	public void procesarPeticion() {
		EventQueue.invokeLater(new InvocarVentana());	

	}

	class InvocarVentana implements Runnable {

		@Override
		public void run() {
			vista = new CrearUsuario();
			vista.setVisible(true);
		}
	}
	
}
