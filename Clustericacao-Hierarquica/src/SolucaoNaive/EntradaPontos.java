package SolucaoNaive;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicStampedReference;

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

        for (int i = 0; i < nTestes; i++) {
            double x = gerador.nextInt(alcance) + 1;
            double y = gerador.nextInt(alcance) + 1;

            Cluster temp = new Cluster(x, y);
            System.out.println("x: " + x + " Y: " + y);
            c.add(temp);
        }
    }

    public void testesDezVezes() {
        long tempoTotal = 0;

        // Executa 10 vezes
        for (int i = 0; i < 10; i++) {
            ArrayList<Cluster> c = new ArrayList<Cluster>();
            geraPontos(c);

            long tempoInicio = System.nanoTime(); // Marca o início do tempo de execução

            Distancia4 d = new Distancia4();
            int tam = c.size();
            System.out.println("Novos pontos:");
            for (int k = 0; k < tam - 1; k++) {
                d.calculaDistancia(c);
                System.out.println("Clusterizando...");
            }

            long tempoFim = System.nanoTime(); // Marca o fim do tempo de execução
            long tempoExecucao = tempoFim - tempoInicio;
            tempoTotal += tempoExecucao;
        }

        double tempoMedioNano = (double) tempoTotal / 10.0; // Tempo médio em nanosegundos
        double tempoMedioSegundos = tempoMedioNano / 1_000_000_000.0; // Tempo médio em segundos

        System.out.println("Tempo médio de execução: " + tempoMedioNano + " nanosegundos");
        System.out.println("Tempo médio de execução: " + tempoMedioSegundos + " segundos");
    }

}
