package conexion;
import java.sql.*;

public class conex {
	
    private static String url = "jdbc:mysql://localhost:3306/mydb";
    private static String username = "adminuser";
    private static String passwd = "adminuser2022";
    static Exception estadocon;
    
    //para la obtencion de resultados de la tabla BD
    
public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(conex.url,conex.username,conex.passwd);
		} catch (Exception e) {
			e.printStackTrace();
			conex.estadocon=e;
			con = null;
		}
		
		return con;
		
	}
    	
}