package Ex3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Fichero3 {
	
	
	public  static Queue<Empleado3> leerFichero(){
		
		
		Queue<Empleado3> queue=new PriorityQueue<Empleado3>();
		
		File fichero=null;
		FileReader fr=null;
		BufferedReader br=null;
		
		try{
			fichero=new File("src/Ex1/empleados.txt");
			fr=new FileReader(fichero);
			br=new BufferedReader(fr);
			
			byte aux=0;
			String linea="";
			
			while((linea=br.readLine())!=null){
				if(aux!=0){
				String[] contenido=linea.split(";");
				queue.add(new Empleado3(contenido[0],contenido[1],contenido[2],contenido[3]));
				
				}
				aux=1;
				
			}
				
		}catch(Exception e){
			System.out.println("Erro en leer el archivo");
		}
		
		return queue;
	}

}
