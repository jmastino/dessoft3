package pantalla1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class pantallaprincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tf_a;
	private JTextField tf_x;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
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

	/**
	 * Create the frame.
	 */
	public pantallaprincipal() {
		setTitle("Introduce la ecuación cuadrática");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Introduce de acuerdo a la vista de una ecuacion cuadratica.");
		lblNewLabel.setBounds(0, 0, 382, 14);
		contentPane.add(lblNewLabel);
		
		tf_a = new JTextField();
		tf_a.setBounds(40, 47, 20, 20);
		contentPane.add(tf_a);
		tf_a.setColumns(10);
		
		tf_x = new JTextField();
		tf_x.setBounds(70, 47, 29, 20);
		contentPane.add(tf_x);
		tf_x.setColumns(10);
		
		lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setBounds(99, 35, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("+");
		lblNewLabel_2.setBounds(98, 50, 20, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(109, 47, 20, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(130, 47, 15, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
