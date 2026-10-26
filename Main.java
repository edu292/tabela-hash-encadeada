import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TabelaHashEncadeada tabela = new TabelaHashEncadeada(100);
        int seed = 1090;
        Random random = new Random(seed);
        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(100001);
            tabela.inserir(numero);
        }
        System.out.println("Maior lista encadeada:");
        tabela.imprimirMaiorLista();

        System.out.println();

        System.out.println("Listas encadeadas geradas: " + tabela.listasGeradas);

        System.out.println();

        System.out.println("Posições vazias: " + tabela.getPosicoesVazias());

        System.out.println();

        System.out.println("Últimos 3 valores inseridos em posições com colisão:");
        tabela.imprimirHistorico();
    }
}
