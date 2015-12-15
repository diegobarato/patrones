package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.edu.udistrtital.subasta.control.gestor.GestorSubastas;

public class CrearPuja extends JDialog {

	private GestorSubastas gestorSubastas;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField precioInicial;
	private JTextField horaInicio;
	private JTextField horaTerminacion;

	/**
	 * Create the dialog.
	 */
	public CrearPuja() {
		gestorSubastas = new GestorSubastas(1);
		setTitle("Crear puja");
		setBounds(100, 100, 339, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 323, 26);
		contentPanel.add(panel);
		
		JLabel lblCrearPuja = new JLabel("Habilitar semoviente para puja");
		lblCrearPuja.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(lblCrearPuja);
		
		JLabel lblNewLabel = new JLabel("Precio inicial de la puja");
		lblNewLabel.setBounds(24, 37, 170, 14);
		contentPanel.add(lblNewLabel);
		
		precioInicial = new JTextField();
		precioInicial.setBounds(204, 37, 86, 20);
		contentPanel.add(precioInicial);
		precioInicial.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de inicio");
		lblNewLabel_1.setBounds(24, 74, 170, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblFechaDeTerminacin = new JLabel("Fecha de terminaci\u00F3n");
		lblFechaDeTerminacin.setBounds(24, 112, 170, 14);
		contentPanel.add(lblFechaDeTerminacin);
		
		horaInicio = new JTextField();
		horaInicio.setBounds(204, 74, 86, 20);
		contentPanel.add(horaInicio);
		horaInicio.setColumns(10);
		
		horaTerminacion = new JTextField();
		horaTerminacion.setBounds(204, 112, 86, 20);
		contentPanel.add(horaTerminacion);
		horaTerminacion.setColumns(10);
		{ 
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
				JButton okButton = new JButton("Crear Puja");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] inicio = horaInicio.getText().split(":");
						String[] fin = horaTerminacion.getText().split(":");
						Calendar calInicio = Calendar.getInstance();
						calInicio.set(Calendar.HOUR_OF_DAY, Integer.parseInt(inicio[0]));
						calInicio.set(Calendar.MINUTE, Integer.parseInt(inicio[1]));
						Calendar calFin = Calendar.getInstance();
						calFin.set(Calendar.HOUR_OF_DAY, Integer.parseInt(fin[0]));
						calFin.set(Calendar.MINUTE, Integer.parseInt(fin[1]));
						gestorSubastas.crearSubasta( Double.valueOf(precioInicial.getText()), calInicio.getTime(), calFin.getTime());
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);

				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
		}
	}
}
