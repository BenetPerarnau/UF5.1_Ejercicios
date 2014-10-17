package Ex1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado implements Comparable<Empleado>{

	private String nombre;
	private String apellido;
	private String id;
	private Date data;
	
	public Empleado(String nombre, String apellido, String id, String date){
		this.nombre=nombre;
		this.apellido=apellido;
		this.id=id;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");//MM mayusculas si no lo entiende como si fueran minutos
		try {
			this.data=formatter.parse(date);
		} catch (ParseException e) {
			System.out.println("El formato de entrada de la data tiene que ser dd-mm-yyyy");
		}
	}
	
	protected Date getData() {
		return data;
	}

	protected String getNombre() {
		return nombre;
	}

	protected String getApellido() {
		return apellido;
	}

	protected String getId() {
		return id;
	}

	public int compareTo(Empleado o) {
		
		return this.getData().compareTo(o.getData());
		
	}
	
}
