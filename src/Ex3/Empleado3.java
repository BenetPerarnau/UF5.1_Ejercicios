package Ex3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Queue;

public class Empleado3 implements Comparable<Empleado3>{

	private String nombre;
	private String apellido;
	private String id;
	private Date data;
	
	public Empleado3(String nombre, String apellido, String id, String date){
		this.nombre=nombre;
		this.apellido=apellido;
		this.id=id;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.data=formatter.parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}


	protected Date getData() {
		return data;
	}


	protected void setData(Date data) {
		this.data = data;
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

	
	public int compareTo(Empleado3 o) {
		
		return this.data.compareTo(o.getData());
	}
	
}
