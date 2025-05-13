import java.util.Map;

public class ConversorDeMoedas {

    public static double converter(int opcao, double valor, Map<String, Double> taxas) {
        double taxa;
        switch (opcao) {
            case 1: // USD -> ARS
                taxa = taxas.get("ARS");
                return valor * taxa;
            case 2: // ARS -> USD
                taxa = taxas.get("ARS");
                return valor / taxa;
            case 3: // USD -> BRL
                taxa = taxas.get("BRL");
                return valor * taxa;
            case 4: // BRL -> USD
                taxa = taxas.get("BRL");
                return valor / taxa;
            case 5: // USD -> COP
                taxa = taxas.get("COP");
                return valor * taxa;
            case 6: // COP -> USD
                taxa = taxas.get("COP");
                return valor / taxa;
            default:
                throw new IllegalArgumentException("Opção de conversão inválida");
        }
    }

    public static String getMoedaOrigem(int opcao) {
        return switch (opcao) {
            case 1, 3, 5 -> "USD";
            case 2 -> "ARS";
            case 4 -> "BRL";
            case 6 -> "COP";
            default -> "";
        };
    }
    public static String getMoedaDestino(int opcao) {
        return switch (opcao) {
            case 1 -> "ARS";
            case 2, 4, 6 -> "USD";
            case 3 -> "BRL";
            case 5 -> "COP";
            default -> "";
        };
    }
}