package br.com.alura.banco;

public class TarefaAcessaBancoProcedimento implements Runnable {

    private final PoolDeConexao pool;
    private final GerenciadorDeTransacao tx;

    public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {

        this.pool = pool;
        this.tx = tx;

    }

    @Override
    public void run() {

        synchronized (pool){
            System.out.println("pegue a conexao");
            pool.getConnection();

            synchronized (tx){

                System.out.println("começando a tx");
                tx.begin();
            }
        }

    }
}
