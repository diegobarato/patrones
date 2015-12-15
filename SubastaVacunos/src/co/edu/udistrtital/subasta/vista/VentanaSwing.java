package co.edu.udistrtital.subasta.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.udistrtital.subasta.control.ControlCentral;
import co.edu.udistrtital.subasta.control.gestor.BuscarEntidad;
import co.edu.udistrtital.subasta.control.gestor.GestorProductos;
import co.edu.udistrtital.subasta.control.gestor.GestorSubastas;
import co.edu.udistrtital.subasta.control.gestor.GestorUsuarios;
import co.edu.udistrtital.subasta.control.peticiones.PeticionCrearOferta;
import co.edu.udistrtital.subasta.control.peticiones.PeticionCrearProducto;
import co.edu.udistrtital.subasta.control.peticiones.PeticionCrearUsuario;

public class VentanaSwing extends JFrame {

	private JPanel contentPane;
	private ControlCentral control;
	private GestorProductos gestorProductos;
	private GestorSubastas gestorSubastas;
	private GestorUsuarios gestorUsuarios;

	/**
	 * Create the frame.
	 */
	public VentanaSwing(final ControlCentral control) {
//		this.control = control;
		setTitle("Puja de semovientes - San Marcos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(105, 201, 211, 49);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		contentPane.add(btnSalir);
		
		JLabel lblPujaDeSemovientes = new JLabel("PUJA DE SEMOVIENTES");
		lblPujaDeSemovientes.setBounds(44, 11, 145, 14);
		contentPane.add(lblPujaDeSemovientes);
		
		JButton btnNewButton = new JButton("Crear semoviente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorProductos.setPeticion(new PeticionCrearProducto());
				gestorProductos.procesarPeticion();
			}
		});
		btnNewButton.setBounds(10, 154, 135, 23);
		contentPane.add(btnNewButton);
		
		JButton btnImprimirCatlogo = new JButton("Imprimir cat\u00E1logo");
		btnImprimirCatlogo .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarEntidad buscarEntidad = new BuscarEntidad();
				buscarEntidad.imprimirCatalogo();
			}
		});
		btnImprimirCatlogo.setBounds(155, 154, 135, 23);
		contentPane.add(btnImprimirCatlogo);
		
		JButton btnActualizarSemoviente = new JButton("Crear usuario");
		btnActualizarSemoviente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorUsuarios.setPeticion(new PeticionCrearUsuario());
				gestorUsuarios.procesarPeticion();
			}
		});
		btnActualizarSemoviente.setBounds(300, 154, 142, 23);
		contentPane.add(btnActualizarSemoviente);
		
		JButton btnOfertar = new JButton("Ofertar");
		btnOfertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorSubastas.setPeticion(new PeticionCrearOferta());
				gestorSubastas.procesarPeticion();
			}
		});
		btnOfertar.setBounds(10, 100, 135, 23);
		contentPane.add(btnOfertar);
	}
	
	public void setGestorProductos(GestorProductos gestor){
		gestorProductos = gestor;
	}
	
	public void setGestorSubastas(GestorSubastas gestorSubastas) {
		this.gestorSubastas = gestorSubastas;
	}
	
	public void setGestorUsuarios(GestorUsuarios gestorUsuarios) {
		this.gestorUsuarios = gestorUsuarios;
	}
}
