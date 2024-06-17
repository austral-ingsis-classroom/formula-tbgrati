package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public record Variable(String name) implements Function {

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitVariable(this);
  }
}
