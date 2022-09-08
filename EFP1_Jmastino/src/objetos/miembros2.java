package objetos;
//clase para los atributos a insertar en la base de datos mysql
public class miembros2 {

	String cedula;
	String nombre;
	String apellido;
	int peso;
	double estatura;
	
	
	
	public miembros2(String cedula,String nombre, String apellido,int peso,double estatura){
		super();
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido=apellido;
		this.peso=peso;
		this.estatura=estatura;
	}
	
	public miembros2() {
		super();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public double getEstatura() {
		return estatura;
	}


	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	
	
}
