package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.expression.*;
import edu.austral.ingsis.math.visitor.EvaluationVisitor;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Sum expression = new Sum(new Numeric(1), new Numeric(6));

    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    Double result = expression.accept(evaluationVisitor);

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    Division expression = new Division(new Numeric(12), new Numeric(2));
    Double result = expression.accept(evaluationVisitor);

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    Division division = new Division(new Numeric(9), new Numeric(2));
    Multiplication expression = new Multiplication(division, new Numeric(3));
    Double result = expression.accept(evaluationVisitor);

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    Division division = new Division(new Numeric(27), new Numeric(6));
    Power power = new Power(division, new Numeric(2));
    Double result = power.accept(evaluationVisitor);
    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    Division division = new Division(new Numeric(1), new Numeric(2));
    Power power = new Power(new Numeric(36), division);
    Double result = power.accept(evaluationVisitor);

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    Mod module = new Mod(new Numeric(136));
    Double result = module.accept(evaluationVisitor);

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    Mod module = new Mod(new Numeric(-136));
    Double result = module.accept(evaluationVisitor);

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    Substraction subt = new Substraction(new Numeric(5), new Numeric(5));
    Multiplication expression = new Multiplication(subt, new Numeric(8));
    Double result = expression.accept(evaluationVisitor);

    assertThat(result, equalTo(0d));
  }

  /** Case sqrt(64) */
  @Test
  public void shouldResolveSquareRoot(){
    EvaluationVisitor evaluationVisitor = new EvaluationVisitor();
    SquareRoot sqrRoot = new SquareRoot(new Numeric(64));
    Double result = sqrRoot.accept(evaluationVisitor);

    assertThat(result, equalTo(8d));
  }
}
