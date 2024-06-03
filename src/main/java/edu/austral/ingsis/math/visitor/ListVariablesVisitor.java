package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.expression.*;
import java.util.ArrayList;
import java.util.List;

public class ListVariablesVisitor implements Visitor<List<String>> {
  private final List<String> variables = new ArrayList<>();

  @Override
  public List<String> visitNumber(Numeric number) {
    return variables;
  }

  @Override
  public List<String> visitVariable(Variable variable) {
    variables.add(variable.name());
    return variables;
  }

  @Override
  public List<String> visitSum(Sum sum) {
    sum.getLeft().accept(this);
    sum.getRight().accept(this);
    return variables;
  }

  @Override
  public List<String> visitMultiplication(Multiplication multiplication) {
    multiplication.getLeft().accept(this);
    multiplication.getRight().accept(this);
    return variables;
  }

  @Override
  public List<String> visitModule(Mod module) {
    module.getExpression().accept(this);
    return variables;
  }

  @Override
  public List<String> visitDivision(Division division) {
    division.getDividend().accept(this);
    division.getDivisor().accept(this);
    return variables;
  }

  @Override
  public List<String> visitPower(Power power) {
    power.getPower().accept(this);
    power.getValue().accept(this);
    return variables;
  }

  @Override
  public List<String> visitSquareRoot(SquareRoot sqrtRoot) {
    sqrtRoot.getExpression().accept(this);
    return variables;
  }

  @Override
  public List<String> visitSubstraction(Substraction substraction) {
    substraction.getRight().accept(this);
    substraction.getLeft().accept(this);
    return variables;
  }
}
