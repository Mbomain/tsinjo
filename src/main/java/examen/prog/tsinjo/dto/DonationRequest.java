package examen.prog.tsinjo.dto;

import lombok.Data;

@Data
public class DonationRequest {
  private String donorId;
  private String donorName;
  private String donorEmail;
  private String paymentId;
  private double amount;
  private String devise;
  private String typePayment;
}
