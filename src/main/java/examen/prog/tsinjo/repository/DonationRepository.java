package examen.prog.tsinjo.repository;

import examen.prog.tsinjo.model.Donation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationRepository extends JpaRepository<Donation, String> {

  @Override
  <S extends Donation> S save(S entity);

  @Query("SELECT d FROM Donation d ORDER BY d.dateDonation DESC")
  List<Donation> findAllOrdered();
}
