package co.edu.udistrtital.subasta.control.gestor;

import java.util.Iterator;

import co.edu.udistrtital.subasta.dao.VacunoDAO;
import co.edu.udistrtital.subasta.modelo.catalogo.Categoria;

public class BuscarEntidad {

	private VacunoDAO vacunoDAO;

	public BuscarEntidad() {
		vacunoDAO = VacunoDAO.getInstancia();
	}

	public void imprimirCatalogo() {
		Iterator<Categoria> categoriasIt = vacunoDAO.cargarCategorias().iterator();
		while (categoriasIt.hasNext()) {
			Categoria categoria = (Categoria) categoriasIt.next();
			categoria.imprimirCatalogo();
		}
	}
}
