package examen.prog.tsinjo.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "paymentId")
public class Payment {

  @Id
  @Column(name = "payment_id")
  private String paymentId;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(name = "devise", nullable = false)
  private String devise;

  @Column(name = "type_payment", nullable = false)
  private String typePayment;

  @Column(name = "payment_status", nullable = false)
  private String paymentStatus;

  @Column(name = "creation_instant", nullable = false)
  private Instant creationInstant;

  @PrePersist
  protected void onCreate() {
    if (paymentId == null) {
      paymentId = UUID.randomUUID().toString();
    }
    if (creationInstant == null) {
      creationInstant = Instant.now();
    }
  }
}
