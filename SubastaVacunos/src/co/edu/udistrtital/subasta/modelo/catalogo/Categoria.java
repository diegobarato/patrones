/**
 * 
 */
package co.edu.udistrtital.subasta.modelo.catalogo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author useche
 *
 */
public class Categoria extends Catalogo {

	private List<Catalogo> catalogos;
	
	private String nombre;
	
	public Categoria() {
		catalogos = new ArrayList<Catalogo>();
	}
	
	public void adicionar(Catalogo catalogo) {
		catalogos.add(catalogo);
	}
	
	public void remover(Catalogo catalogo){
		catalogos.remove(catalogo);
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udistrtital.subasta.modelo.catalogo.Catalogo#imprimirCatalogo()
	 */
	@Override
	public void imprimirCatalogo() {
		Iterator<Catalogo> catalogoIt = catalogos.iterator();
		if(catalogoIt.hasNext()){
			System.out.println("Categor�a: "+nombre);
			while (catalogoIt.hasNext()) {
				Catalogo catalogo = (Catalogo) catalogoIt.next();
				catalogo.imprimirCatalogo();
			}
		}
	}

	public List<Catalogo> getCatalogos() {
		return catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
