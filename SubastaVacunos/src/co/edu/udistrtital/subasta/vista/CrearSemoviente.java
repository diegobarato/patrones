package co.edu.udistrtital.subasta.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearSemoviente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearSemoviente dialog = new CrearSemoviente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearSemoviente() {
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
			
			JComboBox categoria = new JComboBox();
			panel.add(categoria);
			
			JLabel lblNewLabel_3 = new JLabel("Propietario");
			panel.add(lblNewLabel_3);
			
			JComboBox propietario = new JComboBox();
			panel.add(propietario);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insertar Animal");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			JButton btnIniciarPuja = new JButton("Iniciar puja");
			buttonPane.add(btnIniciarPuja);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
