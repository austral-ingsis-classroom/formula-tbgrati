package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public interface Expression {
  public <T> T accept(Visitor<T> visitor);
}
