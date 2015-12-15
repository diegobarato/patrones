package co.edu.udistrtital.subasta.modelo.catalogo;

public class Vacuno extends Producto {

	@Override
	public void imprimirCatalogo() {
		System.out.print("    ID: "+idProducto);
		System.out.print("    Nombre: "+nombre);
		System.out.println("    Precio: "+precio);

	}

}
