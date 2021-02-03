package EstruturaDados1.ListasLigadas;

public class ListaDuplamenteLigada<T> {

    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaDuplamenteLigada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public void inserir(T elemento) {
        No<T> novoNo = new No<T>(elemento);
        if (estaVazia()) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(ultimoNo);
            ultimoNo = novoNo;
        }
        tamanho++;
    }

    public void inserirEm(int posicao, T elemento) {
        if (posicao >= tamanho) {
            throw new IllegalArgumentException(String.format("Posicao invalida [%d]", posicao));
        }
        if (posicao == 0) {
            No<T> novoNo = new No<T>(elemento);
            novoNo.setProximo(primeiroNo);
            primeiroNo.setAnterior(novoNo);
            primeiroNo = novoNo;
        } else if (posicao == getTamanho() - 1) {
            No<T> novoNo = new No<T>(elemento);
            ultimoNo.setProximo(novoNo);
            novoNo.setAnterior(ultimoNo);
            ultimoNo = novoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> noAtual = recuperarNo(posicao);
            No<T> novoNo = new No<T>(elemento);
            noAnterior.setProximo(novoNo);
            novoNo.setProximo(noAtual);
            noAtual.setAnterior(novoNo);
            novoNo.setAnterior(noAnterior);
        }
    }

    public T recuperar(int posicao) {
        No<T> no = recuperarNo(posicao);
        if (no != null) {
            return no.getElemento();
        }
        return null;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    private No<T> recuperarNo(int posicao) {
        if (posicao >= getTamanho()) {
            throw new IllegalArgumentException(String.format("Posicao invalida [%d]", posicao));
        }
        No<T> resultado = null;
        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                resultado = primeiroNo;
            } else {
                resultado = resultado.getProximo();
            }
        }
        return resultado;
    }

    public boolean contem(T elemento) {
        for (int i = 0; i < getTamanho(); i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int indice(T elemento) {
        for (int i = 0; i < getTamanho(); i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void remover(int posicao) {
        if (posicao >= getTamanho()) {
            throw new IllegalArgumentException(String.format("Posicao invalida [%d]", posicao));
        }
        if (posicao == 0) {
            No<T> proximoNo = primeiroNo.getProximo();
            primeiroNo.setProximo(null);
            proximoNo.setAnterior(null);
            primeiroNo = proximoNo;
        } else if (posicao == getTamanho() - 1) {
            No<T> penultimoNo = ultimoNo.getAnterior();
            penultimoNo.setProximo(null);
            ultimoNo.setAnterior(null);
            ultimoNo = penultimoNo;
        } else {
            No<T> noAtual = recuperarNo(posicao);
            No<T> noAnterior = noAtual.getAnterior();
            No<T> proximoNo = noAtual.getProximo();
            noAnterior.setProximo(proximoNo);
            proximoNo.setAnterior(noAnterior);
            noAtual.setProximo(null);
            noAtual.setAnterior(null);
        }
        tamanho--;
    }

    public void remover(T elemento) {
        int indice = indice(elemento);
        if (indice == -1) {
            throw new IllegalArgumentException(String.format("elemento invalida [%d]", elemento.toString()));
        }
        remover(indice);
    }


    @Override
    public String toString() {
        if (estaVazia()) {
            return "ListaLigada{}";
        } else {
            No<T> noAtual = primeiroNo;
            StringBuilder sb = new StringBuilder();
            sb.append("Lista [");
            sb.append(noAtual.getElemento() != null ? noAtual.getElemento().toString() : "<NULO>");
            sb.append(",");
            while (noAtual.getElemento() != null) {
                sb.append(noAtual.getProximo().getElemento() != null ? noAtual.getProximo().getElemento().toString() : "<NULO>");
                sb.append(",");
                noAtual = noAtual.getProximo();
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
