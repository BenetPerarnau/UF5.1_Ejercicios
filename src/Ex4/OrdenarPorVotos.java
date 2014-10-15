package Ex4;

import java.util.Comparator;

public class OrdenarPorVotos implements Comparator {

	public int compare(Object t, Object t1) {
		
		if(t instanceof Pelicula){
			if(t1 instanceof Pelicula){
				return ((Pelicula) t1).getNum_votos()-((Pelicula) t).getNum_votos();
			}
		}
		return -800;	
	}

}
