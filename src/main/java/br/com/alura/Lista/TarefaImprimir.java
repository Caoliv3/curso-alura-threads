package br.com.alura.Lista;

public class TarefaImprimir implements Runnable {

    private Lista lista;

    public TarefaImprimir(Lista lista) {

        this.lista = lista;
    }

    @Override
    public void run() {

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        synchronized (lista) {
            if(!lista.estaCheia()) {
                try {
                    System.out.println("Eperar, Aguarndando notifcação");
                    lista.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < lista.tamanho(); i++) {
                System.out.println(i + " " + lista.pegaElemento(i));
            }
        }

    }
}
