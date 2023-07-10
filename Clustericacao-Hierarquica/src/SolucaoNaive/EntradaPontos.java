package SolucaoNaive;

import java.util.ArrayList;
import java.util.Random;

public class EntradaPontos {

	public int nTestes;
	
	public int alcance;
	
	public Random gerador;
	
	public EntradaPontos(int n, int a) {
		
		nTestes = n;
		alcance = a;
		
		gerador = new Random();
	}
	
	public void geraPontos(ArrayList<Cluster> c) {
		
		for(int i = 0; i < nTestes; i++) {
			int x = gerador.nextInt(alcance)+1;
			int y = gerador.nextInt(alcance)+1;
			
			System.out.println("x: " +x +" Y: " + y);
			c.add(new Cluster(x,y));
		}
	}
	
	public void testesDezVezes() {
		
		ArrayList<Cluster> c = new ArrayList<Cluster>();
		Distancia d = new Distancia();
		//TODO: Colocar Um loop para executar 10 vezes, no qual cada interaçcao ele cria um novo arrayList, chama o gerar pontos,executa o metodo das distancias
		for(int i = 0; i<10; i++) {
			
			geraPontos(c);
			
			int tam = c.size();
			System.out.println("novos pontos");
			//Aqui ele começa a calcular o tempo
			for(int k = 0; k < tam -1; k++)
				
			Cluster.atualizaClusters(c, d.calculaDistancia(c));
			System.out.println("Clusterizando");
			
		}
	}
	
	
	
}
