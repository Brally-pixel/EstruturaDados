package estruturadados.espalhamento;

import estruturadados.listasligadas.ListaLigada;

public class TabelaEspalhamento<T> {

    private ListaLigada<ListaLigada<T>> elementos;
    private int numeroCategorias = 16;

    public TabelaEspalhamento() {
        elementos = new ListaLigada<>();
        for (int i = 0; i < numeroCategorias; i++) {
            elementos.inserir(new ListaLigada<T>());
        }
    }

    public boolean inserir(T elemento){
        int numeroEspalhamento = gerarNumeroEspalhamento(elemento);
        ListaLigada<T> categoria = elementos.recuperar(numeroEspalhamento);
        if (categoria.contem(elemento)){
            return false;
        }
        categoria.inserir(elemento);
        return true;
    }

    private int gerarNumeroEspalhamento(T elemento){
        return elemento.hashCode() % 16;
    }
}
