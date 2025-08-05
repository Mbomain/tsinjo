package examen.prog.tsinjo.services;

import examen.prog.tsinjo.dto.DonationRequest;
import examen.prog.tsinjo.model.Donation;
import examen.prog.tsinjo.model.Donor;
import examen.prog.tsinjo.model.Payment;
import examen.prog.tsinjo.repository.DonationRepository;
import examen.prog.tsinjo.repository.DonorRepository;
import examen.prog.tsinjo.repository.PaymentRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationService {

  private final DonationRepository donationRepo;
  private final DonorRepository donorRepo;
  private final PaymentRepository paymentRepo;

  public void saveDonation(DonationRequest req) {
    Donor donor =
        donorRepo
            .findByEmail(req.getDonorEmail())
            .orElseGet(
                () ->
                    Donor.builder()
                        .id(
                            req.getDonorId() != null
                                ? req.getDonorId()
                                : UUID.randomUUID().toString())
                        .fullName(req.getDonorName())
                        .email(req.getDonorEmail())
                        .creationInstant(Instant.now())
                        .build());
    Payment payment =
        paymentRepo
            .findById(req.getPaymentId())
            .orElseGet(
                () ->
                    Payment.builder()
                        .paymentId(req.getPaymentId())
                        .devise(req.getDevise())
                        .typePayment(req.getTypePayment())
                        .amount(req.getAmount())
                        .build());

    Donation donation =
        Donation.builder()
            .donor(donor)
            .payment(payment)
            .dateDonation(LocalDate.now())
            .creationInstant(Instant.now())
            .build();

    donorRepo.save(donor);
    paymentRepo.save(payment);
    donationRepo.save(donation);
  }

  public List<Donation> getAllDonations() {
    return donationRepo.findAllOrdered();
  }
}
