package tiendamascotas;

public class Gato implements Mascota {
	
	private final String[] categoria= {"sinpelo","pelocorto","pelolargo"};
	private final String[] rsinpelo= {"esfinge", "elfo","donskoy"};
	private final String[] rpelocorto= {"azul ruso, británico, manx","devon rex"};
	private final String[] rpelolargo= {"angora","himalayo", "balinés"};
	
	
	public float alturasalto=0.00f;
	public float longitudsalto=0.00f;
	
	
	
	public String mostraratributos()
			{		String creado ="";
			
			creado = "El nombre es: "+Gato.Nombre+"Su edad es: "+Gato.edad+"\nEl color es: "+Gato.color;
			return creado;}
	@Override
	public String Sonido() {
		String carlos = "Los gatos maúllan y ronronean";
	return carlos;
	}
	
}
