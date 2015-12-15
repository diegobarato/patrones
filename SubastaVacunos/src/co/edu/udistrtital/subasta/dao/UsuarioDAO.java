package co.edu.udistrtital.subasta.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.udistrtital.subasta.modelo.usuario.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO instancia;
	
	private List<Usuario> usuarios;
	
	private UsuarioDAO(){
		
	}
	
	public static UsuarioDAO getInstancia(){
		if(instancia == null)
			instancia = new UsuarioDAO();
		return instancia;
	}
	
	public void adicionarUsuario(Usuario usuario){
		usuarios.add(usuario);
	}
	
	public Usuario getUsuario(int codigo){
		return usuarios.get(codigo-1);
	}
	
	public List<String> getNombresUsuarios(){
		Iterator<Usuario> it = usuarios.iterator();
		List<String> listaNombres = new ArrayList<String>();
		while (it.hasNext()) {
			Usuario usuario = (Usuario) it.next();
			listaNombres.add(usuario.getNombre());
		}
		return listaNombres;
	}
	
	public List<String> getNombresUsuariosMenosUno(Usuario propietario){
		Iterator<Usuario> it = usuarios.iterator();
		List<String> listaNombres = new ArrayList<String>();
		while (it.hasNext()) {
			Usuario usuario = (Usuario) it.next();
			if(propietario.getCodigo()!=usuario.getCodigo())
				listaNombres.add(usuario.getNombre());
		}
		return listaNombres;
	}
	
	public int getSiguienteCodigoUsuario(){
		return getMaximoCodigoUsuario()+1;
	}
	
	public int getMaximoCodigoUsuario(){
		return usuarios.size()+1;
	}
}
