package registromed;

import java.io.*;
import java.util.ArrayList;


public class manejoarchivo {

	
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
			
			manejoarchivo mng = new manejoarchivo();
			if(mng.existearchivo()==true) {
				PrintWriter archivo = new PrintWriter(file,"UTF-8");			
				
				for(Medicos reg : arrlist) {
					
	archivo.println(reg.getIdcedula()+";"+reg.getNombre()+";"+reg.getApellido()+";"+reg.getDireccion()+";"+reg.getEspecialidad()+";"+reg.getFechainiciolabor()+";"+reg.isEsborrado());
				}
				
				archivo.close();
			}
		
	} catch (Exception e){
		e.printStackTrace();
	}
	}	
	
		
		
	public int buscarregistro(String idcedula) {
		//aqui solo muestra los que no contienen borrado logico
		int scan=0;
		manejoarchivo mng = new manejoarchivo();
		
		if(mng.existearchivo()==true) {
			try {
			BufferedReader archivo = new BufferedReader(new InputStreamReader(new FileInputStream("registro.csv"),"UTF-8"));
				
			String line = archivo.readLine();
								
			if(line==null) {
				scan=-1;
			}	
			
			while(line!=null) {
					String[] campos = line.split(";");
					arrlist.add(new Medicos( campos[0].toString(), campos[1].toString(), campos[2].toString(), campos[3].toString(), campos[4].toString(), campos[5], Boolean.parseBoolean(campos[6])));
					line = archivo.readLine();
				}
				
				for(int i=0;i<arrlist.size();i++) 
				{  
					if(arrlist.get(i).getIdcedula().contains(idcedula))
						{
						scan=i;
						break;
						}
						else{scan=-1;
						
						}
				
				}
				archivo.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		else {
			mng.creararchivo();
			scan=mng.buscarregistro(idcedula);
		}
		
		return scan;
	}
	
	
	
	/**
	 * metodo para hacer la operacion de borrado logico
	 */
	public void borradologico(String idcedula,String nombre, String apellido, String direccion,String especialidad,String fechainiciolabor,boolean esborrado) {
		//en la operacion borrado logico es lo mas normal que aunque borre
		int scan=0;
		try {
		manejoarchivo mng = new manejoarchivo();
		if(mng.existearchivo()==true) {
			BufferedReader archivo = new BufferedReader(new InputStreamReader(new FileInputStream("registro.csv"),"UTF-8"));
			String line = archivo.readLine();
			while(line!=null) {
				String[] campos = line.split(";");
				arrlist.add(new Medicos( campos[0].toString(), campos[1].toString(), campos[2].toString(), campos[3].toString(), campos[4].toString(), campos[5], Boolean.parseBoolean(campos[6])));
				line = archivo.readLine();
			}

			for(int i=0;i<arrlist.size();i++) 
			{
				if(arrlist.get(i).getIdcedula().contains(idcedula))
				{
					scan=i;
					break;
				}
				else{scan=-1;}
			}
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
