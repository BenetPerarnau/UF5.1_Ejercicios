package Ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class TestPelicula {
	private static BufferedReader stdin=new BufferedReader (new InputStreamReader(System.in));
	static ArrayList <Pelicula> bbdd2=new ArrayList<Pelicula>();
	public static void main(String[] args) {
		
		byte op=0;
		boolean error=false;
		do{
			System.out.println("1. Cargar datos de inicio");
			System.out.println("2. Ordenar por Votos");
			System.out.println("3. Ordenar por Genero y Votos.");
			System.out.println("4. Salir");
			try{
				System.out.print("Operacion => ");
				op=Byte.parseByte(stdin.readLine());
				error=false;
			}catch(Exception e){
				System.out.println("Se espera un valor numerico");
				error=true;
			}
			switch (op){
			case 1: //cargar datos
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
						bbdd2.add(new Pelicula(pelicula[0],pelicula[1],Integer.parseInt(pelicula[2])));
						}
						aux=1;
					}	
					fr.close();		
				}catch(Exception e){
					System.out.println("Error en cargar la BBDD en el array");
				}
				break;
			case 2: //ordenar por numero de votos
				if(bbdd2.isEmpty()){
					System.out.println("No se ha seleccionado previamente ‘Carga datos inicio’");
				}else{
					
					Collections.sort(bbdd2,new OrdenarPorVotos());
					
					System.out.println("Imprimir Iterator");
					Iterator <Pelicula> elements=bbdd2.iterator();
					while(elements.hasNext()){
						System.out.println(elements.next().getNum_votos()+"\t"+elements.next().getTitulo());
					}
					System.out.println("Imprimir diferent");
					for(Object o:bbdd2){
						System.out.println(((Pelicula)o).getNum_votos()+"\t"+((Pelicula)o).getNum_votos());
					}
					
					
				}
				break;
			case 3://ordenar por genero (si es mismo genero por numero de votos)
				
				if(bbdd2.isEmpty()){
					System.out.println("No se ha seleccionado previamente ‘Carga datos inicio’");
				}else{
						
					Collections.sort(bbdd2, new OrdenarPorGenero());

					System.out.println("Genero\t\tNº");
					for(int i=0; i<bbdd2.size(); i++){
						System.out.println(bbdd2.get(i).getGenero()+"\t\t"+bbdd2.get(i).getNum_votos());
					}
				}
				break;
			case 4://salir
				
					System.out.println("Dew.");
				break;
				default:
					if(error==false){
						System.out.println("El numero introducido no contempla ninguna operación.");
					}
					else{
						// no hace nada pq el catch ya ha mostrado que el valor tiene que ser numerico
					}
					break;
			}
		}while(op!=4);

	}
}
