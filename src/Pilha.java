public class Pilha<T> {
    private final T[] elementos;
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