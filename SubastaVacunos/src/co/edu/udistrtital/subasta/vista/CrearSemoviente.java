package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.control.gestor.GestorProductos;
import co.edu.udistrtital.subasta.modelo.catalogo.Categoria;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class CrearSemoviente extends JDialog {

	private GestorProductos gestorProductos;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField precio;
	private JComboBox categoria;
	private JComboBox propietario;
	private JButton okButton;
	private JButton btnIniciarPuja;
	private JButton cancelButton;

	/**
	 * Create the dialog.
	 */
	public CrearSemoviente() {
		gestorProductos = new GestorProductos("VACUNO");
		setTitle("Crear semoviente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos del animal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(43, 24, 345, 181);
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(0, 2, 0, 10));
			{
				JLabel lblNewLabel = new JLabel("Nombre");
				panel.add(lblNewLabel);
			}
			
			nombre = new JTextField();
			panel.add(nombre);
			nombre.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Precio");
			panel.add(lblNewLabel_1);
			
			precio = new JTextField();
			panel.add(precio);
			precio.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Categor\u00EDa");
			panel.add(lblNewLabel_2);
			
			categoria = new JComboBox();
			Iterator<ComboItemDTO> categoriaItems= gestorProductos.getCategorias().iterator();
			while (categoriaItems.hasNext()) {
				ComboItemDTO comboItemDTO = (ComboItemDTO) categoriaItems.next();
				categoria.addItem(comboItemDTO);
			}
			panel.add(categoria);
			
			JLabel lblNewLabel_3 = new JLabel("Propietario");
			panel.add(lblNewLabel_3);
			
			propietario = new JComboBox();
			Iterator<ComboItemDTO> propietariosItems= gestorProductos.getUsuarios().iterator();
			while (propietariosItems.hasNext()) {
				ComboItemDTO propietarioItem = (ComboItemDTO) propietariosItems.next();
				propietario.addItem(propietarioItem);
			}
			panel.add(propietario);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			okButton = new JButton("Insertar Animal");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gestorProductos.crearProducto(nombre.getText(), Double.parseDouble(precio.getText()), ((ComboItemDTO)categoria.getSelectedItem()).getKey(), ((ComboItemDTO)propietario.getSelectedItem()).getKey());
					btnIniciarPuja.setEnabled(true);
					okButton.setEnabled(false);
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
			
			btnIniciarPuja = new JButton("Iniciar puja");
			btnIniciarPuja.setEnabled(false);
			buttonPane.add(btnIniciarPuja);
			
			cancelButton = new JButton("Cancel");
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
	}
}
