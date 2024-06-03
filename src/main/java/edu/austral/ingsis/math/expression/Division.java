package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Division implements Expression {

  private final Expression dividend;
  private final Expression divisor;

  public Division(Expression dividend, Expression divisor) {
    this.dividend = dividend;
    this.divisor = divisor;
  }

  public Expression getDividend() {
    return dividend;
  }

  public Expression getDivisor() {
    return divisor;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitDivision(this);
  }
}
