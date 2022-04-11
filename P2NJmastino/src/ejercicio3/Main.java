package ejercicio3;

/*
 * Materia: desarrollo de software III
 * Profesor: Andy Gomez de la Torre
 * Nombre del Proyecto: P2NJmastino
 * Programador: Jordy Mastino
 * Descripcion del Programa: este programa realiza calculo de area de figuras geometricas seleccionadas
 * 
 */


import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		CalcularAreas llam = new CalcularAreas();
		
		int opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
				"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
			while (opcion == 0)
			{
				int op=0;
				double area=0;
				float a,b;
				op = JOptionPane.showOptionDialog(null,
						"seleccione la operacion","calcular areas de figuras geometricas",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null,
						new Object[] {"Circulo", "Cuadrado", "Triangulo"}," ");
				
				switch(op){
                case 0:
                    float radio=Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese el radio del circulo"));
                	area=llam.Circulo(radio);
                	System.out.println("El area del circulo es:"+area+" cm^2");
                    break;
                case 1:
                    b=Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la base del cuadrado"));
                    a=Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la altura del cuadrado"));
                    area=llam.cuadrado(b,a);
                    System.out.println("el area del cuadrado es:"+area+" cm^2");
                    break;
                case 2:
                	String[] str= {"Equilatero", "isosceles", "Escaleno"};
                    int tipotrian=0;
                    tipotrian= JOptionPane.showOptionDialog(null,
        					"Seleccione el tipo de Triangulo","Registro de Base y altura del Triangulo",
        					JOptionPane.YES_NO_CANCEL_OPTION,
        					JOptionPane.QUESTION_MESSAGE, null,
        					new Object[] {"Equilatero", "isosceles", "Escaleno"}," ");
                    b=Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la base del triangulo"));
                    a=Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la altura del triangulo"));
                    System.out.println("el tipo de triangulo es:"+str[tipotrian]);
                    area=llam.triangulo(b, a);
                    System.out.println("el area del triangulo es:"+area);
                    break;
                default:
                    {JOptionPane.showMessageDialog(null, "No es una opción valida!!!");} 
                }
				
				
				opcion = JOptionPane.showConfirmDialog(null, "Desea seguir ejecutando la Aplicación?",
						"Seleccione una Opción", JOptionPane.YES_NO_OPTION);
				System.out.println("================================================");
			
			}

	}

}
