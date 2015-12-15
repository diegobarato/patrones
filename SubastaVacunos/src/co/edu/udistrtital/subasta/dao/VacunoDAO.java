package co.edu.udistrtital.subasta.dao;

import java.util.ArrayList;
import java.util.Iterator;
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
		productos.add(producto);
		
		for (Iterator iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto1 = (Producto) iterator.next();
			System.out.println("Producto: "+producto1.getNombre());
		}
	}
	
	public void adicionarCategoria(String nombreCategoria){
		Categoria categoria = new Categoria();
		categoria.setNombre(nombreCategoria);
		categorias.add(categoria);
	}
	
	public Producto getProducto(int codigo){
		return productos.get(codigo-1);
	}
	
	public int getSiguienteCodigoProducto(){
		return getMaximoCodigoProducto()+1;
	}
	
	public int getMaximoCodigoProducto(){
		return productos.size()+1;
	}
	
}
