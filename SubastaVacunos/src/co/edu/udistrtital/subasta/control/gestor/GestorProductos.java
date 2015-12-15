package co.edu.udistrtital.subasta.control.gestor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.control.peticiones.IEstrategiaPeticion;
import co.edu.udistrtital.subasta.dao.VacunoDAO;
import co.edu.udistrtital.subasta.modelo.catalogo.Categoria;
import co.edu.udistrtital.subasta.modelo.catalogo.Producto;
import co.edu.udistrtital.subasta.modelo.catalogo.Vacuno;

public class GestorProductos {
	
	private VacunoDAO vacunoDAO;
	
	private IEstrategiaPeticion peticion;
	
	public GestorProductos(String tipoProducto){
		vacunoDAO = VacunoDAO.getInstancia();
	}

	public void crearProducto(String nombreProducto, double precio, String categoria, String propietario){
		Producto producto = new Vacuno(); //TODO: Fabrica de productos
		producto.setNombre(nombreProducto);
		producto.setPrecio(precio);
		producto.setPropietario(propietario); //TODO: Propietario a producto
		producto.setIdProducto(0); //TODO: identificador de producto
		//TODO: Categorizar producto
		
	}
	
	public List<ComboItemDTO> getCategorias(){
		Iterator<Categoria> categorias=vacunoDAO.cargarCategorias().iterator();
		List<ComboItemDTO> categoriasAMostrar = new ArrayList<ComboItemDTO>();
		while (categorias.hasNext()) {
			Categoria categoria = (Categoria) categorias.next();
			ComboItemDTO item = new ComboItemDTO();
			item.setId(categoria.getNombre());
			item.setNombre(categoria.getNombre());
			categoriasAMostrar.add(item);
		}
		return categoriasAMostrar;
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
