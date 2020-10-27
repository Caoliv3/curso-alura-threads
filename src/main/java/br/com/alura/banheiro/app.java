package br.com.alura.banheiro;

import java.util.TreeMap;

public class app {

    public static void main(String[] args) {

        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "limpeza");
        limpeza.setDaemon(true);

        convidado1.start();
        convidado2.start();
        limpeza.start();
    }
}
