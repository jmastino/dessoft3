package obj;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import conex.conex;

public class ManejoSQL {

	String idcedula;
	String nombre;
	String apellido;
	String direccion;
	String telefono;
	Double saldos;
	Date updated;
	Date created;
	boolean esborrado=false;
	
	public clientes cli =new clientes(idcedula, nombre, apellido, direccion, telefono, saldos, updated, created,esborrado); 
	
	PreparedStatement statement = null;
	ResultSet rs;
	public static ArrayList<clientes> arrcli = new ArrayList<clientes>(); 
	
	public Date insertarhora()
	{  java.util.Date javaDate = new java.util.Date();
    java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());
		
	 return mySQLDate;
	}

	public boolean buscartable() {
	//conex.conex.getConnection();
	boolean b = false;
	
String butable="SELECT COUNT(TABLE_NAME)FROM information_schema.TABLES WHERE TABLE_SCHEMA LIKE 'examends3' AND TABLE_TYPE LIKE 'BASE TABLE' AND TABLE_NAME = 'saldos';";
	try {
		
		statement= conex.getConnection().prepareStatement(butable);
		rs = statement.executeQuery();
		
		while(rs.next()) {
			if(rs.getInt("COUNT(TABLE_NAME)")==1) {
				b=true;
				return b;
			}
			else {return b;}
		}
		statement.close();
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e,"problema En el 'sql' de busqueda de tabla",0,null);
	}
	return b;
	
	}
	
	public void creartable() {
		ManejoSQL mnj = new ManejoSQL();
		if(mnj.buscartable()==false) {
			String butable="CREATE TABLE `saldos` (\r\n"
					+ "  `idcedula` varchar(20) COLLATE utf8_spanish_ci NOT NULL,\r\n"
					+ "  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,\r\n"
					+ "  `apellido` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,\r\n"
					+ "  `direccion` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,\r\n"
					+ "  `telefono` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,\r\n"
					+ "  `saldos` double DEFAULT NULL,\r\n"
					+ "  `updated` date DEFAULT NULL,\r\n"
					+ "  `created` date DEFAULT NULL,\r\n"
					+ "  `esborrado` tinyint NOT NULL,\r\n"
					+ "  PRIMARY KEY (`idcedula`)\r\n"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;";
			try {
			statement = conex.getConnection().prepareStatement(butable);
			statement.executeUpdate();
			statement.close();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e,"Error en funcion de crear o no la tabla",0,null);
			}
			
		}
		
		
	}
	
	public String truncar(String var, int largo) {
		if(var.length() > largo) {
			return var.substring(0, largo);
		}
		else {
			return var;	
		}
	}
	
	
	public void agregarcli(clientes cli) {
		arrcli.clear();
		String ced=cli.getIdcedula().replace(" ", "");
		cli.setIdcedula(ced);
String sql="INSERT INTO `saldos` (idcedula,nombre,apellido,direccion,telefono,saldos,updated,created,esborrado) VALUES('"+cli.getIdcedula()+"','"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getDireccion()+"','"+cli.getTelefono()+"',"+cli.getSaldos()+",?,?,false);";		

	try {
		
		statement = conex.getConnection().prepareStatement(sql);
		statement.setDate(1, cli.getUpdated());
		statement.setDate(2, cli.getCreated());
		statement.executeUpdate();
		//statement.close();
	}catch(Exception e) {JOptionPane.showMessageDialog(null,e, "error al insertar cliente",0,null );}
		
	}

	public void buscarcliced(clientes cli) {
		arrcli.clear();
		String sql="SELECT * FROM saldos where idcedula=?";
		
		try {
			statement = conex.getConnection().prepareStatement(sql);
			statement.setString(1, cli.getIdcedula().toString());
			rs= statement.executeQuery();
			
			
			while(rs.next()) {
				arrcli.add(new clientes(rs.getString("idcedula"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("direccion"),rs.getString("telefono"),rs.getDouble("saldos"),rs.getDate("updated"),rs.getDate("created"),rs.getBoolean("esborrado")));
			}
			statement.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e,"error al buscar entrada de cliente",0,null);
		}
	}
	
	public void agregarcred(String saldoanterior,String saldonuevo,String idcedula) {
		Double saldoanterior2 =Double.parseDouble(saldoanterior);
		Double saldonuevo2= Double.parseDouble(saldonuevo);
		Double suma = saldoanterior2+saldonuevo2;
		String sql= "UPDATE saldos SET saldos="+suma+",updated =? WHERE idcedula='"+idcedula+"';";
		try {
		statement = conex.getConnection().prepareStatement(sql);
		statement.setDate(1, insertarhora());
		statement.executeUpdate();
		statement.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e,"Error en agregar un credito",0,null);
		}
		
	}
	
	
	public void agregarpago(String saldoanterior,String saldonuevo,String idcedula) {
		Double saldoanterior2 =Double.parseDouble(saldoanterior);
		Double saldonuevo2 =Double.parseDouble(saldonuevo);
		Double resta = saldoanterior2-saldonuevo2;
		System.out.println(resta);
		String sql= "UPDATE saldos SET saldos=?,updated =? WHERE idcedula='"+idcedula+"';";
		try {
			statement = conex.getConnection().prepareStatement(sql);
			statement.setDouble(1, resta);
			statement.setDate(2, insertarhora());
			statement.executeUpdate();
			statement.close();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e,"Error en agregar un pago",0,null);
			}
		
	}
	
	
	
}
