class Node {
    int chave;
    Node proximo;

    Node(int chave) {
        this.chave = chave;
    }
}

public class TabelaHashEncadeada {
    private int tamanho;
    private Node[] tabela;
    private int indiceMaiorLista;
    private int tamanhoMaiorLista;
    public int listasGeradas;

    public int historico[];

    public TabelaHashEncadeada(int tamanho) {
        this.tabela = new Node[tamanho];
        this.tamanho = tamanho;
        this.historico = new int[3];
        this.indiceMaiorLista = -1;
        this.tamanhoMaiorLista = 0;
        this.listasGeradas = 0;
    }

    public void inserir(int chave) {
        int indice = chave % this.tamanho;

        Node fim = this.tabela[indice];
        Node inserido = new Node(chave);
        if (fim == null) {
            this.tabela[indice] = inserido;
            return;
        }

        int tamanho = 2;
        while (fim.proximo != null) {
            tamanho++;
            fim = fim.proximo;
        }
        if (tamanho == 2) {
            this.listasGeradas++;
        }

        if (tamanho > this.tamanhoMaiorLista) {
            this.indiceMaiorLista = indice;
            this.tamanhoMaiorLista = tamanho;
        }

        this.historico[0] = this.historico[1];
        this.historico[1] = this.historico[2];
        this.historico[2] = chave;

        fim.proximo = inserido;
    }

    public int getPosicoesVazias() {
        int posicoesVazias = 0;
        for (Node node : tabela) {
            if (node == null) {
                posicoesVazias++;
            }
        }

        return posicoesVazias;
    }

    public void imprimirMaiorLista() {
        if (this.indiceMaiorLista == -1) {
            return;
        }

        Node node = this.tabela[indiceMaiorLista];
        while (node != null) {
            System.out.print(node.chave + " ");
            node = node.proximo;
        }
        System.out.println();
    }

    public void imprimirHistorico() {
        for (int i = 0; i < historico.length; i++) {
            System.out.print(historico[i] + " ");
        }
        System.out.println();
    }
}
