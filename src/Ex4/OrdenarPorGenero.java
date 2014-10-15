package Ex4;

import java.util.Comparator;

public class OrdenarPorGenero implements Comparator {

	@Override
	public int compare(Object t, Object t1) {
		
		if(t instanceof Pelicula){
			if(t1 instanceof Pelicula){
				if(((Pelicula) t1).getGenero().equalsIgnoreCase(((Pelicula) t).getGenero())){
					return ((Pelicula) t1).getNum_votos()-((Pelicula) t).getNum_votos();
				}else{
				return ((Pelicula) t).getGenero().compareToIgnoreCase(((Pelicula) t1).getGenero());
				}
			}
		}
		
		return 900;
	}

}
