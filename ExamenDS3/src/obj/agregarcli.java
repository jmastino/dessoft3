package obj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class agregarcli extends JFrame {

	private JTextField tfcedula;
	private JTextField tfnombre;
	private JTextField tfapellido;
	private JTextField tfdireccion;
	private JTextField tftelefono;
	
	
	
	
	/**
	 * Create the panel.
	 */
	public agregarcli(JFrame frame) {
		JPanel contentPane;
		setTitle("AGREGAR CLIENTE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcedula = new JLabel("Cédula:");
		lblcedula.setBounds(10, 11, 57, 14);
		contentPane.add(lblcedula);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(10, 40, 57, 14);
		contentPane.add(lblnombre);
		
		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setBounds(10, 73, 57, 14);
		contentPane.add(lblapellido);
		
		JLabel lbldireccion = new JLabel("Direccion:");
		lbldireccion.setBounds(10, 101, 63, 21);
		contentPane.add(lbldireccion);
		
		JLabel lbltelefono = new JLabel("Telefono:");
		lbltelefono.setBounds(10, 141, 57, 14);
		contentPane.add(lbltelefono);
		
		tfcedula = new JTextField();
		tfcedula.setBounds(83, 5, 86, 20);
		contentPane.add(tfcedula);
		tfcedula.setColumns(10);
		
		tfnombre = new JTextField();
		tfnombre.setBounds(83, 34, 86, 20);
		contentPane.add(tfnombre);
		tfnombre.setColumns(10);
		
		tfapellido = new JTextField();
		tfapellido.setBounds(83, 67, 86, 20);
		contentPane.add(tfapellido);
		tfapellido.setColumns(10);
		
		tfdireccion = new JTextField();
		tfdireccion.setBounds(83, 98, 110, 20);
		contentPane.add(tfdireccion);
		tfdireccion.setColumns(10);
		
		tftelefono = new JTextField();
		tftelefono.setBounds(83, 135, 86, 20);
		contentPane.add(tftelefono);
		tftelefono.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManejoSQL mnj = new ManejoSQL();
				
				mnj.cli.setIdcedula(mnj.truncar(tfcedula.getText().replace(" ", ""), 20));
				mnj.cli.setNombre(mnj.truncar(tfnombre.getText(), 30));
				mnj.cli.setApellido(mnj.truncar(tfapellido.getText(), 30));
				mnj.cli.setDireccion(mnj.truncar(tfdireccion.getText(), 30));
				mnj.cli.setTelefono(mnj.truncar(tftelefono.getText(), 30));
				mnj.cli.setSaldos(0.00);
				mnj.cli.setUpdated(mnj.insertarhora());
				mnj.cli.setCreated(mnj.insertarhora());
				mnj.cli.setEsborrado(false);
				mnj.creartable();
				
				
				
				
				mnj.agregarcli(mnj.cli);
				JOptionPane.showMessageDialog(btnNewButton, "Se registro el Cliente", "Se ha insertado su cliente", 1, null);
			}
		});
		btnNewButton.setBounds(239, 50, 127, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar Todo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tfapellido.setText("");
			tfcedula.setText("");
			tfdireccion.setText("");
			tfnombre.setText("");
			tftelefono.setText("");
			}
		});
		btnNewButton_1.setBounds(239, 137, 127, 23);
		contentPane.add(btnNewButton_1);
	}

	
	
	
}
