package br.com.alura.busca.textual;

public class app {
    public static void main(String[] args) {

        String nome = "da";

        Thread threadBuscaAss = new Thread(new TarefaBuscaTextaul("assinaturas1.txt",nome));
        Thread threadBuscaAss1 = new Thread(new TarefaBuscaTextaul("assinaturas2.txt",nome));
        Thread threadAutores = new Thread(new TarefaBuscaTextaul("autores.txt",nome));

        threadBuscaAss.start();
        threadBuscaAss1.start();
        threadAutores.start();
    }
}
