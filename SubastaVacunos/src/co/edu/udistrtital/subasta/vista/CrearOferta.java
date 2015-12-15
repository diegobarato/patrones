
package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.udistrtital.subasta.control.dto.ComboItemDTO;
import co.edu.udistrtital.subasta.control.gestor.GestorProductos;
import co.edu.udistrtital.subasta.control.gestor.GestorSubastas;

public class CrearOferta extends JDialog {

	private GestorSubastas gestorSubastas;
	private GestorProductos gestorProductos;

	private final JPanel contentPanel = new JPanel();
	JLabel resultado;
	int idProductoSeleccionado;

	/**
	 * Create the dialog.
	 */
	public CrearOferta() {
		gestorSubastas = new GestorSubastas();
		gestorProductos = new GestorProductos("VACUNO");
		setBounds(100, 100, 450, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 434, 28);
			contentPanel.add(panel);
			{
				JLabel lblCreacinDeUna = new JLabel("Creaci\u00F3n de oferta de un semoviente");
				lblCreacinDeUna.setFont(new Font("Verdana", Font.BOLD, 12));
				panel.add(lblCreacinDeUna);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Semoviente a ofertar");
			lblNewLabel.setBounds(31, 54, 139, 14);
			contentPanel.add(lblNewLabel);
		}

		JComboBox productoCombo = new JComboBox();
		Iterator<ComboItemDTO> productosItems = gestorSubastas.getProductosOfertados().iterator();
		while (productosItems.hasNext()) {
			ComboItemDTO productoItem = (ComboItemDTO) productosItems.next();
			productoCombo.addItem(productoItem);
		}
		productoCombo.setBounds(192, 50, 205, 20);
		contentPanel.add(productoCombo);

		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultado.setText(productoCombo.getSelectedItem().toString());
				idProductoSeleccionado = Integer.parseInt(((ComboItemDTO) productoCombo.getSelectedItem()).getKey());
			}
		});
		btnNewButton.setBounds(192, 92, 106, 23);
		contentPanel.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(308, 92, 89, 23);
		contentPanel.add(btnCancelar);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));

			JLabel lblNombreActual = new JLabel("Semoviente seleccionado:    ");
			buttonPane.add(lblNombreActual, BorderLayout.WEST);

			resultado = new JLabel(" ");
			buttonPane.add(resultado, BorderLayout.CENTER);

			JButton cancelButton = new JButton("Ofertar");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton, BorderLayout.EAST);
		}
	}
}
