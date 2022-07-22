package obj;

import java.sql.Date;

public class clientes {

	
	String idcedula;
	String nombre;
	String apellido;
	String direccion;
	String telefono;
	Double saldos=0.00d;
	Date updated;
	Date created;
	boolean esborrado=false;
	
	
	
	
	
	
	public clientes(String idcedula, String nombre, String apellido, String direccion, String telefono, double saldos,
			Date updated, Date created, boolean esborrado) {
		// TODO Auto-generated constructor stub
		this.idcedula=idcedula;
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.telefono=telefono;
		this.saldos=saldos;
		this.updated=updated;
		this.created=created;
		this.esborrado=esborrado;
	}
	
	public String getIdcedula() {
		return idcedula;
	}
	public void setIdcedula(String idcedula) {
		this.idcedula = idcedula;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Double getSaldos() {
		return saldos;
	}
	public void setSaldos(Double saldos) {
		this.saldos = saldos;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public boolean isEsborrado() {
		return esborrado;
	}
	public void setEsborrado(boolean esborrado) {
		this.esborrado = esborrado;
	}
	
	
	
		
	
}
