package examen.prog.tsinjo.repository;

import examen.prog.tsinjo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {}
