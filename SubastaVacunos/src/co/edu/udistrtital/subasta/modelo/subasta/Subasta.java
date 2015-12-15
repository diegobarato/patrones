package co.edu.udistrtital.subasta.modelo.subasta;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrtital.subasta.observer.Observador;

public abstract class Subasta {
	
private List<Observador> observadores = new ArrayList<>();
	
	public synchronized void agregarObservador(Observador observador){
		if(!observadores.contains(observador)){
			observadores.add(observador);
		}
	}
	
	public synchronized void removerObservador(Observador observador){
		observadores.remove(observador);
	}
	
	public void notificar(){
		System.out.println("Notificando: "+this.toString());
		for(Observador observador: observadores){
			observador.actualizar(this);
		}
	}
		

	
		

	

}
