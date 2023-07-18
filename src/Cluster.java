import java.util.ArrayList;

public class Cluster implements Comparable<Cluster>{

	public int x, y, xAcumulado, yAcumulado, qtdPontos;
    public int[] centroid;
    public Cluster fEsq, fDir;
    
    
    
    public Cluster(int coordX, int coordY) {
    	this.x = coordX;
    	this.y = coordY;
    	
    	 qtdPontos = 1;
    	
    	 centroid[0] = this.x;
         centroid[1] = this.y;
    	 
    	 fEsq = null; 
         fDir = null;
    	
    }
    
    
    public Cluster(Cluster[]c) {
        this.x =(c[0].xAcumulado+c[0].x+c[1].xAcumulado+c[2].x)/qtdPontos;
        this.y =(c[0].yAcumulado+c[0].y+c[1].yAcumulado+c[2].y)/qtdPontos;
        
        qtdPontos++;
        
        centroid[0] = this.x;
        centroid[1] = this.y;
        
        
        fEsq = c[0]; 
        fDir = c[1];
    }
    
    public void atualizaCentroid(int valor[]){
        this.centroid = valor;
    }
    
    public void calculaCentroid(ArrayList<Cluster> lista, Cluster[] c){
        this.x = (c[0].x + c[1].x)/2;
        this.y = (c[0].y + c[1].y)/2;
        
        this.centroid[0] = x;
        this.centroid[1] = y;
        
        this.atribuiFilhos(c[0],c[1]);
        Cluster.atualizaClusters(lista, c, this);
        
    }
    
    public void atribuiFilhos(Cluster filhoEsq, Cluster filhoDir){
        this.fEsq = filhoEsq;
        this.fDir = filhoDir;
        
    }
    
    public static void atualizaClusters(ArrayList<Cluster> lista, Cluster[] retirada, Cluster entrando){
        
        lista.remove(retirada[0]);
        lista.remove(retirada[1]);
        
        lista.add(entrando);
        
    }


	@Override
	public int compareTo(Cluster o) {
		if(this.centroid == o.centroid) {
			return 0;
		}
		else if(this.x > o.x)
		return -1;
		else
			return 1;
	}

    
	
}
