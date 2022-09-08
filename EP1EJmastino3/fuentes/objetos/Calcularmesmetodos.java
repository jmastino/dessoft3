package objetos;


/*
 * esta clase esta destinada a calcular el detalle de los dias, 
 * se puede simplificar el codigo pero hay que implementar estrategias de POO
 */
public class Calcularmesmetodos {

	//variables utilizadas para mostrar los resultados de los calculos
	int[] dias= {29,31,28,31,30,31,30,31,31,30,31,30,31};
	String[] mes= {"Febrero","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	
	public  String devolverresultado(int mesinput, int anio) {
		String resultado = "El mes introducido es: "+mes[mesinput]+" y tiene "+dias[mesinput]+" dias.";
		return resultado;
	}
	
	
	
	//metodo para determinar año bisiesto
	public static boolean esBisiesto(int anio)
    {
        // se requiere una variable definida para switch de año bisiesto 
        boolean vbisiesto = false;
        // si el año es divisible por cuatro
        if (anio % 4 == 0) 
        {
          vbisiesto = true;
            // para identificar si es un siglo o no 
            if (anio % 100 == 0) {
               //revisando si es divisible por 100
                // por lo tanto es un siglo
                if (anio % 400 == 0)
                    vbisiesto = true;
                else
                    vbisiesto = false;
            }
        }
        // si falla nosotros llegamos aqui.
        // por lo tanto sino es divisible por cuatro
        else
            // se activa que no es año bisiesto
            vbisiesto = false;
        
        /*
        if (!vbisiesto)
            System.out.println(anio + " : No es Bisiesto");
        else
            System.out.println(anio + " : Año Bisiesto");
        */
        return vbisiesto;

    }
	
	//metodo para convertir el dato del mes en la variable definida como bisiesta en tipo objeto 
	public static int mesbisiesto(int mesinput,int anio) {
		if(mesinput==2) {
			if(objetos.Calcularmesmetodos.esBisiesto(anio)==true) {
				mesinput=0;	
				return mesinput;
				}
		}
		return mesinput;
	}

	

	public int[] getDias() {
		return dias;
	}


	public void setDias(int[] dias) {
		this.dias = dias;
	}


	public String[] getMes() {
		return mes;
	}


	public void setMes(String[] mes) {
		this.mes = mes;
	}
	
	
	/*
    Meses con 30 días: Abril, Junio, Septiembre y Noviembre.
    Meses con 31 días: Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre.
    Meses con 28 días: Febrero (Menos cuando es bisiesto que tiene 29 días).
	*/
	
}
