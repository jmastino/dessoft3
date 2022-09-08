package principal;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import objetos.Calcularmesmetodos;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;



/*
 * Materia: desarrollo de software III
 * Profesor: Andy Gomez de la Torre
 * Nombre del Proyecto: EP1EJmastino3  (Examen Parcial 1 ejercicio 3)
 * Programador: Jordy Mastino
 * Descripción del Programa: este programa realiza por introducción calculo de dias del mes y ademas determina si es año bisiesto devuelve
 * para el mes de febrero 29 dias
 * el resultado lo muestra en modo de texto tipo (string). 
 */
public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField tfnummes;
	private JTextField tfnumanio;
	private JTextField tfresultmes;
	private JTextField tfesbisiesto;

	
	/**
	 * lanza la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * crea la ventana de Frame.
	 */
	public Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/principal/PinClipart.com_calendar-clip-art_4015156.png")));
		setTitle("Determina los dias del Mes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldescripcion = new JLabel("Con este programa determina la cantidad de dias del mes introducido.");
		lbldescripcion.setBounds(10, 4, 440, 22);
		contentPane.add(lbldescripcion);
		
		JLabel lblpidiendomes = new JLabel("Introduce el Número del Mes:");
		lblpidiendomes.setBounds(10, 37, 182, 14);
		contentPane.add(lblpidiendomes);
		
		tfnummes = new JTextField();
		tfnummes.setBounds(202, 33, 35, 20);
		contentPane.add(tfnummes);
		tfnummes.setColumns(10);
		
		JLabel lblintroanio = new JLabel("Introduce el Número del Año:");
		lblintroanio.setBounds(10, 65, 182, 14);
		contentPane.add(lblintroanio);
		
		tfnumanio = new JTextField();
		tfnumanio.setColumns(10);
		tfnumanio.setBounds(202, 64, 35, 20);
		contentPane.add(tfnumanio);
		
		tfresultmes = new JTextField();
		tfresultmes.setDisabledTextColor(Color.BLACK);
		tfresultmes.setEnabled(false);
		tfresultmes.setEditable(false);
		tfresultmes.setBounds(10, 97, 430, 20);
		contentPane.add(tfresultmes);
		tfresultmes.setColumns(10);
		
		tfesbisiesto = new JTextField();
		tfesbisiesto.setDisabledTextColor(Color.BLACK);
		tfesbisiesto.setEditable(false);
		tfesbisiesto.setEnabled(false);
		tfesbisiesto.setBounds(126, 117, 119, 20);
		contentPane.add(tfesbisiesto);
		tfesbisiesto.setColumns(10);
		
		
		/*
		 * En esta ocasión al botón calcular no he aplicado las caracteristicas de try && catch por lo que la medida
		 * de utilizar algun string o char lo convertira parseado a int :/ 
		 * no he utilizado el manejo de errores de codigo al aparecer error debera limpiar los campos.
		 * utilizado solo accion presionando enter para el btncalcular.
		 */
		JButton btnResolver = new JButton("Calcular");
		btnResolver.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					//variables de almacenar y trasladar o manipular los datos
					int anio = Integer.parseInt(tfnumanio.getText());
					int mesinput = Integer.parseInt(tfnummes.getText());
					//cambia el mes a las variables locales determinando su año bisesto
					mesinput = objetos.Calcularmesmetodos.mesbisiesto(mesinput, anio);  
					//para calcular llama el metodo no estatico de esa clase
					Calcularmesmetodos obj = new Calcularmesmetodos();
					//aqui trae por metodo el resultado requerido  (ver requerimientos)
					tfresultmes.setText(obj.devolverresultado(mesinput, anio));
					//siempre que sea bisiesto manifiesta en el resultado
					if(objetos.Calcularmesmetodos.esBisiesto(anio)==true) 
					{
					tfesbisiesto.setText("Es año Bisiesto.");
					}
				}
			}
		});
		
		btnResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//variables de almacenar y trasladar o manipular los datos
				int anio = Integer.parseInt(tfnumanio.getText());
				int mesinput = Integer.parseInt(tfnummes.getText());
				//cambia el mes a las variables locales determinando su año bisesto
				mesinput = objetos.Calcularmesmetodos.mesbisiesto(mesinput, anio);  
				//para calcular llama el metodo no estatico de esa clase
				Calcularmesmetodos obj = new Calcularmesmetodos();
				//aqui trae por metodo el resultado requerido  (ver requerimientos)
				tfresultmes.setText(obj.devolverresultado(mesinput, anio));
				//siempre que sea bisiesto manifiesta en el resultado
				if(objetos.Calcularmesmetodos.esBisiesto(anio)==true) 
				{
				tfesbisiesto.setText("Es año Bisiesto.");
				}
			}
			});
		
		btnResolver.setBounds(10, 153, 89, 23);
		contentPane.add(btnResolver);
		
		JButton btnlimpiar = new JButton("Limpiar");
		btnlimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfnummes.setText("");
				tfresultmes.setText("");
				tfnumanio.setText("");
				tfesbisiesto.setText("");
				tfnummes.requestFocus();
			}
		});
		btnlimpiar.setBounds(156, 153, 89, 23);
		contentPane.add(btnlimpiar);
		
		JButton btnexit = new JButton("Salir");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnexit.setBounds(285, 153, 89, 23);
		contentPane.add(btnexit);
	}
}
