import java.util.ArrayList;

public class Distancia {
	
	public double d;
	
	public Distancia() {
		
		d = 0;
	}
	
	
	public Cluster[] calculaDistancia(ArrayList<Cluster> lista) {
		
		Cluster[] menorDis = {null,null}; 
		double temp = 0;
		int indC1 = 0, indC2 = 0;
		
		for(int i = 0; i<lista.size(); i++) {
			for(int j = 0; j < lista.size(); j++) {
				if(lista.get(i).compareTo(lista.get(j)) == 0) {
					continue;
				}
				
				temp = Math.sqrt(Math.pow(lista.get(i).x-lista.get(j).x, 2) + Math.pow(lista.get(i).y-lista.get(j).y, 2));
				if(temp > d) {
					d = temp;
					
					indC1 = i;
					indC2 = j;
				}
			}
		}
		menorDis[0] = lista.get(indC1);
		menorDis[1] = lista.get(indC2);
		
		return menorDis;
	}
	
}
