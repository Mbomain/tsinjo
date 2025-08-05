package examen.prog.tsinjo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import examen.prog.tsinjo.model.Payment;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentVerificationService {

  @Value("${vola.api-key}")
  private String volaApiKey;

  private static final String PAYMENT_API_URL =
      "https://42cwka3n4ifcp7ufheyrpmph240iuaxo.lambda-url.eu-west-3.on.aws/payment";
  private final ObjectMapper objectMapper = new ObjectMapper();

  public Optional<Payment> verifyPayment(String payerEmail, String pspPaymentId) {
    try {
      String url =
          PAYMENT_API_URL
              + "?apiKey="
              + volaApiKey
              + "&payerEmail="
              + payerEmail
              + "&pspType=ORANGE_MONEY"
              + "&pspPaymentId="
              + pspPaymentId;

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() == 200) {
        // Désérialisation JSON → Payment
        Payment payment = objectMapper.readValue(response.body(), Payment.class);
        return Optional.of(payment);
      } else {
        System.err.println("Erreur API paiement : code " + response.statusCode());
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return Optional.empty();
  }
}
