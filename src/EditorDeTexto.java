class EditorTexto {
    private final Pilha<String> pilhaDesfazer;
    private final Pilha<String> pilhaRefazer;
    private String textoAtual;

    public EditorTexto(int capacidade) {
        pilhaDesfazer = new Pilha<>(capacidade);
        pilhaRefazer = new Pilha<>(capacidade);
        textoAtual = "";
    }

    public void inserirTexto(String novoTexto) {
        pilhaDesfazer.empilhar(textoAtual);
        textoAtual += novoTexto;
        while (!pilhaRefazer.estaVazia()) {
            pilhaRefazer.desempilhar(); // Esvazia a pilha de refazer
        }
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