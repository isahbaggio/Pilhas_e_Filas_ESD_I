import java.util.LinkedList;
import java.util.Queue;

class Documento {
    private final String nome;
    private final int tamanho;

    public Documento(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return nome + " (" + tamanho + "KB)";
    }
}

class Fila<T> {
    private final Queue<T> fila;
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new LinkedList<>();
    }

    public boolean enfileirar(T elemento) {
        if (fila.size() < capacidade) {
            fila.add(elemento);
            return true;
        } else {
            System.out.println("Fila cheia! Não é possível adicionar mais elementos.");
            return false;
        }
    }

    public T desenfileirar() {
        if (!fila.isEmpty()) {
            return fila.poll();
        } else {
            System.out.println("Fila vazia! Não há elementos para remover.");
            return null;
        }
    }

    public int tamanho() {
        return fila.size();
    }
}

class FilaImpressao {
    private final Fila<Documento> fila;

    public FilaImpressao(int capacidade) {
        fila = new Fila<>(capacidade);
    }

    public void adicionarDocumento(Documento doc) {
        fila.enfileirar(doc);
    }

    public void imprimirProximo() {
        Documento doc = fila.desenfileirar();
        if (doc != null) {
            System.out.println("Imprimindo: " + doc);
        }
    }

    public void mostrarFila() {
        System.out.println("Documentos na fila: " + fila.tamanho());
    }

    public static void main(String[] args) {
        FilaImpressao impressora = new FilaImpressao(5);

        impressora.adicionarDocumento(new Documento("Trabalho1", 200));
        impressora.adicionarDocumento(new Documento("Relatório", 150));
        impressora.adicionarDocumento(new Documento("Foto", 300));

        impressora.mostrarFila();

        impressora.imprimirProximo();
        impressora.imprimirProximo();

        impressora.mostrarFila();
    }
}
