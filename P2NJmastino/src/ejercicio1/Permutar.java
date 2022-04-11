package ejercicio1;

/*
 * Materia: desarrollo de software III
 * Profesor: Andy Gomez de la Torre
 * Nombre del Proyecto: P2NJmastino
 * Programador: Jordy Mastino
 * Descripcion del Programa: este programa realiza permutacion dada la introduccion de 4 numeros o 4 letras
 * 
 * podria permutar mas items pero iterativamente aumenta el tiempo de ejecucion por su tamaño factorial de caracteres ingresados N!
 * DISCLAIMER: si las 4 ingresada son lo mismo y no DEBERIA ya que son iguales, este repite hasta n! el tamaño de lo ingresado 
 * por ejemplo "AAAA" las hara tal cual por indice de arreglo (array) utilizo metodos para covertir a vector por caracter
 */

import javax.swing.JOptionPane;

public class Permutar{
	
	
	public static void main(String[] args) {
		
		int opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			while (opcion == 0)
			{
				String entrada;
				entrada = JOptionPane.showInputDialog(null, "ingrese 4 letras o numeros juntos luego apriete enter");
				char arreglo[]= entrada.toCharArray();
				imprimepermutacion(arreglo, 0, arreglo.length);
				System.out.println("=========================================================================");
				opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
						"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			}
	}

	private static void imprimepermutacion(char[] arreglo, int inicioindice, int finindice) {
		
		if (inicioindice == finindice)//alcanzado el final de la recursion, imprime el estado del arreglo
	       System.out.println(new String(arreglo));
	    else {
	        //intenta mover de un indice a otro indice
	        //ejemplo 0 al tamaño del arreglo-1
	        for (int x = inicioindice; x < finindice; x++) {
	            cambio(arreglo, inicioindice, x);
	            imprimepermutacion(arreglo, inicioindice + 1, finindice);
	            cambio(arreglo, inicioindice, x);
	        }
	    }

	}

	private static void cambio(char[] arreglo, int i, int x) {
	    char t = arreglo[i];
	    arreglo[i] = arreglo[x];
	    arreglo[x] = t;
	}
}