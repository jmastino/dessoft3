package conexion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objetos.Variablesql;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel paneldeframe;
	static JTextField tfcedula;
	static JTextField tfnombre;
	static JTextField tfapellido;
	static JTextField tfpeso;
	static JTextField tfestatura;
	static JTextField tfestadocon;
	static JButton btnbuscar = new JButton("Buscar");

	//lamar las clases con sus metodos de activacion
	objetos.Variablesql sql = new Variablesql();
	
	//dato model y dato table
	DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Lanza la aplicación.
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
	 * Crea el frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/conexion/scale-vector-icon-removebg-preview.png")));
		setTitle("Servicio Peso y Talla (Datos)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 439);
		paneldeframe = new JPanel();
		paneldeframe.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(paneldeframe);
		paneldeframe.setLayout(null);
		
		JLabel lblcedula = new JLabel("Cedula:");
		lblcedula.setBounds(10, 11, 75, 14);
		paneldeframe.add(lblcedula);
		
		tfcedula = new JTextField();
		tfcedula.setBounds(83, 8, 100, 20);
		paneldeframe.add(tfcedula);
		tfcedula.setColumns(10);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setBounds(207, 11, 75, 14);
		paneldeframe.add(lblnombre);
		
		tfnombre = new JTextField();
		tfnombre.setBounds(257, 8, 140, 20);
		paneldeframe.add(tfnombre);
		tfnombre.setColumns(10);
		
		JLabel lblapellido = new JLabel("Apellido:");
		lblapellido.setBounds(10, 45, 63, 14);
		paneldeframe.add(lblapellido);
		
		tfapellido = new JTextField();
		tfapellido.setBounds(83, 42, 100, 20);
		paneldeframe.add(tfapellido);
		tfapellido.setColumns(10);
		
		JLabel lblpeso = new JLabel("Peso:");
		lblpeso.setBounds(207, 39, 46, 14);
		paneldeframe.add(lblpeso);
		
		tfpeso = new JTextField();
		tfpeso.setBounds(257, 36, 100, 20);
		paneldeframe.add(tfpeso);
		tfpeso.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Estatura:");
		lblNewLabel.setBounds(10, 72, 63, 14);
		paneldeframe.add(lblNewLabel);
		
		tfestatura = new JTextField();
		tfestatura.setBounds(83, 69, 100, 20);
		paneldeframe.add(tfestatura);
		tfestatura.setColumns(10);
		
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tfestadocon.setText("");
				if(tfcedula.getText().equals("")) {
				sql.listar();
				model.setRowCount(0);
				for(int i=0;i<Variablesql.result.size();i++) {
					Object[] fila = {
						Variablesql.result.get(i).getCedula(),
						Variablesql.result.get(i).getNombre(),
						Variablesql.result.get(i).getApellido(),	
						Variablesql.result.get(i).getPeso(),	
						Variablesql.result.get(i).getEstatura()
					};
				model.addRow(fila);
				}
			}
			else{sql.buscar(tfcedula.getText());
			model.setRowCount(0);
			for(int i=0;i<Variablesql.result.size();i++) {
				Object[] fila = {
					Variablesql.result.get(i).getCedula(),
					Variablesql.result.get(i).getNombre(),
					Variablesql.result.get(i).getApellido(),	
					Variablesql.result.get(i).getPeso(),	
					Variablesql.result.get(i).getEstatura()
				};
			model.addRow(fila);
			}
			if(Variablesql.result.isEmpty()==false)
			{
			tfnombre.setText(Variablesql.result.get(0).getNombre());
			tfapellido.setText(Variablesql.result.get(0).getApellido());
			tfpeso.setText(Integer.toString(Variablesql.result.get(0).getPeso()));
			tfestatura.setText(Double.toString(Variablesql.result.get(0).getEstatura()));
			}
			else {tfestadocon.setText("¡Registro no existe!");}
			try {
				conex.getConnection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			}
			
			}
		});
		
		btnbuscar.setBounds(20, 97, 89, 23);
		paneldeframe.add(btnbuscar);
		
		JButton btninsertar = new JButton("Insertar");
		btninsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tfestadocon.setText("");
			sql.insertar(tfcedula.getText(), tfnombre.getText(), tfapellido.getText(), Integer.parseInt(tfpeso.getText()), Double.parseDouble(tfestatura.getText()));
			
			//a partir de aqui actualiza el JTable
			
			sql.listar();
			model.setRowCount(0);
			for(int i=0;i<Variablesql.result.size();i++) {
				Object[] fila = {	
			Variablesql.result.get(i).getCedula(),
			Variablesql.result.get(i).getNombre(),
			Variablesql.result.get(i).getApellido(),	
			Variablesql.result.get(i).getPeso(),	
			Variablesql.result.get(i).getEstatura()
				};
				model.addRow(fila);
			}
			JOptionPane.showMessageDialog(btninsertar, "Su registro ha sido Ingresado.");
			try {
				conex.getConnection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				}		
			}
		});//fin accion del boton
		
		btninsertar.setBounds(120, 97, 89, 23);
		paneldeframe.add(btninsertar);
		
		JButton btnactualizar = new JButton("Actualizar");
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfestadocon.setText("");
				sql.insertar(tfcedula.getText(), tfnombre.getText(), tfapellido.getText(), Integer.parseInt(tfpeso.getText()), Double.parseDouble(tfestatura.getText()));
				
				//a partir de aqui actualiza el JTable
				
				sql.listar();
				model.setRowCount(0);
				for(int i=0;i<Variablesql.result.size();i++) {
					Object[] fila = {	
				Variablesql.result.get(i).getCedula(),
				Variablesql.result.get(i).getNombre(),
				Variablesql.result.get(i).getApellido(),	
				Variablesql.result.get(i).getPeso(),	
				Variablesql.result.get(i).getEstatura()
					};
					model.addRow(fila);
				}
				JOptionPane.showMessageDialog(btninsertar, "Su registro ha sido Actualizado.");
				try {
					conex.getConnection().close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					}
			}
		});
		btnactualizar.setBounds(217, 97, 89, 23);
		paneldeframe.add(btnactualizar);
		
		JButton btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tfestadocon.setText("");
				sql.eliminar(tfcedula.getText());
			
			//a partir de aqui actualiza el JTable
			
			sql.listar();
			model.setRowCount(0);
			for(int i=0;i<Variablesql.result.size();i++) {
				Object[] fila = {	
			Variablesql.result.get(i).getCedula(),
			Variablesql.result.get(i).getNombre(),
			Variablesql.result.get(i).getApellido(),	
			Variablesql.result.get(i).getPeso(),	
			Variablesql.result.get(i).getEstatura()
				};
				model.addRow(fila);
			}
			JOptionPane.showMessageDialog(btninsertar, "Su registro ha sido Eliminado.");
			try {
				conex.getConnection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				}
		}
		});
		btneliminar.setBounds(318, 97, 89, 23);
		paneldeframe.add(btneliminar);
		
		tfestadocon = new JTextField();
		tfestadocon.setDisabledTextColor(Color.BLACK);
		tfestadocon.setEditable(false);
		tfestadocon.setBounds(217, 69, 195, 20);
		paneldeframe.add(tfestadocon);
		tfestadocon.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 182, 414, 193);
		paneldeframe.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Cedula");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Peso");
		model.addColumn("Estatura");
		table.setModel(model);
		
		JButton btnlimpiar = new JButton("Limpiar Campos del Formulario");
		btnlimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tfcedula.setText("");
			tfnombre.setText("");
			tfapellido.setText("");
			tfpeso.setText("");
			tfestatura.setText("");
			tfestadocon.setText("");
			}
		});
		btnlimpiar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnlimpiar.setBounds(71, 132, 272, 39);
		paneldeframe.add(btnlimpiar);
		
		JLabel lblNewLabel_1 = new JLabel("Jordy Mastino");
		lblNewLabel_1.setBounds(318, 380, 89, 20);
		paneldeframe.add(lblNewLabel_1);
	}
}