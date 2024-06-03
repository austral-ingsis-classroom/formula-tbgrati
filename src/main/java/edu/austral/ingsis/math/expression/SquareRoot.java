package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class SquareRoot implements Expression {

  private Expression a;

  public SquareRoot(Expression a) {
    this.a = a;
  }

  public Expression getExpression() {
    return a;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitSquareRoot(this);
  }
}
