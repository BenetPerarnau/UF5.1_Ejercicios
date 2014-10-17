package Ex4;

import java.util.Comparator;

public class OrdenarPorGenero implements Comparator {

	public int compare(Object t, Object t1) {
		int aux=0;
		if(t instanceof Pelicula){
			if(t1 instanceof Pelicula){
				if(((Pelicula) t1).getGenero().equalsIgnoreCase(((Pelicula) t).getGenero())){
					aux= ((Pelicula) t1).getNum_votos()-((Pelicula) t).getNum_votos();
				}else{
					aux= ((Pelicula) t).getGenero().compareToIgnoreCase(((Pelicula) t1).getGenero());
				}
			}
		}
		return aux;
	}
}
