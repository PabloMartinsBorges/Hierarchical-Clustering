package SolucaoNaive;
import java.util.ArrayList;

public class Distancia {
	
	public double d;
	Cluster[] menorDis;
	
	public Distancia() {
		
		d = 100;
		menorDis = new Cluster[2];
	}
	
	
	public void calculaDistancia(ArrayList<Cluster> lista) {
		
		//Array que vai salvar os 2 cluster com a menor distancia
		 
		double temp = 0; //var temporaria para cada iteracao
		int indC1 = 0, indC2 = 0; // indice dos clusters
		
		int tam = lista.size();
		d = Integer.MAX_VALUE;
		
		for(int i = 0; i < lista.size()-1; i++) { // compara um elemento com os demais da lista
			for(int j = i+1; j < lista.size(); j++) {
				
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
		
	System.out.println("Distanciado");
		//retorna o Novo Cluster com a menor distancia
		
		Cluster novo = new Cluster(menorDis);
	    Cluster.atualizaClusters(lista, novo);;
	}
	
}
