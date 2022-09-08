package tiendamascotas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;


/* Materia: desarrollo de software III
 * Profesor: Andy Gomez de la Torre
 * Nombre del Proyecto: P5EJmastino
 * Programador: Jordy Mastino
 * Descripción del Programa: para la realizacion de la practica cinco implementa POO, herencia, interfaz y contiene un metodo 
 * que comparten los objetos pero que son distintos para cada objeto
 * los objetos tienen sus atributos caracteristicos 
 */

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextArea TFresult;
	private JTextField tfnombremascota;
	private JTextField tfedadmascota;
	private JTextField tfcolormascota;
	private JTextField tf_peso_alturasalto;
	private JTextField tf_muerde_longitud_salto;
	Gato gat = new Gato();
	Perro per = new Perro();
	
	/**
	 * Inicio de la aplicacion
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
	 * Crea la Ventana de Frame.
	 */
	public Principal() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/tiendamascotas/1598750.png")));
		setTitle("Tienda de Mascotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Seleccione el animal:");
		lblNewLabel.setBounds(10, 15, 144, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox razacombobox = new JComboBox();
		razacombobox.setBounds(164, 73, 127, 22);
		contentPane.add(razacombobox);
		
		
		JComboBox categoriaanimal = new JComboBox();
		categoriaanimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//aqui manejas si son gatos y perros y su correspondiente seleeccion
			if(categoriaanimal.getSelectedItem().toString().equalsIgnoreCase("Perros pequeños")) {
				razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Caniche","Yorkshire terrier","Schnauzer","Chihuahua"}));
			}
			else if(categoriaanimal.getSelectedItem().toString().equalsIgnoreCase("Perros medianos")) {
				razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Collie","Dálmata","Bulldog","Galgo","Sabueso"}));
			}
			else if(categoriaanimal.getSelectedItem().toString().equalsIgnoreCase("Perros grandes")) {
				razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Pastor Alemán","Doberman","Rotweiller"}));
			}
			else if(categoriaanimal.getSelectedItem().toString().equalsIgnoreCase("Sin pelo")) {
				razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Esfinge", "Elfo","Donskoy"}));
			}
			else if(categoriaanimal.getSelectedItem().toString().equalsIgnoreCase("Pelo corto")) {
				razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Azul ruso","Británico", "Manx","Devon rex"}));
			}
			else if(categoriaanimal.getSelectedItem().toString().equalsIgnoreCase("Pelo largo")) {
				razacombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Angora","Himalayo", "Balinés"}));
			}
			}
		});
		categoriaanimal.setBounds(164, 40, 127, 22);
		contentPane.add(categoriaanimal);
		
		tf_peso_alturasalto = new JTextField();
		tf_peso_alturasalto.setFocusable(false);
		tf_peso_alturasalto.setRequestFocusEnabled(false);
		tf_peso_alturasalto.setDisabledTextColor(Color.BLACK);
		tf_peso_alturasalto.setEditable(false);
		tf_peso_alturasalto.setBounds(10, 192, 164, 20);
		contentPane.add(tf_peso_alturasalto);
		
		tf_muerde_longitud_salto = new JTextField();
		tf_muerde_longitud_salto.setRequestFocusEnabled(false);
		tf_muerde_longitud_salto.setFocusable(false);
		tf_muerde_longitud_salto.setDisabledTextColor(Color.BLACK);
		tf_muerde_longitud_salto.setEditable(false);
		tf_muerde_longitud_salto.setBounds(10, 223, 164, 20);
		contentPane.add(tf_muerde_longitud_salto);
		
		JComboBox animal = new JComboBox();
		animal.setModel(new DefaultComboBoxModel(new String[] {"Perro", "Gato"}));
		animal.setBounds(164, 11, 127, 22);
		animal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(animal.getSelectedItem().toString().equalsIgnoreCase("Perro")) {
					categoriaanimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Perros pequeños","Perros medianos","Perros grandes"}));
					tf_peso_alturasalto.setText("Introduzca peso:");
					tf_muerde_longitud_salto.setText("¿muerde si o no?:");
				}
				else {
					categoriaanimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Sin pelo","Pelo corto","Pelo largo"}));
					tf_peso_alturasalto.setText("Introduzca Altura de Salto: ");
					tf_muerde_longitud_salto.setText("Introduzca Longitud de Salto:");
				}
			}
		});
		contentPane.add(animal);
		
		JLabel lblSeleccioneSuCategora = new JLabel("Seleccione su categoría:");
		lblSeleccioneSuCategora.setBounds(10, 44, 144, 14);
		contentPane.add(lblSeleccioneSuCategora);
		
		JLabel lblSeleccioneSuRaza = new JLabel("Seleccione su raza:");
		lblSeleccioneSuRaza.setBounds(10, 77, 144, 14);
		contentPane.add(lblSeleccioneSuRaza);
		
		TFresult = new JTextArea();
		TFresult.setBackground(Color.WHITE);
		TFresult.setRequestFocusEnabled(false);
		TFresult.setFocusable(false);
		TFresult.setEditable(false);
		TFresult.setBounds(10, 284, 362, 101);
		contentPane.add(TFresult);
		TFresult.setColumns(10);
		
		JLabel lblnombremascota = new JLabel("Introduzca el nombre de la mascota:");
		lblnombremascota.setBounds(10, 108, 217, 14);
		contentPane.add(lblnombremascota);
		
		tfnombremascota = new JTextField();
		tfnombremascota.setBounds(245, 106, 127, 20);
		contentPane.add(tfnombremascota);
		tfnombremascota.setColumns(10);
		
		JLabel lbledadmascota = new JLabel("Introduzca la edad de la Mascota:");
		lbledadmascota.setBounds(10, 133, 194, 14);
		contentPane.add(lbledadmascota);
		
		JLabel lblcolormascota = new JLabel("Introduzca el color de la mascota:");
		lblcolormascota.setBounds(10, 158, 194, 14);
		contentPane.add(lblcolormascota);
		
		tfedadmascota = new JTextField();
		tfedadmascota.setColumns(10);
		tfedadmascota.setBounds(245, 131, 127, 20);
		contentPane.add(tfedadmascota);
		
		tfcolormascota = new JTextField();
		tfcolormascota.setColumns(10);
		tfcolormascota.setBounds(245, 156, 127, 20);
		contentPane.add(tfcolormascota);
		
		JTextField tfpesoalturainput = new JTextField();
		tfpesoalturainput.setBounds(184, 192, 85, 22);
		contentPane.add(tfpesoalturainput);
		
		JTextField tfmuerde_longitudsaltoinput = new JTextField();
		tfmuerde_longitudsaltoinput.setBounds(184, 223, 85, 22);
		contentPane.add(tfmuerde_longitudsaltoinput);
		
		JButton btnmostrarinfo = new JButton("Mostrar Información");
		btnmostrarinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(animal.getSelectedItem().toString().equalsIgnoreCase("Perro")) 
			{
				
				if(tfmuerde_longitudsaltoinput.toString().equalsIgnoreCase("si")) {
					per.setMuerde(true);
				}
				else if(tfmuerde_longitudsaltoinput.toString().equalsIgnoreCase("sí"))
				{
					per.setMuerde(true);
				}
				else if (tfmuerde_longitudsaltoinput.toString().equalsIgnoreCase("no")) 
				{per.setMuerde(false);}
				
				per.setNombre(tfnombremascota.getText().toString());
				per.setEdad(tfedadmascota.getText().toString());
				per.setColor(tfcolormascota.getText().toString());
				per.setTamano(categoriaanimal.getSelectedItem().toString());
				per.setRaza(razacombobox.getSelectedItem().toString());
				per.setPeso(Float.parseFloat(tfpesoalturainput.getText()));
				
				TFresult.setText(per.mostraratr());
			}
			if(animal.getSelectedItem().toString().equalsIgnoreCase("Gato"))
			{
				gat.setNombre(tfnombremascota.getText().toString());
				gat.setEdad(tfedadmascota.getText().toString());
				gat.setColor(tfcolormascota.getText().toString());
				gat.setCategoria(categoriaanimal.getSelectedItem().toString());
				gat.setRaza(razacombobox.getSelectedItem().toString());
				gat.setAlturasalto(Float.parseFloat(tfpesoalturainput.getText()));
				gat.setLongitudsalto(Float.parseFloat(tfmuerde_longitudsaltoinput.getText()));
				
				TFresult.setText(gat.mostraratributos());
			}
			
			
			}
		});
		btnmostrarinfo.setBounds(20, 250, 154, 23);
		contentPane.add(btnmostrarinfo);
		
		
		JButton btnsonido = new JButton("Mostrar Sonido");
		btnsonido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
		{
			if(animal.getSelectedItem().toString().equalsIgnoreCase("Perro"))
			{
				TFresult.setText(per.Sonido());
			}
			else 
			{
				TFresult.setText(gat.Sonido());
			}
		}
			});
		btnsonido.setBounds(213, 250, 161, 23);
		contentPane.add(btnsonido);
	}
	}