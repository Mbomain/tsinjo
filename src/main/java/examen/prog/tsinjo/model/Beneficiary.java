package examen.prog.tsinjo.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "beneficiary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "helps")
@EqualsAndHashCode(of = "id")
public class Beneficiary {

  @Id private String id;

  @Column(name = "full_name", nullable = false)
  private String fullName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "creation_instant", nullable = false)
  private Instant creationInstant;

  @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @Builder.Default
  private List<Help> helps = new ArrayList<>();

  @PrePersist
  protected void onCreate() {
    if (id == null) {
      id = UUID.randomUUID().toString();
    }
    if (creationInstant == null) {
      creationInstant = Instant.now();
    }
  }
}
