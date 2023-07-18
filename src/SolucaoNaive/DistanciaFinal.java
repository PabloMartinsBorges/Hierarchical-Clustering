package SolucaoNaive;

import java.util.ArrayList;

public class DistanciaFinal {
    public void calculaDistancia(ArrayList<Cluster> lista) {
        int tamanho = lista.size();

        // Encontrar os dois clusters mais próximos
        int indiceCluster1 = -1;
        int indiceCluster2 = -1;
        double menorDistancia = Double.MAX_VALUE;
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                double distancia = calcularDistancia(lista.get(i), lista.get(j));
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    indiceCluster1 = i;
                    indiceCluster2 = j;
                }
            }
        }

        // Realizar a união dos dois clusters mais próximos
        Cluster cluster1 = lista.get(indiceCluster1);
        Cluster cluster2 = lista.get(indiceCluster2);
        Cluster novoCluster = new Cluster(new Cluster[] {cluster1, cluster2});
        lista.add(novoCluster);
        lista.remove(cluster1);
        lista.remove(cluster2);

        // Exibir os clusters e o centroide do novo cluster formado
      //  System.out.println("Clusters após a união:");
        for (Cluster cluster : lista) {
            System.out.println(cluster);
        }
       // System.out.println("Centroide do Novo Cluster: (" + novoCluster.coord[0] + ", " + novoCluster.coord[1] + ")");
    }

    private double calcularDistancia(Cluster c1, Cluster c2) {
        double xDiff = c1.coord[0] - c2.coord[0];
        double yDiff = c1.coord[1] - c2.coord[1];
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
