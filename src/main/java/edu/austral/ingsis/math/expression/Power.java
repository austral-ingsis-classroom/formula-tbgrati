package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Power implements Expression {
  private final Expression value;
  private final Expression power;

  public Power(Expression value, Expression power) {
    this.value = value;
    this.power = power;
  }

  public Expression getValue() {
    return value;
  }

  public Expression getPower() {
    return power;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitPower(this);
  }
}
