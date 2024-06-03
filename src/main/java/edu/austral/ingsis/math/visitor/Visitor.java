package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.expression.*;

public interface Visitor<T> {
  T visitNumber(Numeric number);

  T visitVariable(Variable variable);

  T visitSum(Sum sum);

  T visitMultiplication(Multiplication multiplication);

  T visitModule(Mod module);

  T visitDivision(Division division);

  T visitPower(Power power);

  T visitSquareRoot(SquareRoot sqrtRoot);

  T visitSubstraction(Substraction substraction);
}
