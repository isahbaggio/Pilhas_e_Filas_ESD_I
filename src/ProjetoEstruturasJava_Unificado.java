// Questão 01 - Implementação da Pilha

public class Pilha<T> {
    private T[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        topo = -1;
    }

    public void empilhar(T elemento) {
        if (topo < elementos.length - 1) {
            elementos[++topo] = elemento;
        } else {
            System.out.println("Pilha cheia!");
        }
    }

    public T desempilhar() {
        if (!estaVazia()) {
            return elementos[topo--];
        }
        System.out.println("Pilha vazia!");
        return null;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public T topo() {
        if (!estaVazia()) return elementos[topo];
        return null;
    }
}

// Questão 02 - Editor de Texto com Desfazer/Refazer

class EditorTexto {
    private Pilha<String> pilhaDesfazer;
    private Pilha<String> pilhaRefazer;
    private String textoAtual;

    public EditorTexto(int capacidade) {
        pilhaDesfazer = new Pilha<>(capacidade);
        pilhaRefazer = new Pilha<>(capacidade);
        textoAtual = "";
    }

    public void inserirTexto(String novoTexto) {
        pilhaDesfazer.empilhar(textoAtual);
        textoAtual += novoTexto;
        pilhaRefazer = new Pilha<>(pilhaRefazer.elementos.length); 
    }

    public void desfazer() {
        if (!pilhaDesfazer.estaVazia()) {
            pilhaRefazer.empilhar(textoAtual);
            textoAtual = pilhaDesfazer.desempilhar();
        }
    }

    public void refazer() {
        if (!pilhaRefazer.estaVazia()) {
            pilhaDesfazer.empilhar(textoAtual);
            textoAtual = pilhaRefazer.desempilhar();
        }
    }

    public void mostrarTexto() {
        System.out.println("Texto atual: " + textoAtual);
    }
}

class MainEditor {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto(10);

        editor.inserirTexto("Olá");
        editor.mostrarTexto();

        editor.inserirTexto(" Mundo");
        editor.mostrarTexto();

        editor.desfazer();
        editor.mostrarTexto();

        editor.refazer();
        editor.mostrarTexto();

        editor.inserirTexto("!!!");
        editor.mostrarTexto();

        editor.desfazer();
        editor.desfazer();
        editor.mostrarTexto();
    }
}

// Questão 03 - Implementação da Fila

class Fila<T> {
    private T[] elementos;
    private int inicio, fim, tamanho;

    public Fila(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enfileirar(T elemento) {
        if (tamanho < elementos.length) {
            elementos[fim] = elemento;
            fim = (fim + 1) % elementos.length;
            tamanho++;
        } else {
            System.out.println("Fila cheia!");
        }
    }

    public T desenfileirar() {
        if (!estaVazia()) {
            T temp = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return temp;
        }
        System.out.println("Fila vazia!");
        return null;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }
}

// Questão 04 - Fila de Impressão

class Documento {
    private String nome;
    private int tamanho;

    public Documento(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String toString() {
        return nome + " (" + tamanho + "KB)";
    }
}

class FilaImpressao {
    private Fila<Documento> fila;

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
}

class MainImpressao {
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