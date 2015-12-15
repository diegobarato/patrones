package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.control.gestor.GestorProductos;
import co.edu.udistrtital.subasta.control.gestor.GestorSubastas;
import co.edu.udistrtital.subasta.control.gestor.GestorUsuarios;
import co.edu.udistrtital.subasta.modelo.subasta.Puja;
import co.edu.udistrtital.subasta.modelo.subasta.Subasta;

public class CrearOferta extends JDialog {

	private GestorSubastas gestorSubastas;
	private GestorProductos gestorProductos;
	private GestorUsuarios gestorUsuarios;
	
	private final JPanel contentPanel = new JPanel();
	private JComboBox productoCombo;
	private JTextField precioOferta;
	private JButton btnOfertar;
	private JComboBox usuarioCombo;
	
	public CrearOferta() {
		gestorSubastas = new GestorSubastas();
		gestorProductos = new GestorProductos("VACUNO");
		gestorUsuarios = new GestorUsuarios();
		setTitle("Crear oferta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos dela puja", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(43, 24, 345, 181);
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 10));
			{
				JLabel lblNewLabel = new JLabel("Producto");
				panel.add(lblNewLabel);
			}
			
			productoCombo = new JComboBox();
			Iterator<ComboItemDTO> productosItems= gestorSubastas.getProductosOfertados().iterator();
			while (productosItems.hasNext()) {
				ComboItemDTO productoItem = (ComboItemDTO) productosItems.next();
				productoCombo.addItem(productoItem);
			}
			panel.add(productoCombo);
			
			JLabel lblNewLabel_1 = new JLabel("Precio oferta");
			panel.add(lblNewLabel_1);
			
			precioOferta = new JTextField();
			panel.add(precioOferta);
			precioOferta.setColumns(10);
			
			{
				JLabel lblUsuariol = new JLabel("Litigante");
				panel.add(lblUsuariol);
			}
			
			usuarioCombo = new JComboBox();
			Iterator<ComboItemDTO> usuarioItems= gestorUsuarios.getUsuariosSinPropietario(1).iterator();
			while (usuarioItems.hasNext()) {
				ComboItemDTO usuarioItem = (ComboItemDTO) usuarioItems.next();
				usuarioCombo.addItem(usuarioItem);
			}
			panel.add(usuarioCombo);
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JLabel mensaje = new JLabel("");
			buttonPane.add(mensaje);
			
			btnOfertar = new JButton("Enviar Datos");
			btnOfertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String respuesta = gestorSubastas.ofertar(Integer.parseInt(((ComboItemDTO)usuarioCombo.getSelectedItem()).getKey()), Double.parseDouble(precioOferta.getText()),Integer.parseInt(((ComboItemDTO)productoCombo.getSelectedItem()).getKey()));
					mensaje.setText(respuesta);
				}
			});
			btnOfertar.setActionCommand("OK");
			buttonPane.add(btnOfertar);
			getRootPane().setDefaultButton(btnOfertar);
		}
	}
}
