package examen.prog.tsinjo.repository;

import examen.prog.tsinjo.model.Donor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, String> {
  Optional<Donor> findByEmail(String email);
}
