package ejercicio3;

public class CalcularAreas {

	float pi=3.141592f; //pedir el radio mayor 0
	double area=0,radio;
	double base,altura;
	
	
	public double Circulo(float radio) 
		{
		area=(pi*Math.pow(radio,2));
		return area;
		}
	
	
	
	public double triangulo(double base,double altura) {
		area=(base*altura)/2;
		return area;
	}
	
	
	public double cuadrado(double base, double altura) 
	{
		area=base*altura;
	return area;
	}
	
}
