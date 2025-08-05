package examen.prog.tsinjo.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "donation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "id")
public class Donation {

  @Id private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "donor_id", nullable = false)
  private Donor donor;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "payment_id", nullable = false)
  private Payment payment;

  @Column(name = "date_donation", nullable = false)
  private LocalDate dateDonation;

  @Column(name = "creation_instant", nullable = false)
  private Instant creationInstant;

  @PrePersist
  protected void onCreate() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
    if (creationInstant == null) {
      creationInstant = Instant.now();
    }
    if (dateDonation == null) {
      dateDonation = LocalDate.now();
    }
  }
}
