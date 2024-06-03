package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Multiplication implements Expression {

  private final Expression a;
  private final Expression b;

  public Multiplication(Expression a, Expression b) {
    this.a = a;
    this.b = b;
  }

  public Expression getRight() {
    return b;
  }

  public Expression getLeft() {
    return a;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitMultiplication(this);
  }
}
