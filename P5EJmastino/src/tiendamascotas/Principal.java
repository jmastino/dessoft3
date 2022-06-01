package tiendamascotas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/tiendamascotas/1598750.png")));
		setTitle("Tienda de Mascotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Seleccione el animal:");
		lblNewLabel.setBounds(59, 14, 105, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox animal = new JComboBox();
		animal.setModel(new DefaultComboBoxModel(new String[] {"Perro", "Gato"}));
		animal.setBounds(164, 10, 105, 22);
		contentPane.add(animal);
	
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(279, 10, 89, 23);
		contentPane.add(btnActualizar);
		
		JComboBox categoriaperro = new JComboBox();
		categoriaperro.setBounds(10, 41, 105, 22);
		contentPane.add(categoriaperro);
		categoriaperro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"perros pequeños","perros medianos","perros grandes"}));
		
		JComboBox razacombobox = new JComboBox();
		razacombobox.setBounds(10, 74, 105, 22);
		contentPane.add(razacombobox);
		//mejorar action event
		if(categoriaperro.getSelectedItem().toString().equalsIgnoreCase("perros pequeños")) {
		razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"caniche","yorkshire terrier","schnauzer","chihuahua"}));
		}
		else if(categoriaperro.getSelectedItem().toString().equalsIgnoreCase("perros medianos")) {
			razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"collie","dálmata","bulldog","galgo","sabueso"}));
			}
		else if(categoriaperro.getSelectedItem().toString().equalsIgnoreCase("perros grandes")) {
			razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"pastor alemán","doberman","rotweiller"}));
			}
	 
	}
}
