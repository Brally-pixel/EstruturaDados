package estruturadados.filas;


import estruturadados.listasligadas.ListaLigada;

public class Filas<T> {

    private ListaLigada<T> elementos;

    public Filas(ListaLigada<T> elementos) {
        this.elementos = elementos;
    }

    public void enfileirar(T elemento) {
        elementos.inserir(elemento);
    }

    public T desenfileirar() {
        if (estaVazia()) {
            return null;
        }

        T resultado = elementos.recuperar(0);
        elementos.remover(0);
        return resultado;
    }

    public boolean estaVazia() {
        return elementos.estaVazia();
    }
}
