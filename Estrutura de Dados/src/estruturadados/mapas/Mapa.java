package estruturadados.mapas;

import estruturadados.listasligadas.ListaLigada;

import static java.lang.Math.abs;

public class Mapa<K, V> {

    public static final String A_CHAVE_S_NAO_EXISTE = "A chave %d nao existe";
    private ListaLigada<ListaLigada<Associacao<K, V>>> elementos;
    private static final int NUMERO_CATEGORIAS = 16;

    public Mapa() {
        this.elementos = new ListaLigada<ListaLigada<Associacao<K, V>>>();
        for (int i = 0; i < NUMERO_CATEGORIAS; i++) {
            this.elementos.inserir(new ListaLigada<Associacao<K, V>>());
        }
    }

    private int gerarNumeroEspalhamento(K chave) {
        return abs(chave.hashCode() % NUMERO_CATEGORIAS);
    }

    public boolean contemChave(K chave) {
        ListaLigada<Associacao<K, V>> categoria = getAssociacaoListaLigada(chave);

        for (int i = 0; i < categoria.getTamanho(); i++) {
            Associacao<K, V> associacao = categoria.recuperar(i);
            if (associacao.getChave().equals(chave)) {
                return true;
            }
        }
        return false;
    }

    private ListaLigada<Associacao<K, V>> getAssociacaoListaLigada(K chave) {
        int numeroEspalhamento = this.gerarNumeroEspalhamento(chave);
        return this.elementos.recuperar(numeroEspalhamento);
    }

    public void remover(K chave) {
        ListaLigada<Associacao<K, V>> categoria = getAssociacaoListaLigada(chave);
        for (int i = 0; i < categoria.getTamanho(); i++) {
            Associacao<K, V> associacao = categoria.recuperar(i);
            if (associacao.getChave().equals(chave)) {
                categoria.remover(associacao);
                return;
            }
        }
        throw new IllegalArgumentException(String.format(A_CHAVE_S_NAO_EXISTE, chave));
    }

    public void adicionar(K chave, V valor) {
        if (this.contemChave(chave)) {
            this.remover(chave);
        }
        ListaLigada<Associacao<K, V>> categoria = getAssociacaoListaLigada(chave);
        categoria.inserir(new Associacao<>(chave, valor));

    }

    public V recuperar(K chave) {
        ListaLigada<Associacao<K, V>> categoria = getAssociacaoListaLigada(chave);
        for (int i = 0; i < categoria.getTamanho(); i++) {
            Associacao<K, V> associacao = categoria.recuperar(i);
            if (associacao.getChave().equals(chave)) {
                return associacao.getValor();
            }
        }
        throw new IllegalArgumentException(String.format(A_CHAVE_S_NAO_EXISTE, chave));
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "elementos=" + elementos +
                '}';
    }
}
