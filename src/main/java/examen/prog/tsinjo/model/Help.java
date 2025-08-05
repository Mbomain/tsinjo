package examen.prog.tsinjo.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "help")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "id")
public class Help {

  @Id private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "beneficiary_id", nullable = false)
  private Beneficiary beneficiary;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "payment_id", nullable = false)
  private Payment payment;

  @Column(name = "notif_help")
  private String notifHelp;

  @Column(name = "date_help", nullable = false)
  private LocalDate dateHelp;

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
    if (dateHelp == null) {
      dateHelp = LocalDate.now();
    }
  }
}
