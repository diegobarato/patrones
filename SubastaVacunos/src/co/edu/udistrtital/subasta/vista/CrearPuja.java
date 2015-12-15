package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CrearPuja extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	
	public CrearPuja() {
		setTitle("Crear semoviente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	}

}
