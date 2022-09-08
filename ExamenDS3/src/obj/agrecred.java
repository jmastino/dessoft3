package obj;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class agrecred extends JFrame {

	private JPanel contentPane;
	private JTextField tfcedula;
	private JTextField tfsaldoant;
	private JTextField tfañadirsaldo;
	private JTextField tfnombre;
	private JTextField tfapellido;

	/**
	 * Create the frame.
	 */
	public agrecred() {
		setTitle("AGREGAR CREDITO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Créditos a un cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 0, 232, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula");
		lblNewLabel_1.setBounds(-10008, -10031, 424, 251);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cédula:");
		lblNewLabel_2.setBounds(22, 48, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		tfcedula = new JTextField();
		tfcedula.setBounds(83, 45, 123, 20);
		contentPane.add(tfcedula);
		tfcedula.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Saldo anterior:");
		lblNewLabel_3.setBounds(22, 129, 97, 14);
		contentPane.add(lblNewLabel_3);
		
		tfsaldoant = new JTextField();
		tfsaldoant.setEditable(false);
		tfsaldoant.setBounds(104, 126, 86, 20);
		contentPane.add(tfsaldoant);
		tfsaldoant.setColumns(10);
		
		tfañadirsaldo = new JTextField();
		tfañadirsaldo.setBounds(104, 157, 86, 20);
		contentPane.add(tfañadirsaldo);
		tfañadirsaldo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Añadir saldo:");
		lblNewLabel_4.setBounds(10, 160, 87, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Agregar Crédito");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManejoSQL mnj = new ManejoSQL();
				mnj.creartable();
				mnj.cli.setIdcedula(tfcedula.getText().replace(" ", ""));
				mnj.buscarcliced(mnj.cli);
				mnj.agregarcred(ManejoSQL.arrcli.get(0).getSaldos().toString(),tfañadirsaldo.getText(), mnj.cli.getIdcedula());
				JOptionPane.showMessageDialog(btnNewButton, "Se Registro Completamente el nuevo credito");
				
			}
		});
		btnNewButton.setBounds(210, 157, 126, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre:");
		lblNewLabel_5.setBounds(10, 82, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		tfnombre = new JTextField();
		tfnombre.setEditable(false);
		tfnombre.setBounds(83, 73, 123, 20);
		contentPane.add(tfnombre);
		tfnombre.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido:");
		lblNewLabel_6.setBounds(20, 107, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		tfapellido = new JTextField();
		tfapellido.setEditable(false);
		tfapellido.setBounds(83, 98, 123, 20);
		contentPane.add(tfapellido);
		tfapellido.setColumns(10);
		
		JButton btnbuscarced = new JButton("Mostrar Datos");
		btnbuscarced.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ManejoSQL mnj = new ManejoSQL();
			mnj.cli.setIdcedula(tfcedula.getText().replace(" ", ""));
			
			mnj.buscarcliced(mnj.cli);
			tfnombre.setText(ManejoSQL.arrcli.get(0).getNombre());
			tfapellido.setText(ManejoSQL.arrcli.get(0).getApellido());
			tfsaldoant.setText(ManejoSQL.arrcli.get(0).getSaldos().toString());
			
			
			}
		});
		btnbuscarced.setBounds(226, 44, 123, 23);
		contentPane.add(btnbuscarced);
	}

}
