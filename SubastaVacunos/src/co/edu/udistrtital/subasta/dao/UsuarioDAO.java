package co.edu.udistrtital.subasta.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.udistrtital.subasta.modelo.usuario.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO instancia;
	
	private List<Usuario> usuarios;
	
	private UsuarioDAO(){
		usuarios = new ArrayList<Usuario>();
	}
	
	public static UsuarioDAO getInstancia(){
		if(instancia == null)
			instancia = new UsuarioDAO();
		return instancia;
	}
	
	public void adicionarUsuario(String nombreUsuario){
		Usuario usuario = new Usuario();
		usuario.setNombre(nombreUsuario);
		usuario.setCodigo(getSiguienteCodigoUsuario());
		usuarios.add(usuario);
	}
	
	public Usuario getUsuario(int codigo){
		return usuarios.get(codigo-1);
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	public List<Usuario> getUsuariosMenosUno(Usuario propietario){
		Iterator<Usuario> it = usuarios.iterator();
		List<Usuario> usuariosMenosUno = new ArrayList<Usuario>();
		while (it.hasNext()) {
			Usuario usuario = (Usuario) it.next();
			if(propietario.getCodigo()!=usuario.getCodigo())
				usuariosMenosUno.add(usuario);
		}
		return usuariosMenosUno;
	}
	
	public int getSiguienteCodigoUsuario(){
		return getMaximoCodigoUsuario()+1;
	}
	
	public int getMaximoCodigoUsuario(){
		return usuarios.size()+1;
	}
}
