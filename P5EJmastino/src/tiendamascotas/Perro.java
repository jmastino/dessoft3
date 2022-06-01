package tiendamascotas;

public class Perro implements Mascota{
	
	private final String[] Tamanio = {"perros pequeños","perros medianos","perros grandes"};
	private final String[] rpequenio = {"caniche","yorkshire terrier","schnauzer","chihuahua"};
	private final String[] rmediano = {"collie","dálmata","bulldog","galgo","sabueso"};
	private final String[] rgrande = {"pastor alemán","doberman","rotweiller"};
	
	public String Tamaño="";
	public String raza="";
	
	private float peso=0.00f;
	private boolean muerde=false;
	
	
	@Override
	public String Sonido() {
	 String carlos = "Los perros ladran";
		return carlos;
	}
	
 	public void mostraratr() {
 		System.out.println(Perro.Nombre+Perro.edad+Perro.color);
 	}
	
}
