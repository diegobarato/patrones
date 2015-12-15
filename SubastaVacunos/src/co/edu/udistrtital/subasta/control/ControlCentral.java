package co.edu.udistrtital.subasta.control;

import java.awt.EventQueue;

import co.edu.udistrtital.subasta.control.gestor.GestorProductos;
import co.edu.udistrtital.subasta.dao.UsuarioDAO;
import co.edu.udistrtital.subasta.dao.VacunoDAO;
import co.edu.udistrtital.subasta.modelo.catalogo.Categoria;
import co.edu.udistrtital.subasta.modelo.usuario.Usuario;
import co.edu.udistrtital.subasta.vista.VentanaSwing;

public class ControlCentral {

	private VentanaSwing vista;
	private GestorProductos gestorProductos;
//	private GestorUsuario gestorUsuarios;
	private UsuarioDAO usuarioDAO;
	private VacunoDAO vacunoDAO;
	
	
	
	
	public ControlCentral(){
		gestorProductos = new GestorProductos("VACUNO");
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
			vista.setVisible(true);
		}
		
	}

}
