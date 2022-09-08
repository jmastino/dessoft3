package tiendamascotas;

public class Gato implements Mascota {
	
	/*
	private final String[] categoria= {"sinpelo","pelocorto","pelolargo"};
	private final String[] rsinpelo= {"esfinge", "elfo","donskoy"};
	private final String[] rpelocorto= {"azul ruso, británico, manx","devon rex"};
	private final String[] rpelolargo= {"angora","himalayo", "balinés"};
	* estas constantes no son necesarias son solo una comentario para saber a que atributos posibles debe contener el objeto 
	*/
	
	public String Nombre;
	public String edad;
	public String color;
	
	public String categoria;
	public String raza;
	public float alturasalto;
	public float longitudsalto;
	
	
	public Gato() {
		this.Nombre = Nombre;
		this.edad= edad;
		this.color=color;
		
		this.categoria = categoria;
		this.raza = raza;
		this.alturasalto= alturasalto;
		this.longitudsalto= longitudsalto;
	}
	
	public String mostraratributos()
			{		String creado;
			
			creado = "El nombre es: "+Nombre+"\tSu edad es: "+edad+"\nEl color es: "+color;
			
			creado +="\nLa altura del salto es: "+alturasalto+"\nLa longitud del salto es: "+longitudsalto;
			return creado;
			}
	
	@Override
	public String Sonido() {
		String carlos = "¡Los gatos maúllan y ronronean!";
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public float getAlturasalto() {
		return alturasalto;
	}

	public void setAlturasalto(float alturasalto) {
		this.alturasalto = alturasalto;
	}

	public float getLongitudsalto() {
		return longitudsalto;
	}

	public void setLongitudsalto(float longitudsalto) {
		this.longitudsalto = longitudsalto;
	}
	
}
