package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public class Variable implements Function {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitVariable(this);
  }
}
