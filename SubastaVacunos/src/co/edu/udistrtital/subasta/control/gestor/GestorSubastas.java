package co.edu.udistrtital.subasta.control.gestor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.control.peticiones.IEstrategiaPeticion;
import co.edu.udistrtital.subasta.dao.SubastaDAO;
import co.edu.udistrtital.subasta.dao.UsuarioDAO;
import co.edu.udistrtital.subasta.dao.VacunoDAO;
import co.edu.udistrtital.subasta.modelo.catalogo.Producto;
import co.edu.udistrtital.subasta.modelo.subasta.Oferta;
import co.edu.udistrtital.subasta.modelo.subasta.Puja;
import co.edu.udistrtital.subasta.modelo.subasta.Subasta;
import co.edu.udistrtital.subasta.modelo.usuario.Usuario;

public class GestorSubastas {
	
	private IEstrategiaPeticion peticion;
	
	private SubastaDAO subastaDAO;
	
	private VacunoDAO productoDAO;
	
	private UsuarioDAO usuarioDAO;
	
	public GestorSubastas() {
		subastaDAO = SubastaDAO.getInstancia();
		productoDAO = VacunoDAO.getInstancia();
		usuarioDAO = UsuarioDAO.getInstancia();
	}

	public void crearSubasta(int idProducto, Double precioInicial, String horaInicio, String horaTerminacion){
		Producto producto = productoDAO.getProducto(idProducto);
		String[] inicio = horaInicio.split(":");
		String[] fin = horaTerminacion.split(":");
		Calendar calInicio = Calendar.getInstance();
		calInicio.set(Calendar.HOUR_OF_DAY, Integer.parseInt(inicio[0]));
		if(inicio.length!=2){
			calInicio.set(Calendar.MINUTE, 0);
		}else{
			calInicio.set(Calendar.MINUTE, Integer.parseInt(inicio[1]));
		}
		
		Calendar calFin = Calendar.getInstance();
		calFin.set(Calendar.HOUR_OF_DAY, Integer.parseInt(fin[0]));
		if(fin.length!=2){
			calFin.set(Calendar.MINUTE, 0);
		}else{
			calFin.set(Calendar.MINUTE, Integer.parseInt(fin[1]));
		}
		Subasta subasta = new Puja(subastaDAO.getIDSubasta(),precioInicial, calInicio.getTime(), calFin.getTime(), producto);
		subastaDAO.adicionarSubasta(subasta);
	}
	
	public String validarOferta(Puja puja, Oferta oferta){
		Date horaActual = new Date();
		String retorno = "";
		if(horaActual.compareTo(puja.getFechaInicio())<0){
			retorno = "La subasta no ha iniciado";
		}else if(oferta.getPrecio().compareTo(puja.getPrecioInicial())<0){
			retorno = "El precio de la oferta no es mayor al precio inicial";
		}else if(puja.getUltimaOferta()!=null && oferta.getPrecio().compareTo(puja.getUltimaOferta().getPrecio())<=0){
			retorno = "El precio de la oferta no es mayor al de la ultima oferta: "+
					puja.getUltimaOferta().getPrecio();
		}
		return retorno;
	}
	
	public String ofertar(int codigoUsuario, Double precio, int codigoSubasta){
		Puja puja = (Puja)subastaDAO.getSubasta(codigoSubasta);
		Usuario litigante = usuarioDAO.getUsuario(codigoUsuario);
		Oferta oferta = new Oferta(litigante, precio, new Date());
		String retorno = validarOferta(puja, oferta);
		if(retorno.equals("")){
			puja.agregarObservador(litigante);
			puja.adicionarOferta(oferta);
			retorno = "Oferta agregada exitosamente";
		}
		return retorno;
	}
	
	public List<ComboItemDTO> getProductosOfertados(){
		Iterator<Subasta> subastas=subastaDAO.getSubastas().iterator();
		List<ComboItemDTO> productosAMostrar = new ArrayList<ComboItemDTO>();
		while (subastas.hasNext()) {
			Puja puja = (Puja) subastas.next();
			ComboItemDTO item = new ComboItemDTO();
			item.setKey(String.valueOf(puja.getIdPuja()));
			item.setValue(puja.getProducto().getNombre());
			productosAMostrar.add(item);
		}
		return productosAMostrar;
	}
	
	public Subasta consultarSubasta(String codigo){
		return subastaDAO.getSubasta(Integer.parseInt(codigo));
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
