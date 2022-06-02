package tiendamascotas;

public class Perro implements Mascota{
	
	/*
	private final String[] Tamanio = {"perros pequeños","perros medianos","perros grandes"};
	private final String[] rpequenio = {"caniche","yorkshire terrier","schnauzer","chihuahua"};
	private final String[] rmediano = {"collie","dálmata","bulldog","galgo","sabueso"};
	private final String[] rgrande = {"pastor alemán","doberman","rotweiller"};
	* estas constantes no son necesarias son solo una comentario para saber a que atributos posibles debe contener el objeto
	*/
	public String tamano;
	public String raza;
	private float peso;
	private boolean muerde;
	
	public String mostraratr() {
		String texto="El nombre del Perro: "+Perro.Nombre+"La edad: "+Perro.edad+"Su Color: "+Perro.color;
		String ff;
		if(muerde==true) {ff="Sí";}else {ff="No";}
		texto+="\nel tamaño: "+tamano+"Su Raza: "+raza+"Peso: "+peso+"¿El perro muerde?: "+ff;
 		return texto;
 	}
	
	
	@Override
	public String Sonido() {
	 String carlos = "Los perros ladran";
		return carlos;
	}
	
 	
	
}
