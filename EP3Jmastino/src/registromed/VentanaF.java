package registromed;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class VentanaF extends JFrame {

	private JPanel contentPane;
	private JTextField tfcedula;
	private JTextField tfnombre;
	private JTextField tfdireccion;
	private JTextField tfespecialidad;
	private JTextField tfechainiciolabores;
	private JTextField tfestado;
	private JTextField tfapellido;

	/**
	 * lanza la aplcación
	 */
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaF frame = new VentanaF();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame
	 * 
	 */
	public VentanaF() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaF.class.getResource("/registromed/img_493345.png")));
		setTitle("Registro medicos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcedula = new JLabel("Cédula:");
		lblcedula.setBounds(10, 11, 79, 14);
		contentPane.add(lblcedula);
		
		tfcedula = new JTextField();
		tfcedula.setBounds(134, 11, 115, 20);
		contentPane.add(tfcedula);
		tfcedula.setColumns(10);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(10, 36, 79, 14);
		contentPane.add(lblnombre);
		
		tfnombre = new JTextField();
		tfnombre.setBounds(134, 36, 115, 20);
		contentPane.add(tfnombre);
		tfnombre.setColumns(10);
		
		JLabel lbldireccion = new JLabel("Dirección:");
		lbldireccion.setBounds(10, 81, 67, 14);
		contentPane.add(lbldireccion);
		
		JLabel lblespecialidad = new JLabel("Especialidad:");
		lblespecialidad.setBounds(10, 109, 79, 14);
		contentPane.add(lblespecialidad);
		
		tfdireccion = new JTextField();
		tfdireccion.setBounds(87, 78, 176, 20);
		contentPane.add(tfdireccion);
		tfdireccion.setColumns(10);
		
		tfespecialidad = new JTextField();
		tfespecialidad.setBounds(87, 106, 176, 20);
		contentPane.add(tfespecialidad);
		tfespecialidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha de Inicio de Labores:");
		lblNewLabel.setBounds(10, 127, 137, 25);
		contentPane.add(lblNewLabel);
		
		tfechainiciolabores = new JTextField();
		tfechainiciolabores.setBounds(157, 127, 106, 20);
		contentPane.add(tfechainiciolabores);
		tfechainiciolabores.setColumns(10);
		
		tfestado = new JTextField();
		tfestado.setHorizontalAlignment(SwingConstants.CENTER);
		tfestado.setEnabled(false);
		tfestado.setDisabledTextColor(Color.BLACK);
		tfestado.setEditable(false);
		tfestado.setBounds(10, 158, 414, 20);
		contentPane.add(tfestado);
		tfestado.setColumns(10);

		

		JButton btneliminar = new JButton("Eliminar Registro");
		btneliminar.setFocusable(false);
		btneliminar.setFocusPainted(false);
		btneliminar.setFocusTraversalKeysEnabled(false);
		btneliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			tfcedula.requestFocus();
			}
		});
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejoarchivo mng = new manejoarchivo();
				
				String idcedula= tfcedula.getText();
				String nombre = tfnombre.getText();
				String apellido= tfapellido.getText();
				String	direccion= tfdireccion.getText();
				String especialidad= tfespecialidad.getText();
				String fechainiciolabor= tfechainiciolabores.getText();
				boolean esborrado= true;
				
				mng.borradologico(idcedula, nombre, apellido, direccion, especialidad,fechainiciolabor, esborrado);
				mng.registrarenarchivo();
			
			
			
			}
		});
		btneliminar.setBounds(279, 78, 145, 23);
		contentPane.add(btneliminar);
		
		
		

		/**
		 * este boton es lo mas importante de las operaciones primero almacena en la coleccion despues lo escribe en el archivo 
		 */
		JButton btnactualizar = new JButton("Actualizar Registro");
		btnactualizar.setFocusable(false);
		btnactualizar.setFocusPainted(false);
		btnactualizar.setFocusTraversalKeysEnabled(false);
		btnactualizar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			btneliminar.requestFocus();
			}
		});
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejoarchivo mng = new manejoarchivo();
				
				int indice= mng.buscarregistro(tfcedula.getText().toString());
				mng.arrlist.set(indice,new Medicos(tfcedula.getText(),tfnombre.getText(),tfapellido.getText(),tfdireccion.getText(),tfespecialidad.getText(),tfechainiciolabores.getText(),false));
				mng.registrarenarchivo();
				JOptionPane.showMessageDialog(btnactualizar, "Registro Actualizado");
			}
		});
		btnactualizar.setBounds(279, 52, 145, 23);
		contentPane.add(btnactualizar);
		
		
		JButton btncrear = new JButton("Crear Resgistro");
		btncrear.setFocusable(false);
		btncrear.setFocusTraversalKeysEnabled(false);
		btncrear.setFocusPainted(false);
		btncrear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			btnactualizar.requestFocus();
			}
		});
		btncrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejoarchivo mng = new manejoarchivo();
				
				
				tfestado.setText("");
				
				int indice = mng.buscarregistro(tfcedula.getText());
				
				if(indice==(-1)) {
			
					mng.arrlist.add(new Medicos(tfcedula.getText().toString(),tfnombre.getText().toString(),tfapellido.getText().toString(),tfdireccion.getText().toString(),tfespecialidad.getText().toString(),tfechainiciolabores.getText(),false));
					//llamamos este metodo porque solo hemos enviado los atributos al metodo sin escribir en un fichero a guardar los datos.
					mng.registrarenarchivo();
					JOptionPane.showMessageDialog(btncrear, "Registro creado");
					
						
				}
				else {
					if(indice!=-1) {
					//permitete buscar cuando un elemento esta borrado e ingresarlo a la coleccion	
					if(mng.arrlist.get(indice).isEsborrado()==true) {
						int input = JOptionPane.showConfirmDialog(null, "¡Su registro ha sido borrado! ", "escoga si desea actualizar",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
						switch(input) {
						case 0:{
						tfcedula.setText(mng.arrlist.get(indice).getIdcedula());
						tfnombre.setText(mng.arrlist.get(indice).getNombre());
						tfapellido.setText(mng.arrlist.get(indice).getApellido());
						tfdireccion.setText(mng.arrlist.get(indice).getDireccion());
						tfespecialidad.setText(mng.arrlist.get(indice).getEspecialidad());
						tfechainiciolabores.setText(mng.arrlist.get(indice).getFechainiciolabor());
						tfestado.setText("¡Recuerde guardar con el boton actualizar!");
						}
						
						case 1:{
							tfcedula.setText("");
							tfnombre.setText("");
							tfapellido.setText("");
							tfdireccion.setText("");
							tfespecialidad.setText("");
							tfechainiciolabores.setText("");
							tfestado.setText("");
							break;}
						case 2:{
							tfcedula.setText("");
							tfnombre.setText("");
							tfapellido.setText("");
							tfdireccion.setText("");
							tfespecialidad.setText("");
							tfechainiciolabores.setText("");
							tfestado.setText("");
							break;}
						default: {
							tfcedula.setText("");
							tfnombre.setText("");
							tfapellido.setText("");
							tfdireccion.setText("");
							tfespecialidad.setText("");
							tfechainiciolabores.setText("");
							tfestado.setText("");
							break;}
						}
						
						
					}
					else {
						int input = JOptionPane.showConfirmDialog(null, "¡Su registro existe! ", "escoga si desea actualizar guardar con boton actualizar",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
						switch(input) {
						case 0:{
							tfcedula.setText(mng.arrlist.get(indice).getIdcedula());
							tfnombre.setText(mng.arrlist.get(indice).getNombre());
							tfapellido.setText(mng.arrlist.get(indice).getApellido());
							tfdireccion.setText(mng.arrlist.get(indice).getDireccion());
							tfespecialidad.setText(mng.arrlist.get(indice).getEspecialidad());
							tfechainiciolabores.setText(mng.arrlist.get(indice).getFechainiciolabor());
							tfestado.setText("¡Recuerde guardar con el boton actualizar!");
							break;
						}
						case 1:{
							tfcedula.setText("");
							tfnombre.setText("");
							tfapellido.setText("");
							tfdireccion.setText("");
							tfespecialidad.setText("");
							tfechainiciolabores.setText("");
							tfestado.setText("");
							break;
						}
						case 2:{
							tfcedula.setText("");
							tfnombre.setText("");
							tfapellido.setText("");
							tfdireccion.setText("");
							tfespecialidad.setText("");
							tfechainiciolabores.setText("");
							tfestado.setText("");
							break;}
						}
					
					}
					
					}
					
				
				
			JOptionPane.showMessageDialog(btncrear, "Registro Creado");
			}
		}});
		btncrear.setBounds(279, 25, 145, 23);
		contentPane.add(btncrear);
	
		
		
		
		JButton btnbuscar = new JButton("Buscar Registro");
		btnbuscar.setFocusPainted(false);
		btnbuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_TAB) {
					btncrear.requestFocus();
		        }
			}
		});
		btnbuscar.setFocusTraversalKeysEnabled(false);
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			manejoarchivo mng = new manejoarchivo();
			tfestado.setText("");
			
			if(mng.existearchivo()==true) {
				
				int indice = mng.buscarregistro(tfcedula.getText().toString());
			if(indice==-1) {
					JOptionPane.showConfirmDialog(btnbuscar, "elemento no encontrado, mejor cree este registro");
							}
			else {
				
				if(mng.arrlist.get(indice).esborrado==true) {
					tfestado.setText("Registro eliminado");
					JOptionPane.showMessageDialog(btnbuscar, "Editar los campos y despues recuerde guardar con el boton actualizar registro");
															}
				else {
					JOptionPane.showConfirmDialog(btnbuscar, "podra visualizar lo buscado de la persona "+mng.arrlist.get(indice).getNombre()+ " , si modifica recuerde guardar con el boton actualizar registro");
					tfcedula.setText(mng.arrlist.get(indice).getIdcedula());
					tfnombre.setText(mng.arrlist.get(indice).getNombre());
					tfapellido.setText(mng.arrlist.get(indice).getApellido());
					tfdireccion.setText(mng.arrlist.get(indice).getDireccion());
					tfespecialidad.setText(mng.arrlist.get(indice).getEspecialidad());
					tfechainiciolabores.setText(mng.arrlist.get(indice).getFechainiciolabor());
					tfestado.setText("al modificar algo presione el boton actualizar, sino no haga nada");
				}
				
			}
			}else {tfestado.setText("archivo no encontrado, rellena el formulario y crea un nuevo registro");}
			}
		//finaccion btnbuscar
			});
		btnbuscar.setBounds(279, 0, 145, 23);
		contentPane.add(btnbuscar);
		
		JLabel lblapellido = new JLabel("Apellido:");
		lblapellido.setBounds(10, 56, 79, 14);
		contentPane.add(lblapellido);
		
		tfapellido = new JTextField();
		tfapellido.setBounds(134, 56, 115, 20);
		contentPane.add(tfapellido);
		tfapellido.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("LIMPIAR CAMPOS");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_TAB) {
					btnbuscar.requestFocus();
		        }
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfcedula.setText("");
				tfnombre.setText("");
				tfapellido.setText("");
				tfdireccion.setText("");
				tfespecialidad.setText("");
				tfechainiciolabores.setText("");
				tfestado.setText("");
			}
		});
		btnNewButton_1.setBounds(143, 189, 130, 58);
		contentPane.add(btnNewButton_1);
	}


	/**
	 * este metodo borra los fields del frame
	 */
	public void borrarfields() {
		
		tfcedula.setText("");
		tfnombre.setText("");
		tfapellido.setText("");
		tfdireccion.setText("");
		tfespecialidad.setText("");
		tfechainiciolabores.setText("");
		tfestado.setText("");
	}
	

}
