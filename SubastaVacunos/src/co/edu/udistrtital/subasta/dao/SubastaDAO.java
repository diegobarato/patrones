package co.edu.udistrtital.subasta.dao;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrtital.subasta.modelo.subasta.Subasta;

public class SubastaDAO {
	
	private static SubastaDAO instancia;
	
	List<Subasta> subastas;
	
	public SubastaDAO() {
		subastas = new ArrayList<>();
	}
	
	public static SubastaDAO getInstancia(){
		if(instancia == null)
			instancia = new SubastaDAO();
		return instancia;
	}
	
	public void adicionarSubasta(Subasta subasta){
		subastas.add(subasta);
	}
	
	public Subasta getSubasta(int codigo){
		return subastas.get(codigo-1);
	}
	
	public Subasta cancelarSubasta(int codigo){
		Subasta subasta = getSubasta(codigo);
		return subasta;//TODO: Cambiar a cancelada
	}
	
	public int getIDSubasta(){
		return subastas.size()+1;
	}

}
