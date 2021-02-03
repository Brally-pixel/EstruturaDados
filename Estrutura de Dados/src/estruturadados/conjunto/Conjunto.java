package estruturadados.conjunto;


import estruturadados.listasligadas.ListaLigada;

import static java.util.Objects.isNull;

public class Conjunto<T> {

    private ListaLigada<T> elementos;

    public Conjunto(ListaLigada<T> elementos) {
        this.elementos = elementos;
    }

    public boolean inserir(T elemento) {
        if (!isNull(elemento) && !contem(elemento)) {
            elementos.inserir(elemento);
            return true;
        }
        return false;
    }

    public boolean inserirEm(int posicao, T elemento) {
        if (!contem(elemento)) {
            elementos.inserirEm(posicao, elemento);
            return true;
        }
        return false;
    }

    public T recuperar(int posicao) {
        return elementos.recuperar(posicao);
    }

    public boolean estaVazio() {
        return elementos.estaVazia();
    }

    public int tamanho() {
        return elementos.getTamanho();
    }

    public boolean contem(T elemento) {
        return elementos.contem(elemento);
    }

    public int indice(T elemento) {
        return elementos.indice(elemento);
    }

    public void remover(int posicao) {
        elementos.remover(posicao);
    }

    public void remover(T elemento) {
        elementos.remover(elemento);
    }

}
