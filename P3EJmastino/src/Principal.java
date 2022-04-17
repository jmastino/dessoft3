import javax.swing.JOptionPane;

/*
	 * Materia: desarrollo de software III
	 * Profesor: Andy Gomez de la Torre
	 * Nombre del Proyecto: P3EJmastino
	 * Programador: Jordy Mastino
	 * Descripción del Programa: este programa realiza calculo de area de figuras geometricas y el perimetro 
	 * seleccionadas se ejemplifica la lección del modulo dos (2) de contenido de la asignatura
	 * 
	 * clase para el desarrollo e iinvocacion de los objetos
	 * 
	 */
public class Principal {
	
	public static void main(String[] args) {
		//opcion y demas se utiliza como control de ejecucion de la aplicacion (ciclo de vida de la aplicacion)
		int opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			while (opcion == 0)
			{
				int op=0; //para escoger de un menu
				op = JOptionPane.showOptionDialog(null,
						"seleccione la operacion","calcular areas de figuras geometricas",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null,
						new Object[] {"Figura","Circulo", "Cuadrado", "Triangulo"}," ");
				
				switch(op){
                case 0:{ 	
                	//el objeto figura tiene dos atributos y un metodo
                	JOptionPane.showMessageDialog(null , "En este menu ingresa los datos para el objeto Figura");
                	String coll; //variables para pedir o enviar los atributos de cada objeto (o clase)
                	String colre;
                	coll = JOptionPane.showInputDialog(null, "Ingrese Color de linea de la figura");
                	colre = JOptionPane.showInputDialog(null, "Ingrese color de relleno");
                	Figura fig = new Figura(colre,coll);  //llamado a invocacion al objeto
                	fig.setColorlinea(coll);
                	fig.setColorrelleno(colre);
                	JOptionPane.showMessageDialog(null ,"El color de relleno de la figura es: "+fig.getColorrelleno()+"\nEl color de linea para la figura es: "+fig.getColorlinea());
                	break;}
                case 1:{
                	double radio; //la figura del circulo tiene atributos 
                	String coll;
                	String colre;
                	JOptionPane.showMessageDialog(null , "En este menu ingresa el dato del circulo se solicita ingrese los datos del circulo");
                	coll = JOptionPane.showInputDialog(null, "Ingrese Color de linea de la figura");
                	colre = JOptionPane.showInputDialog(null, "Ingrese color de relleno");
                	radio = Float.parseFloat(JOptionPane.showInputDialog(null, "ingrese el radio del circulo"));
                	Circulo cir = new Circulo(colre,coll,radio);
                	cir.setColorlinea(coll);
                	cir.setColorrelleno(colre);
                	cir.setRadio(radio);
                	double a= cir.calcularArea(radio);
                	double p= cir.calcularPerimetro(radio);
                	JOptionPane.showMessageDialog(null,"el color de relleno es: "+cir.getColorrelleno()+"\nel color de linea es: "+cir.getColorlinea()+"\nEl area del circulo es: "+a+"\nEl perimetro del circulo es: "+p);
                	break;}
                case 2:{
                	double base,altura;
                	String coll;
                	String colre;
                	JOptionPane.showMessageDialog(null , "En este menu ingresa el dato del cuadrado se solicita ingrese los datos del cuadrado");
                	coll = JOptionPane.showInputDialog(null, "Ingrese Color de linea de la figura");
                	colre = JOptionPane.showInputDialog(null, "Ingrese color de relleno");
                	base = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese la base del cuadrado"));
                	altura = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese la altura del cuadrado"));
                	Cuadrado cua = new Cuadrado(colre,coll,base,altura);
                	cua.setColorlinea(coll);
                	cua.setColorrelleno(colre);
                	cua.setAltura(altura);
                	cua.setBase(base);
                	double a= cua.calcularArea(base, altura);
                	double p= cua.calcularPerimetro(base,altura);
                	JOptionPane.showMessageDialog(null , "El color de relleno es: "+cua.getColorrelleno()+"\nEl color de linea es: "+cua.getColorlinea());
                	JOptionPane.showMessageDialog(null , "El area del cuadrado es: "+a+"\nEl perimetro del cuadrado es: "+p);
                	
                	break;}
                case 3: {
                	
                	double lado1,lado2,lado3;
                	int tipotrian;
                	String coll;
                	String colre;
                	JOptionPane.showMessageDialog(null , "En este menu ingresa el dato del triangulo se solicita ingrese los datos del triangulo");
                	coll = JOptionPane.showInputDialog(null, "Ingrese Color de linea de la figura");
                	colre = JOptionPane.showInputDialog(null, "Ingrese color de relleno");
                	tipotrian= JOptionPane.showOptionDialog(null,"Seleccione el tipo de triangulo","Escoger el triangulo dado su tipo y tamaños de lados",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Equilatero", "Isoceles", "Escaleno"}," ");
                	lado1 = Float.parseFloat(JOptionPane.showInputDialog(null, "ingrese el lado1 del Triangulo"));
                	lado2 = Float.parseFloat(JOptionPane.showInputDialog(null, "ingrese el lado2 del triangulo"));
                	lado3 = Float.parseFloat(JOptionPane.showInputDialog(null, "ingrese el lado3 del triangulo"));
                	
                	Triangulo tri = new Triangulo(colre, coll, lado1, lado2, lado3, tipotrian);
                	tri.setColorlinea(coll);
                	tri.setColorrelleno(colre);
                	tri.setLado1(lado1);
                	tri.setLado1(lado2);
                	tri.setLado1(lado3);
                	tri.setTipotrian(tipotrian);
                	double a= tri.calcularArea(lado1, lado2, lado3);
                	double p= tri.calcularPerimetro(lado1, lado2, lado3, tipotrian);
                	JOptionPane.showMessageDialog(null , "El area del Triangulo es: "+a);
                	JOptionPane.showMessageDialog(null , "El perimetro del Triangulo es: "+p);
                	
                	break;}
				default: {JOptionPane.showMessageDialog(null, "No es una opción valida!!!");}
				}
	
opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
		
			}
		
	}

}
