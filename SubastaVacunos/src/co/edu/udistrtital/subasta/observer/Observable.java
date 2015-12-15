package co.edu.udistrtital.subasta.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	
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
		for(Observador observador: observadores){
			observador.actualizar(this);
		}
	}

}
