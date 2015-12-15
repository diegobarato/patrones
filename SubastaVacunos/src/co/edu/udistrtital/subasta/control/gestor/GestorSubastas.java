package co.edu.udistrtital.subasta.control.gestor;

import java.util.Date;

import co.edu.udistrtital.subasta.control.peticiones.IEstrategiaPeticion;
import co.edu.udistrtital.subasta.dao.SubastaDAO;
import co.edu.udistrtital.subasta.dao.VacunoDAO;
import co.edu.udistrtital.subasta.modelo.catalogo.Producto;
import co.edu.udistrtital.subasta.modelo.subasta.Oferta;
import co.edu.udistrtital.subasta.modelo.subasta.Puja;
import co.edu.udistrtital.subasta.modelo.subasta.Subasta;

public class GestorSubastas {
	
	private IEstrategiaPeticion peticion;
	
	private SubastaDAO subastaDAO;
	
	private VacunoDAO productoDAO;
	
	private Producto producto;
	
	public GestorSubastas(int idProducto) {
		subastaDAO = SubastaDAO.getInstancia();
		productoDAO = VacunoDAO.getInstancia();
		producto = productoDAO.getProducto(idProducto);
	}
	
	public void crearSubasta(Double precioInicial, Date fechaInicio, Date fechaTerminacion){
		Subasta subasta = new Puja(precioInicial, fechaInicio, fechaTerminacion, this.producto);
		subastaDAO.adicionarSubasta(subasta);
	}
	
	public String validarOferta(Puja puja, Oferta oferta){
		Date horaActual = new Date();
		String retorno = "";
		if(horaActual.compareTo(puja.getFechaTerminacion())<0){
			retorno = "La subasta no ha iniciado";
		}else if(oferta.getPrecio().compareTo(puja.getPrecioInicial())<0){
			retorno = "El precio de la oferta no es mayor al precio inicial";
		}else if(puja.getUltimaOferta()!=null && oferta.getPrecio().compareTo(puja.getUltimaOferta().getPrecio())<0){
			retorno = "El precio de la oferta no es mayor al de la ultima oferta: "+
					puja.getUltimaOferta().getPrecio();
		}
		return retorno;
	}
	
	public String ofertar(Oferta oferta, int codigoSubasta){
		Puja puja = (Puja)subastaDAO.getSubasta(codigoSubasta);
		String retorno = validarOferta(puja, oferta);
		if(retorno.equals("")){
			puja.adicionarOferta(oferta);
			retorno = "Oferta agregada exitosamente";
		}
		return retorno;
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
