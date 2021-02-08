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

    public void emOrdem() {
        emOrdem(this.raiz);
    }

    private void emOrdem(NoArvore<T> ref) {
        if (!isNull(ref.getNoEsquerdo())) {
            emOrdem(ref.getNoEsquerdo());
            System.out.println(ref.getValor().toString());
            if (!isNull(ref.getNoDireito())) {
                emOrdem(ref.getNoDireito());
            }
        } else {
            System.out.println(ref.getValor().toString());
            if (!isNull(ref.getNoDireito())) {
                emOrdem(ref.getNoDireito());
            }
        }
    }

    public void preOrdem() {
        preOrdem(this.raiz);

    }

    private void preOrdem(NoArvore<T> ref) {
        System.out.println(ref.getValor().toString());
        if (!isNull(ref.getNoEsquerdo())) {
            preOrdem(ref.getNoEsquerdo());
            if (!isNull(ref.getNoDireito())) {
                preOrdem(ref.getNoDireito());

            }
        } else {
            if (!isNull(ref.getNoDireito())) {
                preOrdem(ref.getNoDireito());
            }
        }

    }

    public void posOrdem() {
        posOrdem(this.raiz);
    }

    private void posOrdem(NoArvore<T> ref) {
        if (!isNull(ref.getNoEsquerdo())) {
            posOrdem(ref.getNoEsquerdo());
            if (!isNull(ref.getNoDireito())) {
                posOrdem(ref.getNoDireito());
            }
            System.out.println(ref.getValor().toString());
        } else {
            if (!isNull(ref.getNoDireito())) {
                posOrdem(ref.getNoDireito());
                System.out.println(ref.getValor().toString());
            } else {
                System.out.println(ref.getValor().toString());
            }
        }
    }
    public int altura (){
        return altura(raiz);
    }

    private int altura(NoArvore<T> ref) {

        if (isNull(ref)) {
            return -1;
        }
        int altEsquerda = altura(ref.getNoEsquerdo());
        int altDireita = altura(ref.getNoDireito());
        return altEsquerda > altDireita ? altEsquerda + 1 : altDireita + 1;
    }

    public NoArvore<T> buscar(NoArvore<T> noBusca) {
        return this.buscar(this.raiz, noBusca);
    }

    @Override
    public String toString() {
        return isNull(this.raiz) ? "[(X)]" : raiz.toString();
    }
}
