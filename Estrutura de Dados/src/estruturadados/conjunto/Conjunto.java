package estruturadados.conjunto;


import estruturadados.listasligadas.ListaLigada;

import static java.util.Objects.isNull;

public class Conjunto<T> {

    private ListaLigada<T> elementos;

    public Conjunto(ListaLigada<T> elementos) {
        this.elementos = elementos;
    }

    public boolean inserir(T elemento) {
        if (!isNull(elemento) && !contemOtimizado(elemento)) {
            elementos.inserir(elemento);
            return true;
        }
        return false;
    }

    public boolean inserirEm(int posicao, T elemento) {
        if (!contemOtimizado(elemento)) {
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

    private boolean contemOtimizado(T elemento){
        for (int i = 0; i < elementos.getTamanho(); i++) {
            T el = elementos.recuperar(i);
            if (el.hashCode() == elemento.hashCode()){
                return true;
            }
        }
        return false;
    }

}
