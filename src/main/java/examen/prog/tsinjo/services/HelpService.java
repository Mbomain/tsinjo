package examen.prog.tsinjo.services;

import examen.prog.tsinjo.model.Help;
import examen.prog.tsinjo.repository.HelpRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelpService {
  private final HelpRepository helpRepo;

  public List<Help> getAllHelps() {
    return helpRepo.findAllOrdered();
  }
}
