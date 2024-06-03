package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.expression.*;
import edu.austral.ingsis.math.visitor.PrintVisitor;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    PrintVisitor printVisitor = new PrintVisitor();
    Sum sum = new Sum(new Numeric(1), new Numeric(6));
    final String result = printVisitor.visitSum(sum);

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    PrintVisitor printVisitor = new PrintVisitor();
    Division division = new Division(new Numeric(12), new Numeric(2));
    final String result = printVisitor.visitDivision(division);

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    PrintVisitor printVisitor = new PrintVisitor();
    Division division = new Division(new Numeric(9), new Numeric(2));
    Multiplication mult = new Multiplication(division, new Numeric(3));
    final String result = printVisitor.visitMultiplication(mult);

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    PrintVisitor printVisitor = new PrintVisitor();
    Division division = new Division(new Numeric(27), new Numeric(6));
    Power pow = new Power(division, new Numeric(2));
    final String result = printVisitor.visitPower(pow);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    PrintVisitor printVisitor = new PrintVisitor();
    Mod module = new Mod(new Variable("value"));
    Substraction substraction = new Substraction(module, new Numeric(8));
    final String result = printVisitor.visitSubstraction(substraction);

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "(5 - i) * 8";
    PrintVisitor printVisitor = new PrintVisitor();
    Substraction substraction = new Substraction(new Numeric(5), new Variable("i"));
    Multiplication mult = new Multiplication(substraction, new Numeric(8));
    final String result = printVisitor.visitMultiplication(mult);

    assertThat(result, equalTo(expected));
  }
}
