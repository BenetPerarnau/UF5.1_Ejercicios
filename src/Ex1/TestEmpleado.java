package Ex1;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Con motivo del décimo aniversario de una empresa, el director decide premiar a sus empleados según su orden de entrada a la empresa.
 * Cada mes quiere premiar a un empleado. Dispones de un fichero empleados.dat con los datos de los empleados de la empresa
 * (nombre, apellido, dni y fecha de entrada en la empresa). Crea un programa Java que, haciendo uso de la clase de la plataforma
 * Java que implemente la interfaz Queue que consideres más apropiada, permita crear la lista de espera para la entrega del premio
 * cada mes:
 */

public class TestEmpleado {
	
	
	public static void main(String[] args) {
		Queue<Empleado> queue=new PriorityQueue<Empleado>();
		
		//leer fichero con los datos
		queue=Fichero.leerFichero();
		//
		byte i=1;
		Empleado a;
		while ((a=queue.poll())!=null){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			System.out.println("Empleado premiado mes "+i+": "+a.getNombre()+" "+a.getApellido()+"\t"+formatter.format(a.getData()));
			i++;	
		}
	}
}
