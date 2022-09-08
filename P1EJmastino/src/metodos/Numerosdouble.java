package metodos;

public class Numerosdouble {

	double a;
	double b;
	double c;
	
	/*    definir herencia o no en la clase sobrecarga de metodos
	public Numerosdouble(double a,double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	*/
	
	//methodo imprime en consola los atributos de la clase
	public void mostraratributos()
	{
		System.out.println("valor de a: "+a+" Valor de b: "+b+"VAlor de c: "+c);
	}
	
	//metodo para calcular el mayor de los tres numeros dados usando los operadores ternarios.
	public double calcular_mayor() {
		//comparando el valor de a y b y almacenandolo en una variable.
		double temp=a>b?a:b;
		//comparando el numero temporal para el tercero dado. 
		double largest = c>temp?c:temp;
		return largest;
	}
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	
}
