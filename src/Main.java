import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Map<String, Double> taxas;

        try {
            taxas = ApiCambio.obterTaxasDeCambio();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao acessar API: " + e.getMessage());
            scanner.close();
            return;
        }

        do {
            System.out.println("*******************************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("*******************************************************\n");

            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Digite o Valor que deseja converter: \n");
                double valor = scanner.nextDouble();
                double resultado = ConversorDeMoedas.converter(opcao, valor, taxas);
                String origem = ConversorDeMoedas.getMoedaOrigem(opcao);
                String destino = ConversorDeMoedas.getMoedaDestino(opcao);
                System.out.printf("Valor %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]\n\n", valor, origem, resultado, destino);
            } else if (opcao == 7) {
                System.out.println("Obrigado por utilizar o Conversor de Moeda! Até logo!");
            } else {
                System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (opcao != 7);

        scanner.close();
    }
}
