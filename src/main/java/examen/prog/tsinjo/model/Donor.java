package examen.prog.tsinjo.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "donor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "donations")
@EqualsAndHashCode(of = "id")
public class Donor {

  @Id private String id;

  @Column(name = "full_name", nullable = false)
  private String fullName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "creation_instant", nullable = false)
  private Instant creationInstant;

  @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @Builder.Default
  private List<Donation> donations = new ArrayList<>();

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
