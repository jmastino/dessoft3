package pantalla1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/* Materia: desarrollo de software III
 * Profesor: Andy Gomez de la Torre
 * Nombre del Proyecto: P4EJmastino
 * Programador: Jordy Mastino
 * Descripción del Programa: para la realizacion de la practica cuatro implementa la resolucion de la ecuación cuadratica 
 */

public class pantallaprincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tf_a;
	private JTextField tf_b;
	private JTextField tf_c;
	private JLabel lblNewLabel_3;
	private JTextField tf_result;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btn_resolver;
	private JButton btn_limpiar;
	private JButton btn_salir;

	/*
	 * invoca el inicio de la aplicacion
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaprincipal frame = new pantallaprincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Crea el Frame de Ventana
	 */
	public pantallaprincipal() {
		setResizable(false);
		setTitle("Introduce la ecuación cuadrática");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel(" Introduce de acuerdo a una ecuacion cuadratica, los campos requeridos.");
		lblNewLabel.setBounds(0, 0, 424, 14);
		contentPane.add(lblNewLabel);
		
		tf_a = new JTextField();
		tf_a.setBounds(59, 49, 29, 20);
		contentPane.add(tf_a);
		tf_a.setColumns(10);
		
		tf_b = new JTextField();
		tf_b.setBounds(59, 74, 29, 20);
		contentPane.add(tf_b);
		tf_b.setColumns(10);
		
		tf_c = new JTextField();
		tf_c.setBounds(59, 100, 29, 20);
		contentPane.add(tf_c);
		tf_c.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Introduce coeficiente:");
		lblNewLabel_3.setBounds(10, 27, 141, 20);
		contentPane.add(lblNewLabel_3);
		
		tf_result = new JTextField();
		tf_result.setEditable(false);
		tf_result.setBounds(10, 131, 414, 43);
		contentPane.add(tf_result);
		tf_result.setColumns(10);
		
		lblNewLabel_4 = new JLabel("a");
		lblNewLabel_4.setBounds(29, 52, 20, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("b");
		lblNewLabel_5.setBounds(29, 77, 20, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("c");
		lblNewLabel_6.setBounds(29, 103, 20, 14);
		contentPane.add(lblNewLabel_6);
		
		btn_resolver = new JButton("Resolver ecuación");
		btn_resolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a,b,c;
			try {
				a=Double.parseDouble(tf_a.getText().trim());
			} catch (Exception e2) {
				throw new NumberFormatException("revise la sintaxis introducida");
			}	
				
				b=Double.parseDouble(tf_b.getText().trim());
				c=Double.parseDouble(tf_c.getText().trim());
				MetodoNumEc mtd = new MetodoNumEc(a,b,c);
				mtd.calc(a, b, c);
				tf_result.setText("El resultado es: \n"+mtd.getX1()+", "+mtd.getX2());
				//llamo al atributo
			}
		});
		btn_resolver.setBounds(10, 182, 128, 23);
		contentPane.add(btn_resolver);
		
		btn_limpiar = new JButton("limpiar");
		btn_limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_a.setText("");
				tf_b.setText("");
				tf_c.setText("");
				tf_result.setText("");
				tf_a.requestFocus();
			}
		});
		btn_limpiar.setBounds(148, 182, 89, 23);
		contentPane.add(btn_limpiar);
		
		btn_salir = new JButton("Salir");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_salir.setBounds(247, 182, 89, 23);
		contentPane.add(btn_salir);
	}
}
