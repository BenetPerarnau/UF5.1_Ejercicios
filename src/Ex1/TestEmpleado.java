package Ex1;

import java.text.SimpleDateFormat;
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
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");//MM mayusculas si no lo entiende como si fueran minutos
			System.out.println("Empleado premiado mes "+i+": "+a.getNombre()+" "+a.getApellido()+"\t"+formatter.format(a.getData()));
			i++;
		}
	}
}
