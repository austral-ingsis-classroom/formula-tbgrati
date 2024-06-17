package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Numeric implements Function {

  private final double value;

  public Numeric(double num) {
    this.value = num;
  }

  public double value() {
    return value;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitNumber(this);
  }
}
