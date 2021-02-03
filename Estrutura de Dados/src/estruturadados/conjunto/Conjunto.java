package estruturadados.conjunto;


import estruturadados.espalhamento.TabelaEspalhamento;

public class Conjunto<T> {

    private TabelaEspalhamento<T> elementos;

    public Conjunto(TabelaEspalhamento<T> elementos) {
        this.elementos = elementos;
    }

    public Conjunto() {

    }

    public boolean inserir(T elemento) {
        return elementos.inserir(elemento);
    }


    public boolean estaVazio() {
        return elementos.getTamanho() == 0;
    }

    public int tamanho() {
        return elementos.getTamanho();
    }

    public boolean contem(T elemento) {
        return elementos.contem(elemento);
    }

    public void remover(T elemento) {
        elementos.remover(elemento);
    }

//    private boolean contemOtimizado(T elemento) {
//        for (int i = 0; i < elementos.getTamanho(); i++) {
//            T el = elementos.recuperar(i);
//            if (el.hashCode() == elemento.hashCode()) {
//                return true;
//            }
//        }
//        return false;
//    }

}
