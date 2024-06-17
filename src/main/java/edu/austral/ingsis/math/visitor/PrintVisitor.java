package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.expression.*;

public class PrintVisitor implements Visitor<String> {

  private String addParenthesis(String string, Function function) {
    if (function instanceof Numeric) {
      return string;
    } else if (function instanceof Variable) {
      return string;
    } else if (function instanceof Mod) {
      return string;
    }
    return "(" + string + ")";
  }

  @Override
  public String visitNumber(Numeric number) {
    return String.valueOf((int) number.value());
  }

  @Override
  public String visitVariable(Variable variable) {
    return variable.name();
  }

  @Override
  public String visitSum(Sum sum) {
    String left = addParenthesis(sum.getLeft().accept(this), sum.getLeft());
    String right = addParenthesis(sum.getRight().accept(this), sum.getRight());
    return left + " + " + right;
  }

  @Override
  public String visitMultiplication(Multiplication multiplication) {
    String left = addParenthesis(multiplication.getLeft().accept(this), multiplication.getLeft());
    String right =
        addParenthesis(multiplication.getRight().accept(this), multiplication.getRight());
    return left + " * " + right;
  }

  @Override
  public String visitModule(Mod module) {
    String exp = addParenthesis(module.getExpression().accept(this), module.getExpression());
    return "|" + exp + "|";
  }

  @Override
  public String visitDivision(Division division) {
    String dividend = addParenthesis(division.getDividend().accept(this), division.getDividend());
    String divisor = addParenthesis(division.getDivisor().accept(this), division.getDivisor());

    return dividend + " / " + divisor;
  }

  @Override
  public String visitPower(Power power) {
    String value = addParenthesis(power.getValue().accept(this), power.getValue());
    String pow = addParenthesis(power.getPower().accept(this), power.getPower());
    return value + " ^ " + pow;
  }

  @Override
  public String visitSquareRoot(SquareRoot sqrtRoot) {
    return "sqrt(" + sqrtRoot.getExpression().accept(this) + ")";
  }

  @Override
  public String visitSubstraction(Substraction substraction) {
    String left = addParenthesis(substraction.getLeft().accept(this), substraction.getLeft());
    String right = addParenthesis(substraction.getRight().accept(this), substraction.getRight());
    return left + " - " + right;
  }
}
