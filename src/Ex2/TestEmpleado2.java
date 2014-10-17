package Ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import Ex1.Empleado;
import Ex1.Fichero;

/*
 * La empresa se dedica a la fabricación de juguetes.
 * El director decide que pondrá el nombre de los siguientes juguetes que saque al mercado según la lista de los nombres
 * de sus empleados (firstname). Crea un programa en Java que le permita disponer de esta lista de nombres ordenados
 * alfabéticamente, haciendo uso de la clase de la plataforma Java que implemente la interfaz Set que consideres más apropiada:
 */
public class TestEmpleado2 {
	
	public static void main(String[] args) {
		
		Set<Empleado2> set=new TreeSet<Empleado2>();
		
		set=Fichero2.leerFichero();		
		
		Iterator it=set.iterator();
		
		while(it.hasNext()){
			System.out.println("Empleado => "+((Empleado2)it.next()).getNombre());	
		}
	}
}
