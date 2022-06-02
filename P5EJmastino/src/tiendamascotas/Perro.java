package tiendamascotas;

public class Perro implements Mascota{
	
	/*
	private final String[] Tamanio = {"perros pequeños","perros medianos","perros grandes"};
	private final String[] rpequenio = {"caniche","yorkshire terrier","schnauzer","chihuahua"};
	private final String[] rmediano = {"collie","dálmata","bulldog","galgo","sabueso"};
	private final String[] rgrande = {"pastor alemán","doberman","rotweiller"};
	* estas constantes no son necesarias son solo una comentario para saber a que atributos posibles debe contener el objeto
	*/
	
	public String Nombre;
	public String edad;
	public String color;
	
	
	public String tamano;
	public String raza;
	public float peso;
	public boolean muerde;
	
public Perro() {
	this.Nombre = Nombre;
	this.edad= edad;
	this.color = color;
	
	this.tamano = tamano;
	this.raza = raza;
	this.peso = peso;
	this.muerde = muerde;
	}
	
	public String mostraratr() {
		String texto="El nombre del Perro: "+Nombre+" La edad: "+edad+"\tSu Color: "+color;
		String ff="";
		if(muerde==true) {
			ff="Si";
		}
		if(muerde==false) {
			ff="No";
		}
		
		texto+="\nEl tamaño: "+tamano+"\tSu Raza: "+raza+"\nPeso: "+peso+"\n¿El perro muerde?: "+ff;
 		return texto;
 	}
	
	
	@Override
	public String Sonido() {
	 String carlos = "¡Los perros ladran!";
		return carlos;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public boolean isMuerde() {
		return muerde;
	}

	public void setMuerde(boolean muerde) {
		this.muerde = muerde;
	}
	
 	
	
}
