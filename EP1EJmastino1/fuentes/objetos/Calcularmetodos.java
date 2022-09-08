package objetos;

import principal.Principal;

public class Calcularmetodos {
	/*
	 * metodo para la suma o resta de los objetos.
	 */
 public void calcularmayor() {
	 Principal.s.sort(null);
	 System.out.println("El numero Mayor es: "+Principal.s.get((Principal.s.size()-1)));
	 
 }
 public void calcularmenor() {
	 Principal.s.sort(null);
	 System.out.println("El numero Menor es: "+Principal.s.get(0));
	 
 }
 public int sumaelementos() {
	 int suma=0;
	 for(int i=0;i<Principal.s.size();i++) {
		 suma+=Principal.s.get(i);
	 }
	 return suma;
 }
 public int promedioelmentos() {
	 Calcularmetodos cl = new Calcularmetodos();
	 int prom = (int)(cl.sumaelementos()/Principal.s.size());
	 return prom;
 }
}