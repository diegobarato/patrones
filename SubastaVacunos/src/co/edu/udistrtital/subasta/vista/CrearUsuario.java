package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.udistrtital.subasta.control.gestor.GestorUsuarios;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class CrearUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreUsuario;
	private GestorUsuarios gestorUsuarios;

	/**
	 * Create the dialog.
	 */
	public CrearUsuario() {
		gestorUsuarios = new GestorUsuarios();
		setTitle("Creaci\u00F3n de usuario");
		setBounds(100, 100, 450, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre completo:");
		lblNewLabel.setBounds(60, 73, 138, 14);
		contentPanel.add(lblNewLabel);
		
		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(162, 70, 205, 20);
		contentPanel.add(nombreUsuario);
		nombreUsuario.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 30);
		contentPanel.add(panel);
		{
			JLabel lblCreacinDeUn = new JLabel("Creaci\u00F3n de un usuario");
			lblCreacinDeUn.setFont(new Font("Verdana", Font.BOLD, 12));
			panel.add(lblCreacinDeUn);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear usuario");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						gestorUsuarios.crearUsuario(nombreUsuario.getText());
						dispose();
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
