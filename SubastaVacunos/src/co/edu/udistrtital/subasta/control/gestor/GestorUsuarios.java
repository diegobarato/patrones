package co.edu.udistrtital.subasta.control.gestor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.control.peticiones.IEstrategiaPeticion;
import co.edu.udistrtital.subasta.dao.UsuarioDAO;
import co.edu.udistrtital.subasta.dao.VacunoDAO;
import co.edu.udistrtital.subasta.modelo.catalogo.Producto;
import co.edu.udistrtital.subasta.modelo.usuario.Usuario;

public class GestorUsuarios {
	
	private UsuarioDAO usuarioDAO;
	
	private VacunoDAO productoDAO;
	
	private IEstrategiaPeticion peticion;
	
	public GestorUsuarios(){
		usuarioDAO = UsuarioDAO.getInstancia();
		productoDAO = VacunoDAO.getInstancia();
	}
	
	public List<ComboItemDTO> getUsuarios(){
		Iterator<Usuario> usuarios=usuarioDAO.getUsuarios().iterator();
		List<ComboItemDTO> usuariosAMostrar = new ArrayList<ComboItemDTO>();
		while (usuarios.hasNext()) {
			Usuario usuario = (Usuario) usuarios.next();
			ComboItemDTO item = new ComboItemDTO();
			item.setKey(String.valueOf(usuario.getCodigo()));
			item.setValue(usuario.getNombre());
			usuariosAMostrar.add(item);
		}
		return usuariosAMostrar;
	}
	
	public List<ComboItemDTO> getUsuariosSinPropietario(int codProducto){
		Producto producto = productoDAO.getProducto(codProducto);
		Iterator<Usuario> usuarios=usuarioDAO.getUsuariosMenosUno(producto.getPropietario()).iterator();
		List<ComboItemDTO> usuariosAMostrar = new ArrayList<ComboItemDTO>();
		while (usuarios.hasNext()) {
			Usuario usuario = (Usuario) usuarios.next();
			ComboItemDTO item = new ComboItemDTO();
			item.setKey(String.valueOf(usuario.getCodigo()));
			item.setValue(usuario.getNombre());
			usuariosAMostrar.add(item);
		}
		return usuariosAMostrar;
	}
	
	public void crearUsuario(String nombreUsuario){
		usuarioDAO.adicionarUsuario(nombreUsuario);
	}
	
	public void procesarPeticion(){
		peticion.procesarPeticion();
	}

	public IEstrategiaPeticion getPeticion() {
		return peticion;
	}

	public void setPeticion(IEstrategiaPeticion peticion) {
		this.peticion = peticion;
	}
	
	
	
}
