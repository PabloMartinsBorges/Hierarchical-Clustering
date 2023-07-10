package SolucaoNaive;
import java.util.ArrayList;

public class Distancia {
	
	public double d;
	
	public Distancia() {
		
		d = Integer.MAX_VALUE;
	}
	
	
	public Cluster calculaDistancia(ArrayList<Cluster> lista) {
		
		//Array que vai salvar os 2 cluster com a menor distancia
		Cluster[] menorDis = new Cluster[2]; 
		double temp = 0; //var temporaria para cada iteracao
		int indC1 = 0, indC2 = 0; // indice dos clusters
		
		for(int i = 0; i<lista.size(); i++) { // compara um elemento com os demais da lista
			for(int j = 0; j < lista.size(); j++) {
				if(lista.get(i).compareTo(lista.get(j)) == 0) { //garante que o elemento não seja comparado com ele mesmo
					continue;
				}
				
				temp = Math.sqrt(Math.pow(lista.get(i).coord[0]-lista.get(j).coord[0], 2) + Math.pow(lista.get(i).coord[1]-lista.get(j).coord[1], 2)); //calculo da distancia
				
				if(temp < d) {//Salva uma distancia menor que a atual
					d = temp;
					
					indC1 = i; //salva os indices daquels clusters
					indC2 = j;
				}
			}
		}
		//Salva os clusters no array
		menorDis[0] = lista.get(indC1);
		menorDis[1] = lista.get(indC2);
		
		System.out.print("(" + menorDis[0].toString());
		System.out.println(menorDis[1].toString() + " )");
		//retorna o Novo Cluster com a menor distancia
		
		Cluster novo = new Cluster(menorDis);
		return novo;
	}
	
}
