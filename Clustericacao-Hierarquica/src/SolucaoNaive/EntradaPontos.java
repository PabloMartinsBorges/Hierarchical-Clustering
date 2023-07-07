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
			c.add(new Cluster(gerador.nextInt(alcance)+1,gerador.nextInt(alcance)+1));
		}
	}
	
	public void testesDezVezes(ArrayList<Cluster> c) {
		
		//TODO: Colocar Um loop para executar 10 vezes, no qual cada interaçcao ele cria um novo arrayList, chama o gerar pontos,executa o metodo das distancias
	}
	
	
	
}
