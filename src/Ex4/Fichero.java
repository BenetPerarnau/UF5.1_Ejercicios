package Ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Fichero {
	private static ArrayList<Pelicula> array=null;
	public static ArrayList<Pelicula> leerFichero(){
		if(array==null){
			array=new ArrayList<Pelicula>();
		}
		File archivo=null;
		FileReader fr=null;
		BufferedReader br=null;
		try{
			archivo=new File("src/Ex4/videoteca.dat");
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			String linea="";
			byte aux=0;
			while((linea=br.readLine())!=null){
				if(aux>0){
				String[] pelicula=linea.split(";");
				array.add(new Pelicula(pelicula[0],pelicula[1],Integer.parseInt(pelicula[2])));
				}
				aux=1;
			}	
			fr.close();		
		}catch(Exception e){
			System.out.println("Error en cargar la BBDD en el array");
		}
		
		return array;
	}
}
