package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Sum implements Function {
  private final Function a;
  private final Function b;

  public Sum(Function a, Function b) {
    this.a = a;
    this.b = b;
  }

  public Function getLeft() {
    return a;
  }

  public Function getRight() {
    return b;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitSum(this);
  }
}
