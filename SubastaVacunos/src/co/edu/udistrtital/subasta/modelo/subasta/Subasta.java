package co.edu.udistrtital.subasta.modelo.subasta;

import co.edu.udistrtital.subasta.observer.Observable;

public class Subasta extends Observable {
	
	public Subasta(Puja puja) {
		this.puja = puja;
	}
	
	private Puja puja;
	
	private Oferta ultimaOferta;
	
		
	public void guardarOferta(Oferta oferta){
		this.ultimaOferta = oferta;
		this.notificar();
	}

	public Oferta getUltimaOferta() {
		return ultimaOferta;
	}
	
	public Puja getPuja() {
		return puja;
	}

}
