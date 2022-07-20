package conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class conex {
	
    private static String url = "jdbc:mysql://localhost:3306/examends3";
    private static String username = "";
    private static String passwd = "";
    public static Hashtable<String, String> logininformation = new Hashtable<String, String>();
    static Exception estadocon;
    
    //para la obtencion de resultados de la tabla BD
    
public static Connection getConnection() {
		
		Connection con = null;
		//pasa los parametros a unas variables de cadena
		username=logininformation.get("user");
		passwd=logininformation.get("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//con = DriverManager.getConnection(conex.url,conex.username,conex.passwd);
			con = DriverManager.getConnection(conex.url,username,passwd);
			
		} catch (Exception e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e, "Algun problema ocurrió en la conexión a la base de datos", 0, null);
			conex.estadocon=e;
			con = null;
		}
		
		return con;
		
	}
    	
}