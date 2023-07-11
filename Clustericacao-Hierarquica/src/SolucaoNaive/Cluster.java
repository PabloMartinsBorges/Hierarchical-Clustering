package SolucaoNaive;
import java.util.ArrayList;
import java.util.Arrays;

public class Cluster implements Comparable<Cluster>{

	public int qtdPontos, xAcumulado, yAcumulado;
    public double[] coord;
  //Salva os clusters que o formaram
    public Cluster fEsq, fDir;
    
    
    
    public Cluster(double coordX, double coordY) {
    	
    	 this.qtdPontos = 1;
    
    	 coord = new double[2];
    	 
    	 coord[0] = coordX;
         coord[1] = coordY;
         
         xAcumulado = 0;
        yAcumulado =0;
    	 
         
    	 fEsq = null; 
         fDir = null;
    	
    }
    
    
    public Cluster(Cluster[]c) {
        
        this.qtdPontos = (c[0].qtdPontos+c[1].qtdPontos);
        
        coord = new double[2];
        
        coord[0] = (c[0].coord[0] + c[1].coord[0])/this.qtdPontos;
        coord[1] = (c[0].coord[1] + c[1].coord[1])/this.qtdPontos;
        
        if(c[0].compareTo(c[1]) <0) {
        	fEsq = c[0]; 
            fDir = c[1];
        }else {
        	fEsq = c[1]; 
            fDir = c[0];
        }
        
       
        
    }
    /*
    public void atualizaCentroid(int valor[]){
        this.centroid = valor;
    }
    */
    /*
    //metodo que teremina o centroid do novo cluster e chama para atualizar o array
    public static void calculaCentroid(ArrayList<Cluster> lista, Cluster[] c){
        
        Cluster.atualizaClusters(lista, c);
        
    }
    */
    //Pode ser usado???
    public void atribuiFilhos(Cluster filho1, Cluster filho2){
    	if(filho1.compareTo(filho2) <0) {
        	fEsq = filho1; 
            fDir = filho2;
        }else {
        	fEsq = filho2; 
            fDir = filho1;
        }
    }
    
    //Atualiza a lista de cluster removendo os 2 pontos e salvando o novo
    public static void atualizaClusters(ArrayList<Cluster> lista, Cluster novo){
        
        
        System.out.println(novo);
        
        lista.add(novo);
        lista.remove(novo.fDir);
        lista.remove(novo.fEsq);
        
    }


	@Override
	public int compareTo(Cluster o) {
		if(this.coord == o.coord) {
			return 0;
		}
		else if(this.coord[0] > o.coord[0])
		return 1;
		else
			return -1;
	}


	@Override
	public String toString() {
		return "Cluster [qtdPontos=" + qtdPontos +" Coord: " + Arrays.toString(coord) +" ]";
	}


	
	
    
	
}
