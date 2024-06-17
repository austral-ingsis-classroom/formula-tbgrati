package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class SquareRoot implements Function {

  private Function a;

  public SquareRoot(Function a) {
    this.a = a;
  }

  public Function getExpression() {
    return a;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitSquareRoot(this);
  }
}
