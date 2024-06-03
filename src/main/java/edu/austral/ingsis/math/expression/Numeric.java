package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public record Numeric(double value) implements Expression {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitNumber(this);
  }
}
