package estruturadados.pilhas;


public class Pilha<T> {
    private estruturadados.ListasLigadas.ListaDuplamenteLigada<T> elementos;

    public Pilha(estruturadados.ListasLigadas.ListaDuplamenteLigada<T> elementos) {
        this.elementos = elementos;
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
