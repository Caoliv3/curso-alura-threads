package br.com.alura.banheiro;

import sun.awt.X11.XkbAnyEvent;

public class TarefaLimpeza implements Runnable {

    private Banheiro banheiro;

    public TarefaLimpeza(Banheiro banheiro) {

        this.banheiro = banheiro;
    }


    @Override
    public void run() {
        while(true) {
            banheiro.limpa();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
