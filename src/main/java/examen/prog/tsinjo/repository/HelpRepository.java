package examen.prog.tsinjo.repository;

import examen.prog.tsinjo.model.Help;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HelpRepository extends JpaRepository<Help, String> {
  @Query("SELECT h FROM Help h ORDER BY h.date DESC")
  List<Help> findAllOrdered();
}
