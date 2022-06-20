package registromed;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class manejoarchivo {
/*
	
	String idcedula;
	String newidcedula;
	
	String nombre;
	String apellido;
	String direccion;
	String especialidad;
	String fechainiciolabor;
	//formato dd/mm/aaaa
	boolean esborrado;
	//esta variable controla si es borrado por el objetivo de un  borrado lógico y no fisico de la aplicacion
	//requerimiento al valor true es porque ha sido eliminado
	*/
	SimpleDateFormat sdf = new SimpleDateFormat();
	
	public ArrayList<Medicos> arrlist = new ArrayList<Medicos>();
	
	
	/**
	 * metodo de verificar si el archivo existe en la ruta
	 * @author JordyM
	 * @return true si el archivo existe false si el archivo no existe
	 */
	public boolean existearchivo() {
		boolean fileexist=false;
		try {
			File file = new File("registro.csv");
			if (!file.exists()) {
				fileexist=false;
			}
			else {fileexist=true;}
		} catch (Exception e){
			e.printStackTrace();
		}
		return fileexist;
	}
	
	
	
	/**
	 * Por definicion debemos buscar el archivo primero antes de crearlo 
	 *el archivo cuando existe debe de cargarse en almacenamiento
	 * <p>SINO EXISTE crea el nuevo archivo</>
	 */ 
	public void creararchivo() {
		  
 		
		try {
			File file = new File("registro.csv");

			if (!file.exists()) {

				file.createNewFile();
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void registrarenarchivo() {
		try {
			File file = new File("registro.csv");

			if (!file.exists()) {

				// SINO EXISTE crea el nuevo archivo
				file.createNewFile();
			}
		RandomAccessFile archivo = new RandomAccessFile(file,"rw");			
		
		for(Medicos reg : arrlist) {
		writeString(archivo,reg.getIdcedula()+";",64);
		archivo.writeChars(reg.nombre+";");
		archivo.writeChars(reg.apellido+";");
		archivo.writeChars(reg.direccion+";");
		archivo.writeChars(reg.especialidad+";");
		archivo.writeChars(reg.fechainiciolabor.toString());
		archivo.writeChars(";");
		archivo.writeBoolean(reg.esborrado);
		archivo.writeChars(";");
		}
		archivo.close();
		
	} catch (Exception e){
		e.printStackTrace();
	}
		
	
	}	
	
		
		
	public int buscarregistro(String idcedula) {
		//aqui solo muestra los que no contienen borrado logico
		int scan=0;
		try {
		manejoarchivo mng = new manejoarchivo();
		
		if(mng.existearchivo()==true) {
				BufferedReader archivo = new BufferedReader(new InputStreamReader(new FileInputStream("registro.csv"),"UTF-8"));
				String line = archivo.readLine();
				while(line!=null) {
					String[] campos = line.split(";");
					arrlist.add(new Medicos( campos[0].toString(), campos[1].toString(), campos[2].toString(), campos[3].toString(), campos[4].toString(), sdf.parse(campos[5]), Boolean.parseBoolean(campos[6])));
				}
				
				
				
				for(int i=0;i<arrlist.size();i++) 
				{
				if(arrlist.get(i).getIdcedula().equals(idcedula))
				{
					scan=i;
					break;
				}
				else{scan=-1;}
				
				}
				archivo.close();
				}
		else {
		mng.creararchivo();
		BufferedReader archivo = new BufferedReader(new InputStreamReader(new FileInputStream("registro.csv"),"UTF-8"));
		archivo.close();
		scan=-1;
				}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return scan;
	}
	
	
	
	/**
	 * metodo para hacer la operacion de borrado logico
	 */
	public void borradologico(String idcedula,String nombre, String apellido, String direccion,String especialidad,Date fechainiciolabor,boolean esborrado) {
		//en la operacion borrado logico es lo mas normal que aunque borre
		int scan=0;
		try {
		manejoarchivo mng = new manejoarchivo();
		if(mng.existearchivo()==true) {
		BufferedReader archivo = new BufferedReader(new InputStreamReader(new FileInputStream("registro.csv"),"UTF-8"));
		String line = archivo.readLine();
		while(line!=null) {
			String[] campos = line.split(";");
			arrlist.add(new Medicos( campos[0].toString(), campos[1].toString(), campos[2].toString(), campos[3].toString(), campos[4].toString(), sdf.parse(campos[5]), Boolean.parseBoolean(campos[6])));
		}
		scan = arrlist.indexOf(idcedula);
		arrlist.set(scan, new Medicos(idcedula,nombre,apellido,direccion,especialidad,fechainiciolabor,true));
		mng.registrarenarchivo();
		archivo.close();
		}
		else {scan=-1;}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void writeString(RandomAccessFile file, String str, int lfld) throws IOException {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(str);
		buffer.setLength(lfld);
		
		try {
			
			file.writeChars(buffer.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
