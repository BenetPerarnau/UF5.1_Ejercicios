package Ex2;

public class Empleado2 implements Comparable<Empleado2>{

	private String nombre;
	private String apellido;
	private String id;
	private String data;
	
	public Empleado2(String nombre, String apellido, String id, String data){
		this.nombre=nombre;
		this.apellido=apellido;
		this.id=id;
		this.data=data;
	}

	protected String getData() {
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

	public int compareTo(Empleado2 o) {
		return this.nombre.compareTo(o.getNombre());
	}
}
