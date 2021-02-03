package estruturadados.espalhamento;

import estruturadados.listasligadas.ListaLigada;

import static java.lang.Math.abs;
import static java.util.Objects.isNull;

public class TabelaEspalhamento<T> {

    private ListaLigada<ListaLigada<T>> elementos;
    private static final int NUMERO_CATEGORIAS = 16;
    private int tamanho;

    public TabelaEspalhamento() {
        elementos = new ListaLigada<>();
        for (int i = 0; i < NUMERO_CATEGORIAS; i++) {
            elementos.inserir(new ListaLigada<T>());
        }
        tamanho = 0;
    }

    public boolean inserir(T elemento) {
        if (isNull(elemento) || contem(elemento)) {
            return false;
        }
        ListaLigada<T> categoria = gettListaLigada(elemento);
        categoria.inserir(elemento);
        tamanho++;
        return true;
    }

    private int gerarNumeroEspalhamento(T elemento) {
        return abs(elemento.hashCode() % NUMERO_CATEGORIAS);
    }

    public void remover(T elemento) {
        ListaLigada<T> categoria = gettListaLigada(elemento);
        categoria.remover(elemento);
        tamanho--;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean contem(T elemento) {
        ListaLigada<T> categoria = gettListaLigada(elemento);
        return categoria.contem(elemento);
    }

    private ListaLigada<T> gettListaLigada(T elemento) {
        int numeroEspalhamento = gerarNumeroEspalhamento(elemento);
        return elementos.recuperar(numeroEspalhamento);
    }

    @Override
    public String toString() {
        return "TabelaEspalhamento{" +
                "elementos=" + elementos +
                '}';
    }
}
