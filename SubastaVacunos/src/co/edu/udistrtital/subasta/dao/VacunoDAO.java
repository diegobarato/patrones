package co.edu.udistrtital.subasta.dao;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrtital.subasta.modelo.catalogo.Categoria;
import co.edu.udistrtital.subasta.modelo.catalogo.Producto;

public class VacunoDAO {

	private static VacunoDAO instancia;
	
	List<Producto> productos;
	
	List<Categoria> categorias;
	
	private VacunoDAO(){
		productos = new ArrayList<Producto>();
		categorias = new ArrayList<Categoria>();
	}
	
	public static VacunoDAO getInstancia(){
		if(instancia == null)
			instancia = new VacunoDAO();
		return instancia;
	}
	
	public List<Categoria> cargarCategorias(){
		return categorias;
	}
	
	public void adicionarProducto(Producto producto){
		
	}
	
}
