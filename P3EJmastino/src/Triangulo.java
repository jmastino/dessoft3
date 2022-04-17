//esta clase contiene metodos y atributos para la forma de triangulo, se le define atributos y metodos para calcular area y perimetro.
public class Triangulo extends Figura{

	double lado1;
	double lado2;
	double lado3;
	int tipotrian;
	
	
	public Triangulo(String colorrelleno,String colorlinea,double lado1,double lado2,double lado3,int tipotrian) {
		super(colorrelleno, colorlinea);
				this.lado1 = lado1;
				this.lado2 = lado2;
				this.lado3 = lado3;
				this.tipotrian= tipotrian;
	}
	
	
	public double getLado1() {
		return lado1;
	}
	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}
	public double getLado2() {
		return lado2;
	}
	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	public double getLado3() {
		return lado3;
	}
	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}
	
	public int getTipotrian() {
		return tipotrian;
	}
	public void setTipotrian(int tipotrian) {
		this.tipotrian = tipotrian;
	}



	//metodos para calcular el area y perimetro de los triangulos
	public double calcularArea(double lado1,double lado2, double lado3) {
		double area=0;
		//debe ignorar el mayor de los lados el cual se considera la hipotenusa en el triangulo rectangulo 
			if(lado1==lado2&&lado2==lado3&&lado1==lado3) {
				double base=lado1; 
				double altura=lado2;
				area=(base*altura)/2;
		}
		if(lado1>lado2&&lado1>lado3) {
			double base=lado2; 
			double altura=lado3;
			area=(base*altura)/2;
		}
		if(lado2>lado1&&lado2>lado3) {
			double base=lado1;
			double altura=lado3;
			area=(base*altura)/2;
		}
		if(lado3>lado1&&lado3>lado2)
		{
			double base=lado2; 
			double altura=lado1;
			area=(base*altura)/2;
		}
		return area;
		//System.out.println("El area del triangulo es: "+area);	
	}
	
	
	//en la variable tipotriang 0 = equilatero 1= isoceles 2 = escaleno
	
	public double calcularPerimetro(double lado1, double lado2 , double lado3, int tipotrian) {
		//triangulo equilatero
		double per=0;
		if(tipotrian==0) {
			per=3*lado1;
		}
		//triangulo isoceles
		if(tipotrian==1) {
			
			if(lado1==lado2){
				//quiere decir que la base es el lado3
				per=2*lado1+lado3;
			}
			
			if(lado2==lado3){
				//quiere decir que la base es el lado1
				per=2*lado2+lado1;
			}
			
			if(lado3==lado1){
				//quiere decir que la base es el lado2
				per=2*lado1+lado2;
			}
			
		}
		//triangulo escaleno
		if(tipotrian==2) {
			per=lado1+lado2+lado3;
			
		}
		return per;
		// debe retornar no imprimir en consola
		//System.out.println("El perimetro del triangulo es: "+per);
	}
	
}
