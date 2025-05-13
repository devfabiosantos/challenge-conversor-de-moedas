import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiCambio {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/b343044e15054ec81fa2410e/latest/USD";

    public static Map<String, Double> obterTaxasDeCambio() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ExchangeRateResponse taxaResposta = gson.fromJson(response.body(), ExchangeRateResponse.class);

        return taxaResposta.conversionRates;
    }
    private static class ExchangeRateResponse {
        @SerializedName("conversion_rates")
        Map<String, Double> conversionRates;
    }
}
