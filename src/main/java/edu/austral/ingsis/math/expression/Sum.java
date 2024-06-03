package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Sum implements Expression {
  private final Expression a;
  private final Expression b;

  public Sum(Expression a, Expression b) {
    this.a = a;
    this.b = b;
  }

  public Expression getLeft() {
    return a;
  }

  public Expression getRight() {
    return b;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitSum(this);
  }
}
