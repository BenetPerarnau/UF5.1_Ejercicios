package Ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import Ex1.Empleado;

public class Fichero2 {
	
	//private static Queue<Empleado> queue=null;
	public  static Set<Empleado2> leerFichero(){
		
		//if(queue==null){
			//queue=new PriorityQueue<Empleado>();
		//}
		
		Set<Empleado2> set=new TreeSet<Empleado2>();
		
		File fichero=null;
		FileReader fr=null;
		BufferedReader br=null;
		
		try{
			fichero=new File("src/Ex2/empleados2.txt");
			fr=new FileReader(fichero);
			br=new BufferedReader(fr);
			
			byte aux=0;
			String linea="";
			
			while((linea=br.readLine())!=null){
				if(aux!=0){
				String[] contenido=linea.split(";");
				set.add(new Empleado2(contenido[0],contenido[1],contenido[2],contenido[3]));
				
				}
				aux=1;
				
			}
				
		}catch(Exception e){
			System.out.println("Erro en leer el archivo");
		}
		
		
		return set;
	}

}
