package co.edu.udistrtital.subasta.dao;

public class UsuarioDAO {

	private static UsuarioDAO instancia;
	
	private UsuarioDAO(){
		
	}
	
	public static UsuarioDAO getInstancia(){
		if(instancia == null)
			instancia = new UsuarioDAO();
		return instancia;
	}
}
