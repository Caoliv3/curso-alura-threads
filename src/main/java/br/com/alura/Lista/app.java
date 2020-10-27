package br.com.alura.Lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class app {
    public static void main(String[] args) throws InterruptedException {

//        List<String> lista = new ArrayList<>();
//        List<String> lista = Collections.synchronizedList(new ArrayList<String>());
//        List<String> lista = new Vector<String>();
        Lista lista = new Lista();

        for (int i =0; i <10; i++){
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }

        new Thread(new TarefaImprimir(lista)).start();
//        Thread.sleep(2000);
//
//        for (int i =0; i <lista.tamanho(); i++){
//            System.out.println(i + " " + lista.pegaElemento(i));
//        }

    }
}
