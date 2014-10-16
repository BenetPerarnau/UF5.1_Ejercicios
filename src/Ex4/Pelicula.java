package Ex4;

import java.util.Comparator;

public class Pelicula{

	private String titulo;
	private String genero;
	private int num_votos;
	
	public Pelicula(String titulo, String genero,int num_votos){
		
		this.titulo=titulo;
		this.genero=genero;
		this.num_votos=num_votos;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected String getGenero() {
		return genero;
	}

	protected void setGenero(String genero) {
		this.genero = genero;
	}

	protected int getNum_votos() {
		return num_votos;
	}

	protected void setNum_votos(int num_votos) {
		this.num_votos = num_votos;
	}


}
