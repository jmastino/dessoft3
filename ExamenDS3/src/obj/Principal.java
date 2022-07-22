package obj;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.EventQueue;

public class Principal extends JFrame{
	
	
	
	
	
	public static void main(String[] args) {
		//JPasswordField pass = new JPasswordField();
	//	JOptionPane.showConfirmDialog(null, "la contraseña de la base de datos", "Ingrese contraseña", 3);
		
		//este define en el inicio del programa la contraseña a utilizar toda vez que se apaga la ventana de programa preguntara nuevamente las credenciales
		Principal pp = new Principal(null);
		pp.login(null);
		//activar el menu principal
		//pp.menupri(null);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e,"error de ventada menu",0,null);
				}
			}
		});
		
		
	}

	
	public void login(JFrame frame) {

	    JPanel panel = new JPanel(new BorderLayout(5, 5));

	    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
	    label.add(new JLabel("Usuario", SwingConstants.RIGHT));
	    label.add(new JLabel("Contraseña", SwingConstants.RIGHT));
	    panel.add(label, BorderLayout.WEST);

	    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
	    JTextField username = new JTextField();
	    controls.add(username);
	    JPasswordField password = new JPasswordField();
	    controls.add(password);
	    panel.add(controls, BorderLayout.CENTER);

	    JOptionPane.showMessageDialog(frame, panel, "Inicie Sesión en la Base de datos", JOptionPane.OK_CANCEL_OPTION);

	    conex.conex.logininformation.put("user", username.getText());
	    conex.conex.logininformation.put("pass", new String(password.getPassword()));
	    
	}
	
	
	
	public Principal(JFrame frame) {
		setTitle("REGISTRO CREDITOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/obj/logo.png")));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Créditos");
		lblNewLabel.setBounds(153, 1, 152, 30);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adelitas Boutique");
		lblNewLabel_1.setBounds(153, 25, 121, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("R.U.C 4-715-1225  D.V. 01");
		lblNewLabel_2.setBounds(133, 50, 152, 24);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("CREAR CLIENTE");
		btnNewButton_1.setBounds(27, 101, 165, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			agregarcli emp = new agregarcli(frame);
			
			emp.setVisible(true);
			
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("NUEVO CREDITO CLIENTE");
		btnNewButton_2.setBounds(202, 101, 181, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agrecred emp = new agrecred();
				emp.setVisible(true);
			}
		});
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("REPORTES DE SALDO");
		btnNewButton_3.setBounds(27, 127, 165, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("NUEVO PAGO CLIENTE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			agrepago emp = new agrepago();
			emp.setVisible(true);
			}
		});
		btnNewButton.setBounds(200, 127, 183, 23);
		getContentPane().add(btnNewButton);
	}
}