package tiendamascotas;

public class Gato implements Mascota {
	
	/*
	private final String[] categoria= {"sinpelo","pelocorto","pelolargo"};
	private final String[] rsinpelo= {"esfinge", "elfo","donskoy"};
	private final String[] rpelocorto= {"azul ruso, británico, manx","devon rex"};
	private final String[] rpelolargo= {"angora","himalayo", "balinés"};
	* estas constantes no son necesarias son solo una comentario para saber a que atributos posibles debe contener el objeto 
	*/
	
	public float alturasalto;
	public float longitudsalto;
	
	public String mostraratributos()
			{		String creado ="";
			
			creado = "El nombre es: "+Gato.Nombre+"Su edad es: "+Gato.edad+"\nEl color es: "+Gato.color;
			
			creado +="\nLa altura del salto es: "+alturasalto+"La longitud del salto es: "+longitudsalto;
			return creado;
			}
	
	@Override
	public String Sonido() {
		String carlos = "Los gatos maúllan y ronronean";
	return carlos;
	}
	
}
