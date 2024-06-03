package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.expression.*;
import edu.austral.ingsis.math.visitor.ListVariablesVisitor;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final Sum sum = new Sum(new Numeric(1), new Numeric(6));
    ListVariablesVisitor listVariablesVisitor = new ListVariablesVisitor();
    final List<String> result = listVariablesVisitor.visitSum(sum);

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Division division = new Division(new Numeric(12), new Variable("div"));
    ListVariablesVisitor listVariablesVisitor = new ListVariablesVisitor();
    final List<String> result = listVariablesVisitor.visitDivision(division);

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final Division division = new Division(new Numeric(9), new Variable("x"));
    final Multiplication mult = new Multiplication(division, new Variable("y"));
    ListVariablesVisitor listVariablesVisitor = new ListVariablesVisitor();
    final List<String> result = listVariablesVisitor.visitMultiplication(mult);

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final Division division = new Division(new Numeric(27), new Variable("a"));
    final Power power = new Power(division, new Variable("b"));
    ListVariablesVisitor listVariablesVisitor = new ListVariablesVisitor();
    final List<String> result = listVariablesVisitor.visitPower(power);

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final Division division = new Division(new Numeric(1), new Numeric(2));
    final Power power = new Power(new Variable("z"), division);
    ListVariablesVisitor listVariablesVisitor = new ListVariablesVisitor();
    final List<String> result = listVariablesVisitor.visitPower(power);

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final Mod module = new Mod(new Variable("value"));
    final Substraction subt = new Substraction(module, new Numeric(8));
    ListVariablesVisitor listVariablesVisitor = new ListVariablesVisitor();
    final List<String> result = listVariablesVisitor.visitSubstraction(subt);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final Mod module = new Mod(new Variable("value"));
    final Substraction subt = new Substraction(module, new Numeric(8));
    ListVariablesVisitor listVariablesVisitor = new ListVariablesVisitor();
    final List<String> result = listVariablesVisitor.visitSubstraction(subt);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final Substraction subt = new Substraction(new Numeric(5), new Variable("i"));
    final Multiplication mult = new Multiplication(subt, new Numeric(8));
    ListVariablesVisitor listVariablesVisitor = new ListVariablesVisitor();
    final List<String> result = listVariablesVisitor.visitSubstraction(subt);

    assertThat(result, containsInAnyOrder("i"));
  }
}
