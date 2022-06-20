package registromed;
import java.util.Date;
public class Medicos extends idcedulas{

	String nombre;
	String apellido;
	String direccion;
	String especialidad;
	Date fechainiciolabor;
	//formato dd/mm/aaaa
	boolean esborrado;
	//esta variable controla si es borrado por el objetivo de un  borrado lógico y no fisico de la aplicacion
	//requerimiento al valor true es porque ha sido eliminado
	
	
	public Medicos(String idcedula,String nombre,String apellido,String direccion,String especialidad,Date fechainiciolabor,boolean esborrado) {
		super(idcedula);
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion= direccion;
		this.especialidad = especialidad;
		this.fechainiciolabor = fechainiciolabor;
		this.esborrado = esborrado;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public Date getFechainiciolabor() {
		return fechainiciolabor;
	}
	public void setFechainiciolabor(Date fechainiciolabor) {
		this.fechainiciolabor = fechainiciolabor;
	}
	public boolean isEsborrado() {
		return esborrado;
	}
	public void setEsborrado(boolean esborrado) {
		this.esborrado = esborrado;
	}
}
