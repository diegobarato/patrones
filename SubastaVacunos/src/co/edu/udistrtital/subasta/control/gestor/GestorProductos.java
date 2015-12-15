package co.edu.udistrtital.subasta.control.gestor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.control.peticiones.IEstrategiaPeticion;
import co.edu.udistrtital.subasta.dao.UsuarioDAO;
import co.edu.udistrtital.subasta.dao.VacunoDAO;
import co.edu.udistrtital.subasta.modelo.catalogo.Categoria;
import co.edu.udistrtital.subasta.modelo.catalogo.Producto;
import co.edu.udistrtital.subasta.modelo.catalogo.Vacuno;
import co.edu.udistrtital.subasta.modelo.usuario.Usuario;

public class GestorProductos {
	
	private VacunoDAO vacunoDAO;
	
	private UsuarioDAO usuarioDAO;
	
	private IEstrategiaPeticion peticion;
	
	public GestorProductos(String tipoProducto){
		vacunoDAO = VacunoDAO.getInstancia();
		usuarioDAO = UsuarioDAO.getInstancia();
	}

	public void crearProducto(String nombreProducto, double precio, String categoria, String propietario){
		Producto producto = new Vacuno(); //TODO: Fabrica de productos
		producto.setNombre(nombreProducto);
		producto.setPrecio(precio);
		producto.setPropietario(usuarioDAO.getUsuario(Integer.parseInt(propietario))); 
		producto.setIdProducto(vacunoDAO.getSiguienteCodigoProducto()); 
		vacunoDAO.adicionarProducto(producto);
		//TODO: Categorizar producto
		
	}
	
	public List<ComboItemDTO> getCategorias(){
		Iterator<Categoria> categorias=vacunoDAO.cargarCategorias().iterator();
		List<ComboItemDTO> categoriasAMostrar = new ArrayList<ComboItemDTO>();
		while (categorias.hasNext()) {
			Categoria categoria = (Categoria) categorias.next();
			ComboItemDTO item = new ComboItemDTO();
			item.setKey(categoria.getNombre());
			item.setValue(categoria.getNombre());
			categoriasAMostrar.add(item);
		}
		return categoriasAMostrar;
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
