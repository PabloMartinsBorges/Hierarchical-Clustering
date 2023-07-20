package SolucaoNaive;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CriarRegistro {
	
	private String url;
	
	public CriarRegistro() {
		url = "registroCluster.csv";
	}
	
	public CriarRegistro(String endereco) {
		
		url = endereco;
	}

    public void RegistrarTempo(int nPontos, int limite, double tempoNano, double tempoSeg) {
        CriarArquivo(url);

        try {
            List<String> existentes = LinhaExistentes(url);
            String coluna = "Numero de Pontos" + ";" + "Tamanho Maximo "+ ";" + "Tempo Medio (nano) "+ ";" + "Tempo Medio (seg) "+ ";";
            existentes.add(coluna);
            String registro = nPontos + ";" + limite + ";" + tempoNano + ";" + tempoSeg + ";";
            existentes.add(registro);
            // adicionar no csv
            String todasLinhas = UnicaLinha(existentes);
            FileWriter arquivo = new FileWriter(url);
            arquivo.write(todasLinhas);
            arquivo.close();

        } catch (Exception error) {
            System.out.println("Erro ao gerar o arquivo " + url);
        }
    }
    
    
    public void RegistrarTempo(int nPontos, int limite, double tempo) {
        CriarArquivo(url);

        try {
            List<String> existentes = LinhaExistentes(url);
            String coluna = "Numero de Pontos" + ";" + "Tamanho Maximo "+ ";" + "Tempo"+ ";";
            existentes.add(coluna);
            String registro = nPontos + ";" + limite + ";" + tempo + ";";
            existentes.add(registro);
            // adicionar no csv
            String todasLinhas = UnicaLinha(existentes);
            FileWriter arquivo = new FileWriter(url);
            arquivo.write(todasLinhas);
            arquivo.close();

        } catch (Exception error) {
            System.out.println("Erro ao gerar o arquivo " + url);
        }
    }

    public String UnicaLinha(List<String> existentes) {

        String unicaLinha = "";
        for (String linha : existentes) {
            unicaLinha += linha + " \n";
        }
        return unicaLinha;
    }

    public void CriarArquivo(String url) {

        try {
            File arquivo = new File(url);
            arquivo.createNewFile();
        } catch (Exception erro) {
            System.out.println("Erro ao criar arquivo.");
        }
    }

    public List<String> LinhaExistentes() {

        List<String> result = new ArrayList<String>();

        try {
            Path path = Paths.get(url);
            result = Files.readAllLines(path);
        } catch (Exception erro) {
            System.out.println("Erro ao ler o arquivo.");
        }

        return result;
    }
    
    
    public List<String> LinhaExistentes(String caminho) {

        List<String> result = new ArrayList<String>();

        try {
            Path path = Paths.get(caminho);
            result = Files.readAllLines(path);
        } catch (Exception erro) {
            System.out.println("Erro ao ler o arquivo.");
        }

        return result;
    }
}
