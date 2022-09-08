package principal;

import java.util.ArrayList;
import java.util.Scanner;
import objetos.Calcularmetodos;
/*
 * Materia: desarrollo de software III
 * Profesor: Andy Gomez de la Torre
 * Nombre del Proyecto: EP1EJmastino1  (Examen Parcial 1 ejercicio 1)
 * Programador: Jordy Mastino
 * Descripción del Programa: este programa recibe la intrduccion por consola de los elementos numeros
 * al final debe imprimir 
 * •	mayor número introducido
		 *	•	menor número introducido
		 *	•	suma de todos los números
		 *	•	promedio de todos los números 
 */


public class Principal {
	public static ArrayList<Integer> s = new ArrayList<Integer>();

	//metodo de invocacion de ejecucion
	public static void main(String[] args) {
		Calcularmetodos calc = new Calcularmetodos();
		int num=0; //variable a introducir en la coleccion de objetos
		
		do { Principal pr = new Principal();
			num =pr.metodolectura();
			if(num!=0) {
			s.add(num);
			}
		}
		while (num!=0);
	System.out.println("");	
	calc.calcularmayor();   //metodo retorna impresion en consola
	calc.calcularmenor();	//metodo retorna impresion en consola
	System.out.println("La suma de los elementos es: "+calc.sumaelementos());
	System.out.println("El Promedio de los elementos es: "+calc.promedioelmentos());
	
	
	System.out.println("\n\n\n-FIN DEL PROGRAMA-");
	}
	
	public int metodolectura() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un numero...:");
		int num =sc.nextInt();
		return num;
	}
}