package co.edu.udistrtital.subasta.control;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.control.gestor.GestorProductos;
import co.edu.udistrtital.subasta.vista.VentanaSwing;

public class ControlCentral {

	private VentanaSwing vista;
	private GestorProductos gestorProductos;
	
	public ControlCentral(){
		gestorProductos = new GestorProductos("VACUNO");
		EventQueue.invokeLater(new InvocarVentana(this));		
	}
	
	class InvocarVentana implements Runnable {
		ControlCentral controlCentral;
		
		public InvocarVentana(ControlCentral control) {
			controlCentral = control;
		}
		
		@Override
		public void run() {
			vista = new VentanaSwing(controlCentral);
			vista.setGestorProductos(gestorProductos);
			vista.setVisible(true);
		}
		
	}

}
