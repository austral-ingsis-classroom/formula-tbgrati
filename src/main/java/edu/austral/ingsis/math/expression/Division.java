package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Division implements Function {

  private final Function dividend;
  private final Function divisor;

  public Division(Function dividend, Function divisor) {
    this.dividend = dividend;
    this.divisor = divisor;
  }

  public Function getDividend() {
    return dividend;
  }

  public Function getDivisor() {
    return divisor;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitDivision(this);
  }
}
