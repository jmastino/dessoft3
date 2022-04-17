//clase para la forma de circulo provee metodos para calcular su area y su perimetro
public class Circulo extends Figura{

	private double radio;
	
	
	public Circulo(String colorrelleno, String colorlinea,double radio) {
		super(colorrelleno,colorlinea);
		this.radio = radio;
	}
		
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}


	/*
	 * el metodo imprime area de un circulo.
	 */
	public double calcularArea(double radio) {
		double area;
		float pi = 3.14f;
		area=(pi*Math.pow(radio,2));
		return area;
		//System.out.println("el area del circulo es: "+area);
	}
	/*
	 * el metodo imprime el perimetro de un circulo.
	 */
	public double calcularPerimetro(double radio) {
		double per;
		float pi = 3.14f;
		per=2*pi*radio;
		return per;
		//System.out.println("El perimetro del circulo es: "+per);
		
	}
}
