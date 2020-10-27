package br.com.alura.banheiro;

public class Banheiro {

    private boolean sujobanheiro = true;

    public void fazNumero1(){

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Batendo na porta");

        synchronized (this){
            System.out.println(nome + " entrando no banheiro");

            while(sujobanheiro){
                EsperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa rapida");

            dormeUmPouco(5000);

            this.sujobanheiro = true;

            System.out.println(nome + " descarga");
            System.out.println(nome + " lavando a mao");
            System.out.println(nome + " saindo do banheiro");

        }
    }

    public void limpa(){
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");
            if (this.sujobanheiro=false){
                System.out.println(nome + " nao esta sujo, saindo");
                return;
            }

            System.out.println(nome + " Limpando o banheiro");
            this.sujobanheiro = false;

            dormeUmPouco(10000);

            this.notifyAll();
            System.out.println(nome + " saindo do banheiro");
        }

    }

    private void EsperaLaFora(String nome) {
        System.out.println(nome + ", eca banheiro esta sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fazNumero2(){

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Batendo na porta");

        synchronized (this){
            System.out.println(nome + " entrando no banheiro");

            while(sujobanheiro){
                EsperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa demorada");

            dormeUmPouco(10000);

            this.sujobanheiro = true;

            System.out.println(nome + " descarga");
            System.out.println(nome + " lavando a mao");
            System.out.println(nome + " saindo do banheiro");
        }

    }

    private void dormeUmPouco(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
