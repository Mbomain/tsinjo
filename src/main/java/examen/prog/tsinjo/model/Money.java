package examen.prog.tsinjo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Money {
  private double amount;
  private Devise devise;
}
