package estruturadados.pilhas;


import estruturadados.listasligadas.ListaDuplamenteLigada;

public class Pilha<T> {
    private ListaDuplamenteLigada<T> elementos;

    public Pilha(ListaDuplamenteLigada<T> elementos) {
        this.elementos = elementos;
    }

    public Pilha() {
    }

    public boolean estaVazia() {
        return elementos.estaVazia();
    }

    public void empilhar(T elemento) {
        elementos.inserir(elemento);
    }

    public T desempilhar() {
        if (estaVazia()) {
            return null;
        }
        T resultado = elementos.recuperar(elementos.getTamanho() - 1);
        elementos.remover(resultado);

        return resultado;
    }
}
