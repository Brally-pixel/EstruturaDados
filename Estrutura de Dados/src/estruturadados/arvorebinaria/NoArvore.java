package estruturadados.arvorebinaria;

import static java.util.Objects.isNull;

public abstract class NoArvore<T> {

    protected T valor;
    private NoArvore<T> noEsquerdo;
    private NoArvore<T> noDireito;

    public NoArvore(T valor) {
        this.valor = valor;
        this.noEsquerdo = null;
        this.noDireito = null;
    }

    public T getValor() {
        return valor;
    }


    public NoArvore<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(NoArvore<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public NoArvore<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(NoArvore<T> noDireito) {
        this.noDireito = noDireito;
    }

    public abstract int peso();

    @Override
    public String toString() {
        return (isNull(this.noEsquerdo) ? "[(X)]" : "[(" + this.noEsquerdo.toString() + ")]") +
                "[(" + this.valor.toString() + ")]" +
                (isNull(this.noDireito) ? "[(X)]" : "[(" + this.noDireito.toString() + ")]");
    }
}
