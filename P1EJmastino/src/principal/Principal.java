package principal;

import java.util.Scanner;

import metodos.Numerosdouble;

/*
 * Materia: desarrollo de software III
 * Profesor: Andy Gomez de la Torre
 * Nombre del Proyecto: P1EJmastino
 * Programador: Jordy Mastino
 * Descripción del Programa: este programa Calcular el mayor de tres números.
 * clase para el desarrollo e iinvocacion de los objetos
 */

public class Principal {

	public static void main(String[] args) {
		Principal classhere = new Principal();
		metodos.Numerosdouble llamarmetodo = new Numerosdouble();
		//establece el valor a los atributos
		llamarmetodo.setA(classhere.entrada());
		llamarmetodo.setB(classhere.entrada());
		llamarmetodo.setC(classhere.entrada());
		
		//almacena el valor del mayor retornado del metodo de la clase Numerosdouble
		double mayor = llamarmetodo.calcular_mayor();
		System.out.println("El mayor numero de los 3 es: "+mayor);
	}
	
	/**<p>Es un metodo para ingresar un numero Double a la variable que desees devolver el valor al objeto</p>
	 * @param none
	 * @return el numero leido
	 */
	public double entrada(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un numero: ");
		double numero = sc.nextDouble();
		return numero;
	}
}
