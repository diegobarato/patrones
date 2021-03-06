package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.control.gestor.BuscarEntidad;
import co.edu.udistrtital.subasta.control.gestor.GestorProductos;
import co.edu.udistrtital.subasta.control.gestor.GestorSubastas;
import co.edu.udistrtital.subasta.control.gestor.GestorUsuarios;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CrearOfertaEnviar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private int idProducto;
	private GestorProductos gestorProductos;
	private BuscarEntidad buscarEntidad;
	private GestorUsuarios gestorUsuarios;
	private GestorSubastas gestorSubastas;
	JComboBox comboBox;
	JLabel resultado;
	
	/**
	 * Create the dialog.
	 */
	public CrearOfertaEnviar(int idProducto) {
		this.idProducto = idProducto;
		gestorProductos = new GestorProductos("VACUNO");
		gestorUsuarios = new GestorUsuarios();
		gestorSubastas = new GestorSubastas();
		buscarEntidad = new BuscarEntidad();
		String nombreProducto = buscarEntidad.getNombreProducto(idProducto);
		
		setBounds(100, 100, 371, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 355, 26);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("Precio oferta semoviente");
				lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
				panel.add(lblNewLabel);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Semoviente: ");
			lblNewLabel_1.setBounds(41, 48, 98, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel nombreSemoviente = new JLabel(nombreProducto);
			nombreSemoviente.setBounds(149, 48, 167, 14);
			contentPanel.add(nombreSemoviente);
		}
		{
			JLabel lblPrecioOferta = new JLabel("Precio oferta: ");
			lblPrecioOferta.setBounds(41, 92, 98, 14);
			contentPanel.add(lblPrecioOferta);
		}
		{
			textField = new JTextField();
			textField.setBounds(149, 89, 167, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblLitigante = new JLabel("Litigante: ");
			lblLitigante.setBounds(41, 128, 98, 14);
			contentPanel.add(lblLitigante);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBounds(149, 125, 167, 20);
			Iterator<ComboItemDTO> usuarioItems= gestorUsuarios.getUsuariosSinPropietario(idProducto).iterator();
			while (usuarioItems.hasNext()) {
				ComboItemDTO usuarioItem = (ComboItemDTO) usuarioItems.next();
				comboBox.addItem(usuarioItem);
			}
			contentPanel.add(comboBox);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 178, 335, 39);
			contentPanel.add(panel);
			{
				resultado = new JLabel("  ");
				panel.add(resultado);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ofertar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String respuesta = gestorSubastas.ofertar(Integer.parseInt(((ComboItemDTO)comboBox.getSelectedItem()).getKey()), Double.parseDouble(textField.getText()),idProducto);
						resultado.setText(respuesta);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
