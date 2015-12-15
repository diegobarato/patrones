package co.edu.udistrtital.subasta.servicio;

import java.math.BigDecimal;
import java.util.Date;

import co.edu.udistrtital.subasta.entidad.Oferta;
import co.edu.udistrtital.subasta.entidad.Puja;
import co.edu.udistrtital.subasta.entidad.Subasta;

public class SubastaServicio {
	
	private Subasta subasta;
	
	public void crearSubasta(String litigante, BigDecimal valorInicial, Date horaInicial, Date horaFinal){
		Puja puja = new Puja(litigante, valorInicial, horaInicial, horaFinal);
		this.subasta =new Subasta(puja);
	}
	
	public String validarOferta(Oferta oferta){
		return "";
	}
	
	public boolean recibirOferta(Oferta oferta){
		if(validarOferta(oferta).equals("")){
			subasta.guardarOferta(oferta);
			return true;
		}else{
			return false;
		}
	}
	

}
