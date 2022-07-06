package objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import conexion.conex;

//esta clase contiene las sentencias sql que seran establecidas en el statement y que seran interpretadas por la libreria java.sql.*
public class Variablesql {

	Connection connect = null;
    PreparedStatement statement = null;
    
    ResultSet rs;
    
    String cedula;
	String nombre;
	String apellido;
	int peso;
	double estatura;
	
	public  miembros2 p = new miembros2(cedula, nombre, apellido, peso, estatura);
	
	
	public static ArrayList<miembros2> result = new ArrayList<miembros2>();
    static Vector<Object> columNames = new Vector<Object>();
    static Vector<Object> data = new Vector<Object>();
    static int columns;
    	
	

	//metodo para truncar y obtener lo relacionado a los limites de la base de datos
	//recordar que la base de datos tiene limite en sus campos.
	
    public String truncar(String var, int largo) {
		if(var.length() > largo) {
			return var.substring(0, largo);
		}
		else {
			return var;	
		}
	}
    
    
	public miembros2 buscar(String cedula) {
		result.clear();
		try {
			//miembros2 p = new miembros2();
			PreparedStatement ps = conex.getConnection().prepareStatement("select * from miembros2 where cedula=?");
			ps.setString(1, cedula);
			ResultSet rs = ps.executeQuery();
			conex.getConnection().close();
			
			while (rs.next()) {
				result.add(new miembros2(rs.getString("cedula"),rs.getString("nombre"),rs.getString("apellido"),rs.getInt("peso"),rs.getDouble("estatura")));
				
				//p no debe existir no funciona este objeto para una jtable
				p.setCedula(rs.getString("cedula"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setPeso(rs.getInt("peso"));
				p.setEstatura(rs.getDouble("estatura"));
			}
			
			return p;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
    

	
	
	public void listar() {

		try {
			result.clear();
			PreparedStatement ps = conex.getConnection().prepareStatement("select * from miembros2;");
			ResultSet rs = ps.executeQuery();
			conex.getConnection().close();
			while (rs.next()) {
				result.add(new miembros2(rs.getString("cedula"),rs.getString("nombre"),rs.getString("apellido"),rs.getInt("peso"),rs.getDouble("estatura")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	//insertar en la base de datos
	public void insertar(String cedula,String nombre,String apellido,int peso,double estatura) {
		//debe limpiar los espacios en blanco
		String res=cedula.replace(" ", "");
		cedula=res;
		//se piensa que actualiza cuando ya existe el registro con la misma cedula
		String sql="INSERT INTO `miembros2` (cedula,nombre,apellido,peso,estatura) VALUES('"+cedula+"','"+nombre+"','"+apellido+"',"+peso+","+estatura+") ON DUPLICATE KEY UPDATE nombre='"+nombre+"',apellido='"+apellido+"',peso="+peso+",estatura="+estatura+";";
		//String sql="INSERT INTO `miembros2`(cedula,nombre,apellido,peso,estatura) values("+cedula+","+nombre+","+apellido+","+peso+","+estatura+");";
		
		try {
			PreparedStatement ps = conex.getConnection().prepareStatement(sql);
			ps.executeUpdate();
			conex.getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//actualizar en la base de datos pero solo la fila de la cedula especificada
	public String actualizar(String cedula,String nombre,String apellido,int peso,double estatura) {
		String result=cedula.replace(" ", "");
		cedula=result;
		String sql="UPDATE `miembros2` SET nombre="+nombre+", apellido="+apellido+", peso="+peso+", estatura="+estatura+"WHERE cedula="+cedula+";";
		return sql;
	}
	
	public void eliminar(String cedula) {
		String result=cedula.replace(" ", "");
		cedula=result;
		try {
			PreparedStatement ps = conex.getConnection().prepareStatement("delete from miembros2 where cedula=?");
			ps.setString(1, cedula);
			ps.executeUpdate();
		}
	 catch (Exception e) {
		e.printStackTrace();
	 		}
	}
	
	public String buscarced(String cedula) {
		String result=cedula.replace(" ", "");
		cedula=result;
		String sql = "Select * from `miembros2` where cedula=";
		sql+=cedula+";";
		return sql;
	}
	
	public String buscarnombre(String nombre) {
		String sql = "Select * from `miembros2` where nombre=";
		sql+=nombre+";";
		return sql;
	}
	
	
}