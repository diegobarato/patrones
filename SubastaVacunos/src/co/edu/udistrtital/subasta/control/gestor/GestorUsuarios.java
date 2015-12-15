package co.edu.udistrtital.subasta.control.gestor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.dao.UsuarioDAO;
import co.edu.udistrtital.subasta.modelo.usuario.Usuario;

public class GestorUsuarios {
	
	private UsuarioDAO usuarioDAO;
	
	public GestorUsuarios(){
		usuarioDAO = UsuarioDAO.getInstancia();
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
	
	public void crearUsuario(String nombreUsuario){
		usuarioDAO.adicionarUsuario(nombreUsuario);
	}
}
