//superclase
public class Figura {

	private String colorrelleno;
	private String colorlinea;
	
	
	public Figura(String colorrelleno, String colorlinea) {
		this.colorrelleno = colorrelleno;
		this.colorlinea = colorlinea;
	}
	
	public String getColorrelleno() {
		return colorrelleno;
	}
	public void setColorrelleno(String colorrelleno) {
		this.colorrelleno = colorrelleno;
	}
	public String getColorlinea() {
		return colorlinea;
	}
	public void setColorlinea(String colorlinea) {
		this.colorlinea = colorlinea;
	}
	
	public void MostrarAtrFigura() {
		System.out.println("El color de la figura es:"+getColorrelleno());
		System.out.println("El color de la linea de la figura es:"+getColorlinea());
	}
	
}
