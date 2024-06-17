package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Multiplication implements Function {

  private final Function a;
  private final Function b;

  public Multiplication(Function a, Function b) {
    this.a = a;
    this.b = b;
  }

  public Function getRight() {
    return b;
  }

  public Function getLeft() {
    return a;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitMultiplication(this);
  }
}
