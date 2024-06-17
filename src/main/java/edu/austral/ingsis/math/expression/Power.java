package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Power implements Function {
  private final Function value;
  private final Function power;

  public Power(Function value, Function power) {
    this.value = value;
    this.power = power;
  }

  public Function getValue() {
    return value;
  }

  public Function getPower() {
    return power;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitPower(this);
  }
}
