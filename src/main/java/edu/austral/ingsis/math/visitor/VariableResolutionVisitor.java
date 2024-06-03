package edu.austral.ingsis.math.visitor;

import static java.lang.Math.*;

import edu.austral.ingsis.math.expression.*;
import java.util.Map;

public class VariableResolutionVisitor implements Visitor<Double> {
  private final Map<String, Number> variables;

  public VariableResolutionVisitor(Map<String, Number> variables) {
    this.variables = variables;
  }

  @Override
  public Double visitNumber(Numeric number) {
    return number.value();
  }

  @Override
  public Double visitVariable(Variable variable) {
    if (variables.containsKey(variable.name())) {
      return variables.get(variable.name()).doubleValue();
    } else {
      throw new IllegalArgumentException("Variable " + variable.name() + " not found.");
    }
  }

  public Double visitSum(Sum sum) {
    return sum.getLeft().accept(this) + sum.getRight().accept(this);
  }

  @Override
  public Double visitMultiplication(Multiplication multiplication) {
    return multiplication.getLeft().accept(this) * multiplication.getRight().accept(this);
  }

  @Override
  public Double visitModule(Mod module) {
    return abs(module.getExpression().accept(this));
  }

  @Override
  public Double visitDivision(Division division) {
    return division.getDividend().accept(this) / division.getDivisor().accept(this);
  }

  @Override
  public Double visitPower(Power power) {
    return pow(power.getValue().accept(this), power.getPower().accept(this));
  }

  @Override
  public Double visitSquareRoot(SquareRoot sqrtRoot) {
    return sqrt(sqrtRoot.getExpression().accept(this));
  }

  @Override
  public Double visitSubstraction(Substraction substraction) {
    return substraction.getLeft().accept(this) - substraction.getRight().accept(this);
  }
}
