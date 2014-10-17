package Ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

/*
 * 
Ejercicio M03-UF5.1 -04 (ENTREGABLE).
Consideremos una videoteca compuesta por una colección de películas.
De cada película se registran las siguientes características:
	 Titulo
	 Genero
	 Votos espectadores
La videoteca únicamente dispone de los géneros Aventura, Ciencia Ficción, Infantil, Terror.
Al iniciarse la aplicación se mostrará el siguiente menú (casos de uso):
	1. Cargar datos de inicio
	2. Listar películas ordenadas por no de votos
	3. Listas películas ordenadas por género
	4. Salir
 */
public class TestPelicula {
	private static BufferedReader stdin=new BufferedReader (new InputStreamReader(System.in));
	static ArrayList <Pelicula> array=null;
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
				/*
				 * La aplicación carga los datos desde el fichero videoteca.dat y vuelve al menú.
				   Si el fichero no se encuentra en la ruta especificada o si no ha sido posible su lectura,
				   se informa al usuario y se vuelve al menú.
				   Haz uso de una estructura de almacenamiento ArrayList<Pelicula>
				 */
				if(array==null){
					array=new ArrayList<Pelicula>();
				}
				array=Fichero.leerFichero();
				break;
			case 2: //ordenar por numero de votos
				/*
				 * La aplicación muestra la lista de películas ordenadas por número de votos (en orden descendente).
				 * Los datos a mostrar son Título y número de votos de cada película.
				 * Si no existen datos para mostrar (porque la carga de datos de inicio no se ha realizado)
				 * se informa al usuario y se vuelve al menú.
				 * Haz uso de la interface Comparator y de la clase java.util.Collections
				 */
				if(array==null){
					System.out.println("No se ha seleccionado previamente ‘Carga datos inicio’");
				}else{
					
					Collections.sort(array,new OrdenarPorVotos());
					
					System.out.println("Imprimir Iterator");
					System.out.println("Nº V\tTitulo");
					ListIterator <Pelicula> elements=array.listIterator();
					
					Pelicula a;
					
					while(elements.hasNext()){
						a=elements.next();
						System.out.println(a.getNum_votos()+" "+a.getTitulo());
					}
				}
				break;
			case 3://ordenar por genero (si es mismo genero por numero de votos)
				/* 
					La aplicación muestra la lista de películas ordenadas por género en el siguiente orden:
					Aventuras, Ciencia Ficción, Infantiles, Terror. Dentro de un mismo género las películas 
					aparecerán ordenadas por su número de votos en orden decreciente (de mayor a menor).
					Los datos a mostrar son Género, Título y número de votos de cada película.
					Si no existen datos para mostrar (porque la carga de datos de inicio no se ha realizado)
					se informa al usuario y se vuelve al menú.
				 */
				if(array==null){
					System.out.println("No se ha seleccionado previamente ‘Carga datos inicio’");
				}else{
						
					Collections.sort(array, new OrdenarPorGenero());
					
					Iterator <Pelicula> elemnts=array.iterator();
					Pelicula a;
					System.out.println("Genero\t\tNº");
					while(elemnts.hasNext()){
						a=elemnts.next();
						System.out.println(a.getGenero()+"\t\t"+a.getNum_votos());
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
