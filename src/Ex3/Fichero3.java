package Ex3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Fichero3 {
	
	
	public  static Map<String,Integer> leerFichero(){
		
		ArrayList<String> name=new ArrayList<String>();
		Map <String,Integer> array=new HashMap<String,Integer>();
		
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
				name.add(contenido[0]);
				}
				aux=1;	
			}
				
		}catch(Exception e){
			System.out.println("Erro en leer el archivo");
		}
		////////////////////////////////////////////////////
		////////////////////////////////////////////////////	
		int cont=0;
		String [] aux=new String[name.size()];
		String nom="";
		boolean repe=false;
		
		for(int i=0; i<name.size(); i++){
			if(i>0){
				nom=name.get(i);
				for(int k=0; k<aux.length; k++){
					if(nom.equalsIgnoreCase(aux[k])){
						repe=true;
					}
				}
				if(repe==false){
					aux[i]=nom;
				}
			}else{
				aux[i]=name.get(i);
			}
			if(repe==false){
				for(int j=i; j<name.size(); j++){
					if(name.get(j).equalsIgnoreCase(aux[i])){
						cont++;
					}
				}
			}
			if(aux[i]!=null)array.put(aux[i], cont);	
			repe=false;
			cont=0;			
		}
		
		Iterator it=array.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry e=(Map.Entry)it.next();
			System.out.println(e.getKey()+": "+e.getValue());
		}
		
		
		////////////////////////////////////////////////////
		////////////////////////////////////////////////////
		return array;
	}

}
