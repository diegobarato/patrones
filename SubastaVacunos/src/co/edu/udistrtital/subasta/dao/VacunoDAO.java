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
	}
	
	public Producto getProducto(int codigo){
		return productos.get(codigo-1);
	}
	
	public void categorizarProducto(Producto producto, String nombreCategoria){
		Categoria categoria = buscarCategoria(nombreCategoria);
		categoria.getCatalogos().add(producto);
	}
	
	public void adicionarCategoria(String nombreCategoria){
		Categoria categoria = new Categoria();
		categoria.setNombre(nombreCategoria);
		categorias.add(categoria);
	}
	
	public int getSiguienteCodigoProducto(){
		return getMaximoCodigoProducto()+1;
	}
	
	public int getMaximoCodigoProducto(){
		return productos.size();
	}

	private Categoria buscarCategoria(String nombreCategoria){
		Iterator<Categoria> categoriasIt = categorias.iterator();
		while (categoriasIt.hasNext()) {
			Categoria categoria = (Categoria) categoriasIt.next();
			if(categoria.getNombre().equals(nombreCategoria))
				return categoria;
		}
		return null;
	}
	
}
