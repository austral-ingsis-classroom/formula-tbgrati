package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.expression.*;
import edu.austral.ingsis.math.visitor.VariableResolutionVisitor;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Map<String, Number> variables = Map.of("x", 3);
    final VariableResolutionVisitor varResVisitor = new VariableResolutionVisitor(variables);
    final Sum sum = new Sum(new Numeric(1), new Variable("x"));
    final Double result = varResVisitor.visitSum(sum);

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Map<String, Number> variables = Map.of("div", 4);
    final VariableResolutionVisitor varResVisitor = new VariableResolutionVisitor(variables);
    final Division division = new Division(new Numeric(12), new Variable("div"));
    final Double result = varResVisitor.visitDivision(division);

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Map<String, Number> variables =
        Map.of(
            "x", 3,
            "y", 4);
    final VariableResolutionVisitor varResVisitor = new VariableResolutionVisitor(variables);
    final Division division = new Division(new Numeric(9), new Variable("x"));
    final Multiplication mult = new Multiplication(division, new Variable("y"));
    final Double result = varResVisitor.visitMultiplication(mult);

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Map<String, Number> variables =
        Map.of(
            "a", 9,
            "b", 3);
    final VariableResolutionVisitor varResVisitor = new VariableResolutionVisitor(variables);
    final Division division = new Division(new Numeric(27), new Variable("a"));
    final Power power = new Power(division, new Variable("b"));
    final Double result = varResVisitor.visitPower(power);

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Map<String, Number> variables = Map.of("z", 36);
    final VariableResolutionVisitor varResVisitor = new VariableResolutionVisitor(variables);
    final Division division = new Division(new Numeric(1), new Numeric(2));
    final Power power = new Power(new Variable("z"), division);
    final Double result = varResVisitor.visitPower(power);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Map<String, Number> variables = Map.of("value", 8);
    final VariableResolutionVisitor varResVisitor = new VariableResolutionVisitor(variables);
    final Mod module = new Mod(new Variable("value"));
    final Substraction subt = new Substraction(module, new Numeric(8));
    final Double result = varResVisitor.visitSubstraction(subt);

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Map<String, Number> variables = Map.of("value", 8);
    final VariableResolutionVisitor varResVisitor = new VariableResolutionVisitor(variables);
    final Mod module = new Mod(new Variable("value"));
    final Substraction subt = new Substraction(module, new Numeric(8));
    final Double result = varResVisitor.visitSubstraction(subt);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Map<String, Number> variables = Map.of("i", 2);
    final VariableResolutionVisitor varResVisitor = new VariableResolutionVisitor(variables);
    final Substraction subt = new Substraction(new Numeric(5), new Variable("i"));
    final Multiplication mult = new Multiplication(subt, new Numeric(8));
    final Double result = varResVisitor.visitMultiplication(mult);

    assertThat(result, equalTo(24d));
  }
}
