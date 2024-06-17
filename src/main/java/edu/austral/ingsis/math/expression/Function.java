package edu.austral.ingsis.math.expression;

import edu.austral.ingsis.math.visitor.Visitor;

public interface Function {
  public <T> T accept(Visitor<T> visitor);
}
