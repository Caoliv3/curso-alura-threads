package br.com.alura.busca.textual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextaul implements Runnable {

    private String nomeArquivo;
    private String nomeAutor;

    public TarefaBuscaTextaul(String nomeArquivo, String nomeAutor) {
        this.nomeArquivo = nomeArquivo;
        this.nomeAutor = nomeAutor;
    }

    @Override
    public void run() {

        try {
            Scanner scanner = new Scanner(new File(nomeArquivo));

            int numeroLinha = 1;

            while(scanner.hasNext()){
                String linha = scanner.nextLine();
                if(linha.toLowerCase().contains(nomeAutor.toLowerCase())){
                    System.out.println(nomeArquivo + " - " + numeroLinha + " - "  +linha );
                }
                numeroLinha++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
