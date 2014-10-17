package Ex4;

import java.util.Comparator;

public class OrdenarPorVotos implements Comparator {

	public int compare(Object t, Object t1) {
		int aux=0;
		if(t instanceof Pelicula){
			if(t1 instanceof Pelicula){
				aux= ((Pelicula) t1).getNum_votos()-((Pelicula) t).getNum_votos();
			}
		}
		return aux;	
	}

}
