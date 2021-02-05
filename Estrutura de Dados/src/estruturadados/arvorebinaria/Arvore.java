package estruturadados.arvorebinaria;

import static java.util.Objects.isNull;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void inserir(NoArvore<T> no) {
        no.setNoDireito(null);
        no.setNoEsquerdo(null);

        if (isNull(raiz)) {
            raiz = no;
        } else {
            this.inserir(raiz, no);
        }
    }

    private void inserir(NoArvore<T> ref, NoArvore<T> novoNo) {
        if (ref.peso() < novoNo.peso()) {
            if (isNull(ref.getNoDireito())) {
                ref.setNoDireito(novoNo);
            } else {
                inserir(ref.getNoDireito(), novoNo);
            }
        } else {
            if (isNull(ref.getNoEsquerdo())) {
                ref.setNoEsquerdo(novoNo);
            } else {
                inserir(ref.getNoEsquerdo(), novoNo);
            }
        }
    }

    private NoArvore<T> buscar(NoArvore<T> ref, NoArvore<T> noBusca) {
        if (ref.valor.equals(noBusca.getValor())) {
            return ref;
        } else {
            if (ref.peso() < noBusca.peso()) {
                if (isNull(ref.getNoDireito())) {
                    throw new IllegalArgumentException("Elemento nao encontrado");
                } else {
                    System.out.println(">>> Navegando a direita no nó" + ref.getValor().toString());
                    return buscar(ref.getNoDireito(), noBusca);
                }
            } else {
                if (isNull(ref.getNoEsquerdo())) {
                    throw new IllegalArgumentException("Elemento nao encontrado");
                } else {
                    System.out.println(">>> Navegando a esquerda no nó" + ref.getValor().toString());
                    return buscar(ref.getNoEsquerdo(), noBusca);
                }
            }
        }

    }

    public NoArvore<T> buscar(NoArvore<T> noBusca) {
        return this.buscar(this.raiz, noBusca);
    }

    @Override
    public String toString() {
        return isNull(this.raiz) ? "[(X)]" : raiz.toString();
    }
}
