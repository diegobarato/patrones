package co.edu.udistrtital.subasta.control;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.control.gestor.GestorProductos;
import co.edu.udistrtital.subasta.control.gestor.GestorSubastas;
import co.edu.udistrtital.subasta.control.gestor.GestorUsuarios;
import co.edu.udistrtital.subasta.dao.UsuarioDAO;
import co.edu.udistrtital.subasta.dao.VacunoDAO;
import co.edu.udistrtital.subasta.vista.VentanaSwing;

public class ControlCentral {

	private VentanaSwing vista;
	private GestorProductos gestorProductos;
	private GestorUsuarios gestorUsuarios;
	private UsuarioDAO usuarioDAO;
	private VacunoDAO vacunoDAO;
	private GestorSubastas gestorSubastas;
	
	
	
	
	public ControlCentral(){
		gestorProductos = new GestorProductos("VACUNO");
		gestorSubastas = new GestorSubastas();
		gestorUsuarios = new GestorUsuarios();
		
		usuarioDAO = UsuarioDAO.getInstancia();
		vacunoDAO = VacunoDAO.getInstancia();
		adicionarUsuariosIniciales();
		adicionarCategoriasIniciales();
		
		EventQueue.invokeLater(new InvocarVentana(this));	
	}
	
	private void adicionarUsuariosIniciales() {
		usuarioDAO.adicionarUsuario("Jhon Herrera");
		usuarioDAO.adicionarUsuario("Diego Barato");
		usuarioDAO.adicionarUsuario("Diego García");
	}
	
	private void adicionarCategoriasIniciales() {
		vacunoDAO.adicionarCategoria("Categoria 1");
		vacunoDAO.adicionarCategoria("Categoria 2");
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
			vista.setGestorSubastas(gestorSubastas);
			vista.setGestorUsuarios(gestorUsuarios);
			vista.setVisible(true);
		}
		
	}

}
