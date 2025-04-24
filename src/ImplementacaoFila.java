class Fila<T> {
    private final T[] elementos;
    private int inicio, fim, tamanho;

    public Fila(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enfileirar(T elemento) {
        if (!estaCheia()) {
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

    public boolean estaCheia() {
        return tamanho == elementos.length;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Fila: [");
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[(inicio + i) % elementos.length]);
            if (i < tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
