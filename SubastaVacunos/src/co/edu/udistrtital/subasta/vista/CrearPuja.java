package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import co.edu.udistrtital.subasta.control.gestor.GestorSubastas;

public class CrearPuja extends JDialog {
	
	private GestorSubastas gestorSubastas;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField precioInicial;
	private JTextField horaInicio;
	private JTextField horaTerminacion;
	private JButton enviarDatos;
	
	public CrearPuja() {
		gestorSubastas = new GestorSubastas(1);
		setTitle("Crear puja");
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
				JLabel lblNewLabel = new JLabel("Precio Inicial");
				panel.add(lblNewLabel);
			}
			
			precioInicial = new JTextField();
			panel.add(precioInicial);
			precioInicial.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Hora Inicio");
			panel.add(lblNewLabel_1);
			
			horaInicio = new JTextField();
			panel.add(horaInicio);
			horaInicio.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Hora Terminacion");
			panel.add(lblNewLabel_2);
			
			horaTerminacion = new JTextField();
			panel.add(horaTerminacion);
			horaTerminacion.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			enviarDatos = new JButton("Enviar Datos");
			enviarDatos.addActionListener(new ActionListener() {
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
					
				}
			});
			enviarDatos.setActionCommand("OK");
			buttonPane.add(enviarDatos);
			getRootPane().setDefaultButton(enviarDatos);
			

		}
	}

	public void setGestorSubastas(GestorSubastas gestorSubastas) {
		this.gestorSubastas = gestorSubastas;
	}
}
