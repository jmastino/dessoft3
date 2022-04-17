//objeto cuadrado figura geometrica
public class Cuadrado extends Figura{

	double base;
	double altura;
	
	public Cuadrado(String colorrelleno, String colorlinea,double base, double altura) {
		super(colorrelleno, colorlinea);
		this.base = base;
		this.altura = altura;
	}
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	
	//presta atencion aca son los metodos del objeto
	
	public double calcularArea(double base,double altura) {
		double area;
		area=base*altura;	
		
		//System.out.println("el area del cuadrado es: "+area);
		return area;
	}
	
	//este metodo solo calcula dada las variables base y altura de un cuadrado
	public double calcularPerimetro(double base,double altura) {
		double per=0;
		per=(2*base)+(2*altura);
		return per;
	}
}
