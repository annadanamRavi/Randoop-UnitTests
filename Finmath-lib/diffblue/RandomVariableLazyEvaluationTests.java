package net.finmath.montecarlo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntToDoubleFunction;

import net.finmath.functions.DoubleTernaryOperator;

import net.finmath.interpolation.RationalFunctionInterpolation;

import net.finmath.stochastic.RandomVariable;
import net.finmath.stochastic.Scalar;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class RandomVariableLazyEvaluationTests {
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(double)}
	 *   <li>{@link RandomVariableLazyEvaluation#getFiltrationTime()}
	 *   <li>{@link RandomVariableLazyEvaluation#getOperator()}
	 *   <li>{@link RandomVariableLazyEvaluation#getTypePriority()}
	 *   <li>{@link RandomVariableLazyEvaluation#size()}
	 * </ul>
	 */
	@Test
	void testConstructor() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		assertEquals(0.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
		RandomVariable averageResult = actualRandomVariableLazyEvaluation.average();
		assertEquals(0.0d, averageResult.getFiltrationTime());
		RandomVariable varianceResult = actualRandomVariableLazyEvaluation.variance();
		assertEquals(0.0d, varianceResult.getFiltrationTime());
		assertNull(actualRandomVariableLazyEvaluation.getOperator());
		assertNull(averageResult.getOperator());
		assertNull(varianceResult.getOperator());
		assertEquals(0, actualRandomVariableLazyEvaluation.getTypePriority());
		assertEquals(0, averageResult.getTypePriority());
		assertEquals(1, actualRandomVariableLazyEvaluation.size());
		assertEquals(1, averageResult.size());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(double)}
	 */
	@Test
	void testConstructor2() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getAverage());
		assertNull(actualRandomVariableLazyEvaluation.getOperator());
		assertEquals(1, actualRandomVariableLazyEvaluation.size());
		assertEquals(0.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(double, double)}
	 */
	@Test
	void testConstructor3() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10.0d);

		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getAverage());
		assertNull(actualRandomVariableLazyEvaluation.getOperator());
		assertEquals(1, actualRandomVariableLazyEvaluation.size());
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(double, int, double)}
	 */
	@Test
	void testConstructor4() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10,
				10.0d);

		assertFalse(actualRandomVariableLazyEvaluation.isDeterministic());
		assertEquals(10, actualRandomVariableLazyEvaluation.size());
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
		assertEquals(10, actualRandomVariableLazyEvaluation.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(double, IntToDoubleFunction, int)}
	 */
	@Test
	void testConstructor5() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d,
				(IntToDoubleFunction) null, 3);

		assertEquals(Double.NaN, actualRandomVariableLazyEvaluation.getAverage());
		assertNull(actualRandomVariableLazyEvaluation.getOperator());
		assertEquals(3, actualRandomVariableLazyEvaluation.size());
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(double, double[])}
	 */
	@Test
	void testConstructor6() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d,
				new double[]{10.0d, 10.0d, 10.0d, 10.0d});

		assertFalse(actualRandomVariableLazyEvaluation.isDeterministic());
		assertEquals(4, actualRandomVariableLazyEvaluation.size());
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
		assertEquals(4, actualRandomVariableLazyEvaluation.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable)}
	 */
	@Test
	void testConstructor7() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getAverage());
		assertNull(actualRandomVariableLazyEvaluation.getOperator());
		assertEquals(1, actualRandomVariableLazyEvaluation.size());
		assertEquals(Double.NEGATIVE_INFINITY, actualRandomVariableLazyEvaluation.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable)}
	 */
	@Test
	void testConstructor8() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(
				new Scalar(10.0d));
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getAverage());
		assertNull(actualRandomVariableLazyEvaluation.getOperator());
		assertEquals(1, actualRandomVariableLazyEvaluation.size());
		assertEquals(Double.NEGATIVE_INFINITY, actualRandomVariableLazyEvaluation.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor9() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.<init>(RandomVariableLazyEvaluation.java:58)
		//   In order to prevent <init>(RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		new RandomVariableLazyEvaluation((RandomVariable) null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable)}
	 */
	@Test
	void testConstructor10() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertFalse(actualRandomVariableLazyEvaluation.isDeterministic());
		assertEquals(10, actualRandomVariableLazyEvaluation.size());
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
		assertEquals(10, actualRandomVariableLazyEvaluation.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable)}
	 */
	@Test
	void testConstructor11() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(
				new RandomVariableLazyEvaluation(10.0d));
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getAverage());
		assertNull(actualRandomVariableLazyEvaluation.getOperator());
		assertEquals(1, actualRandomVariableLazyEvaluation.size());
		assertEquals(0.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable)}
	 */
	@Test
	void testConstructor12() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(
				new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertFalse(actualRandomVariableLazyEvaluation.isDeterministic());
		assertEquals(10, actualRandomVariableLazyEvaluation.size());
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
		assertEquals(10, actualRandomVariableLazyEvaluation.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable, DoubleUnaryOperator)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor13() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.<init>(RandomVariableLazyEvaluation.java:89)
		//   In order to prevent <init>(RandomVariable, DoubleUnaryOperator)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(RandomVariable, DoubleUnaryOperator).
		//   See https://diff.blue/R013 to resolve this issue.

		new RandomVariableLazyEvaluation(new RandomVariableFromDoubleArray(10.0d), (DoubleUnaryOperator) null);

	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable, DoubleUnaryOperator)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor14() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.<init>(RandomVariableLazyEvaluation.java:89)
		//   In order to prevent <init>(RandomVariable, DoubleUnaryOperator)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(RandomVariable, DoubleUnaryOperator).
		//   See https://diff.blue/R013 to resolve this issue.

		new RandomVariableLazyEvaluation(new Scalar(10.0d), (DoubleUnaryOperator) null);

	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(RandomVariable, DoubleUnaryOperator)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor15() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.<init>(RandomVariableLazyEvaluation.java:81)
		//   In order to prevent <init>(RandomVariable, DoubleUnaryOperator)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(RandomVariable, DoubleUnaryOperator).
		//   See https://diff.blue/R013 to resolve this issue.

		new RandomVariableLazyEvaluation((RandomVariable) null, null);

	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable, DoubleUnaryOperator)}
	 */
	@Test
	void testConstructor16() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d), (DoubleUnaryOperator) null);

		assertEquals(10, actualRandomVariableLazyEvaluation.size());
		assertFalse(actualRandomVariableLazyEvaluation.isDeterministic());
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable, DoubleUnaryOperator)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor17() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.<init>(RandomVariableLazyEvaluation.java:89)
		//   In order to prevent <init>(RandomVariable, DoubleUnaryOperator)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(RandomVariable, DoubleUnaryOperator).
		//   See https://diff.blue/R013 to resolve this issue.

		new RandomVariableLazyEvaluation(new RandomVariableLazyEvaluation(10.0d), (DoubleUnaryOperator) null);

	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#RandomVariableLazyEvaluation(net.finmath.stochastic.RandomVariable, DoubleUnaryOperator)}
	 */
	@Test
	void testConstructor18() {
		RandomVariableLazyEvaluation actualRandomVariableLazyEvaluation = new RandomVariableLazyEvaluation(
				new RandomVariableLazyEvaluation(10.0d, 10, 10.0d), (DoubleUnaryOperator) null);

		assertEquals(10, actualRandomVariableLazyEvaluation.size());
		assertFalse(actualRandomVariableLazyEvaluation.isDeterministic());
		assertEquals(10.0d, actualRandomVariableLazyEvaluation.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:713)
		//   In order to prevent apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		randomVariableLazyEvaluation.apply(null, null, argument1, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply2() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:713)
		//   In order to prevent apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar argument1 = new Scalar(10.0d);
		randomVariableLazyEvaluation.apply(null, null, argument1, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:709)
		//   In order to prevent apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, null, null, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply5() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d, 10, 10.0d);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply6() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:713)
		//   In order to prevent apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation argument1 = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, null, argument1, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromFloatArray argument1 = new RandomVariableFromFloatArray(10.0d, 10, 10.0d);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation argument1 = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply9() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:713)
		//   In order to prevent apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		randomVariableLazyEvaluation.apply(null, null, argument1, new Scalar(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply10() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:710)
		//   In order to prevent apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, null, new RandomVariableFromDoubleArray(10.0d), null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply11() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply12() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:713)
		//   In order to prevent apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		randomVariableLazyEvaluation.apply(null, null, argument1, new RandomVariableLazyEvaluation(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply14() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply15() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		Scalar argument1 = new Scalar(Double.NaN);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply16() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableLazyEvaluation argument1 = new RandomVariableLazyEvaluation(Double.NaN);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply17() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new Scalar(Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply18() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableLazyEvaluation(Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply19() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar argument1 = new Scalar(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(Double.NEGATIVE_INFINITY, 10, Double.NEGATIVE_INFINITY));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(0.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply20() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d, 10, 10.0d);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(Double.NaN, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, DoubleBinaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply21() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation argument1 = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, null, argument1,
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply22() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:648)
		//   In order to prevent apply(DoubleBinaryOperator, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply23() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply24() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:648)
		//   In order to prevent apply(DoubleBinaryOperator, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, new Scalar(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply25() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:645)
		//   In order to prevent apply(DoubleBinaryOperator, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		(new RandomVariableLazyEvaluation(10.0d)).apply(null, null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply26() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null,
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply27() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:648)
		//   In order to prevent apply(DoubleBinaryOperator, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleBinaryOperator, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, new RandomVariableLazyEvaluation(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply28() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null,
				new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply29() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null,
				new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply30() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, new Scalar(Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply31() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null,
				new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(Double.NaN, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply32() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null,
				new RandomVariableLazyEvaluation(Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply33() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null,
				new RandomVariableFromFloatArray(Double.NaN, 10, Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(Double.NaN, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleBinaryOperator, RandomVariable)}
	 */
	@Test
	void testApply34() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null,
				new RandomVariableLazyEvaluation(Double.NaN, 10, Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(Double.NaN, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleUnaryOperator)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply35() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:611)
		//   In order to prevent apply(DoubleUnaryOperator)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleUnaryOperator).
		//   See https://diff.blue/R013 to resolve this issue.

		(new RandomVariableLazyEvaluation(10.0d)).apply(null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleUnaryOperator)}
	 */
	@Test
	void testApply36() {
		RandomVariable actualApplyResult = (new RandomVariableLazyEvaluation(10.0d, 10, 10.0d)).apply(null);
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(java.util.function.DoubleUnaryOperator)}
	 */
	@Test
	void testApply37() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(new RationalFunctionInterpolation(
				new double[]{10.0d, 10.0d, 10.0d, 10.0d}, new double[]{10.0d, 10.0d, 10.0d, 10.0d}));
		assertEquals(10.0d, actualApplyResult.getAverage());
		assertNull(actualApplyResult.getOperator());
		assertEquals(1, actualApplyResult.size());
		assertEquals(0.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply38() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:810)
		//   In order to prevent apply(DoubleTernaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleTernaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		randomVariableLazyEvaluation.apply(null, argument1, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply39() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply40() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:810)
		//   In order to prevent apply(DoubleTernaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleTernaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar argument1 = new Scalar(10.0d);
		randomVariableLazyEvaluation.apply(null, argument1, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply41() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:806)
		//   In order to prevent apply(DoubleTernaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleTernaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, null, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply42() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d, 10, 10.0d);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply43() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:810)
		//   In order to prevent apply(DoubleTernaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleTernaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation argument1 = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, argument1, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply44() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromFloatArray argument1 = new RandomVariableFromFloatArray(10.0d, 10, 10.0d);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply45() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation argument1 = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply46() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:810)
		//   In order to prevent apply(DoubleTernaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleTernaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		randomVariableLazyEvaluation.apply(null, argument1, new Scalar(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply47() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:807)
		//   In order to prevent apply(DoubleTernaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleTernaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.apply(null, new RandomVariableFromDoubleArray(10.0d), null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply48() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testApply49() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:810)
		//   In order to prevent apply(DoubleTernaryOperator, RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   apply(DoubleTernaryOperator, RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		randomVariableLazyEvaluation.apply(null, argument1, new RandomVariableLazyEvaluation(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply50() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply51() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply52() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		Scalar argument1 = new Scalar(Double.NaN);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply53() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(Double.NaN, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply54() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableLazyEvaluation argument1 = new RandomVariableLazyEvaluation(Double.NaN);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply55() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1, new Scalar(Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply56() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(Double.NaN, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply57() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableLazyEvaluation(Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply58() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar argument1 = new Scalar(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(Double.NEGATIVE_INFINITY, 10, Double.NEGATIVE_INFINITY));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(0.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply59() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray argument1 = new RandomVariableFromDoubleArray(10.0d, 10, 10.0d);

		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(Double.NaN, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#apply(DoubleTernaryOperator, RandomVariable, RandomVariable)}
	 */
	@Test
	void testApply60() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation argument1 = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualApplyResult = randomVariableLazyEvaluation.apply(null, argument1,
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertEquals(10, actualApplyResult.size());
		assertFalse(actualApplyResult.isDeterministic());
		assertEquals(10.0d, actualApplyResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(double)}
	 */
	@Test
	void testCap() {
		RandomVariable actualCapResult = (new RandomVariableLazyEvaluation(10.0d)).cap(10.0d);
		assertEquals(10.0d, actualCapResult.getAverage());
		assertNull(actualCapResult.getOperator());
		assertEquals(1, actualCapResult.size());
		assertEquals(0.0d, actualCapResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(double)}
	 */
	@Test
	void testCap2() {
		RandomVariable actualCapResult = (new RandomVariableLazyEvaluation(10.0d, 10, 10.0d)).cap(10.0d);
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(10.0d, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap3() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation.cap(new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10.0d, actualCapResult.getAverage());
		assertNull(actualCapResult.getOperator());
		assertEquals(1, actualCapResult.size());
		assertEquals(0.0d, actualCapResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap4() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation.cap(new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(10.0d, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap5() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation.cap(new Scalar(10.0d));
		assertEquals(10.0d, actualCapResult.getAverage());
		assertNull(actualCapResult.getOperator());
		assertEquals(1, actualCapResult.size());
		assertEquals(0.0d, actualCapResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testCap6() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:645)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.cap(RandomVariableLazyEvaluation.java:1128)
		//   In order to prevent cap(RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   cap(RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		(new RandomVariableLazyEvaluation(10.0d)).cap((RandomVariable) null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation
				.cap(new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(10.0d, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation.cap(new RandomVariableLazyEvaluation(10.0d));
		assertEquals(10.0d, actualCapResult.getAverage());
		assertNull(actualCapResult.getOperator());
		assertEquals(1, actualCapResult.size());
		assertEquals(0.0d, actualCapResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap9() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation
				.cap(new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(10.0d, actualCapResult.getAverage());
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(10.0d, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap10() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation
				.cap(new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(10.0d, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap11() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation.cap(new Scalar(Double.NaN));
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(10.0d, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap12() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation
				.cap(new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN));
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(Double.NaN, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation.cap(new RandomVariableLazyEvaluation(Double.NaN));
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(10.0d, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap14() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation
				.cap(new RandomVariableFromFloatArray(Double.NaN, 10, Double.NaN));
		assertEquals(Double.NaN, actualCapResult.getAverage());
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(Double.NaN, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
		assertEquals(Double.NaN, actualCapResult.getMax());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cap(RandomVariable)}
	 */
	@Test
	void testCap15() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualCapResult = randomVariableLazyEvaluation
				.cap(new RandomVariableLazyEvaluation(Double.NaN, 10, Double.NaN));
		assertFalse(actualCapResult.isDeterministic());
		assertEquals(10, actualCapResult.size());
		assertEquals(Double.NaN, actualCapResult.getFiltrationTime());
		assertEquals(10, actualCapResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cache()}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testCache() {
		// TODO: Complete this test.
		//   Reason: R010 Timeout.
		//   Creating the arrange/act section of your test took more than
		//   20 seconds. This often happens because Diffblue Cover ran code in your
		//   project which requests user input (System.in), blocks on a lock, or runs into
		//   an infinite or very long loop.
		//   See https://diff.blue/R010 to resolve this issue.

		// Arrange
		// TODO: Populate arranged inputs
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = null;

		// Act
		RandomVariable actualCacheResult = randomVariableLazyEvaluation.cache();

		// Assert
		// TODO: Add assertions on result
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(double)}
	 */
	@Test
	void testAdd() {
		RandomVariable actualAddResult = (new RandomVariableLazyEvaluation(10.0d)).add(10.0d);
		assertEquals(20.0d, actualAddResult.getAverage());
		assertNull(actualAddResult.getOperator());
		assertEquals(1, actualAddResult.size());
		assertEquals(0.0d, actualAddResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(double)}
	 */
	@Test
	void testAdd2() {
		RandomVariable actualAddResult = (new RandomVariableLazyEvaluation(10.0d, 10, 10.0d)).add(10.0d);
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(10.0d, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd3() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation.add(new RandomVariableFromDoubleArray(10.0d));
		assertEquals(20.0d, actualAddResult.getAverage());
		assertNull(actualAddResult.getOperator());
		assertEquals(1, actualAddResult.size());
		assertEquals(0.0d, actualAddResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd4() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation.add(new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(10.0d, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd5() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation.add(new Scalar(10.0d));
		assertEquals(20.0d, actualAddResult.getAverage());
		assertNull(actualAddResult.getOperator());
		assertEquals(1, actualAddResult.size());
		assertEquals(0.0d, actualAddResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAdd6() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:645)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.add(RandomVariableLazyEvaluation.java:1061)
		//   In order to prevent add(RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   add(RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		(new RandomVariableLazyEvaluation(10.0d)).add((RandomVariable) null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation
				.add(new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(10.0d, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation.add(new RandomVariableLazyEvaluation(10.0d));
		assertEquals(20.0d, actualAddResult.getAverage());
		assertNull(actualAddResult.getOperator());
		assertEquals(1, actualAddResult.size());
		assertEquals(0.0d, actualAddResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd9() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation
				.add(new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(20.0d, actualAddResult.getAverage());
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(10.0d, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
		assertEquals(20.0d, actualAddResult.getMin());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd10() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation
				.add(new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(10.0d, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd11() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation.add(new Scalar(Double.NaN));
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(10.0d, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd12() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation
				.add(new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN));
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(Double.NaN, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation.add(new RandomVariableLazyEvaluation(Double.NaN));
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(10.0d, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd14() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation
				.add(new RandomVariableFromFloatArray(Double.NaN, 10, Double.NaN));
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(Double.NaN, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
		assertEquals(Double.NaN, actualAddResult.getMax());
		assertEquals(Double.NaN, actualAddResult.getMin());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#add(RandomVariable)}
	 */
	@Test
	void testAdd15() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddResult = randomVariableLazyEvaluation
				.add(new RandomVariableLazyEvaluation(Double.NaN, 10, Double.NaN));
		assertFalse(actualAddResult.isDeterministic());
		assertEquals(10, actualAddResult.size());
		assertEquals(Double.NaN, actualAddResult.getFiltrationTime());
		assertEquals(10, actualAddResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation.bus(new RandomVariableFromDoubleArray(10.0d));
		assertEquals(0.0d, actualBusResult.getAverage());
		assertNull(actualBusResult.getOperator());
		assertEquals(1, actualBusResult.size());
		assertEquals(0.0d, actualBusResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus2() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation.bus(new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(10.0d, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus3() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation.bus(new Scalar(10.0d));
		assertEquals(0.0d, actualBusResult.getAverage());
		assertNull(actualBusResult.getOperator());
		assertEquals(1, actualBusResult.size());
		assertEquals(0.0d, actualBusResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testBus4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:645)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.bus(RandomVariableLazyEvaluation.java:1085)
		//   In order to prevent bus(RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   bus(RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		(new RandomVariableLazyEvaluation(10.0d)).bus(null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus5() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation
				.bus(new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(10.0d, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus6() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation.bus(new RandomVariableLazyEvaluation(10.0d));
		assertEquals(0.0d, actualBusResult.getAverage());
		assertNull(actualBusResult.getOperator());
		assertEquals(1, actualBusResult.size());
		assertEquals(0.0d, actualBusResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation
				.bus(new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(0.0d, actualBusResult.getAverage());
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(10.0d, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
		assertEquals(0.0d, actualBusResult.getMax());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation
				.bus(new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(10.0d, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus9() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation.bus(new Scalar(Double.NaN));
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(10.0d, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus10() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation
				.bus(new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN));
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(Double.NaN, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus11() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation.bus(new RandomVariableLazyEvaluation(Double.NaN));
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(10.0d, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus12() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation
				.bus(new RandomVariableFromFloatArray(Double.NaN, 10, Double.NaN));
		assertEquals(Double.NaN, actualBusResult.getAverage());
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(Double.NaN, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#bus(RandomVariable)}
	 */
	@Test
	void testBus13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualBusResult = randomVariableLazyEvaluation
				.bus(new RandomVariableLazyEvaluation(Double.NaN, 10, Double.NaN));
		assertFalse(actualBusResult.isDeterministic());
		assertEquals(10, actualBusResult.size());
		assertEquals(Double.NaN, actualBusResult.getFiltrationTime());
		assertEquals(10, actualBusResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#average()}
	 */
	@Test
	void testAverage() {
		RandomVariable actualAverageResult = (new RandomVariableLazyEvaluation(10.0d)).average();
		assertEquals(0.0d, actualAverageResult.getFiltrationTime());
		assertTrue(actualAverageResult.isDeterministic());
		assertEquals(1, actualAverageResult.getRealizations().length);
		assertEquals(1, actualAverageResult.size());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#average()}
	 */
	@Test
	void testAverage2() {
		RandomVariable actualAverageResult = (new RandomVariableLazyEvaluation(10.0d, 10, 10.0d)).average();
		assertEquals(0.0d, actualAverageResult.getFiltrationTime());
		assertTrue(actualAverageResult.isDeterministic());
		assertEquals(1, actualAverageResult.getRealizations().length);
		assertEquals(1, actualAverageResult.size());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#average()}
	 */
	@Test
	void testAverage3() {
		RandomVariable actualAverageResult = (new RandomVariableLazyEvaluation(0.5d, 10, 10.0d)).average();
		assertEquals(0.0d, actualAverageResult.getFiltrationTime());
		assertTrue(actualAverageResult.isDeterministic());
		assertEquals(1, actualAverageResult.getRealizations().length);
		assertEquals(1, actualAverageResult.size());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#average()}
	 */
	@Test
	void testAverage4() {
		RandomVariable actualAverageResult = (new RandomVariableLazyEvaluation(10.0d, 0, 10.0d)).average();
		assertEquals(0.0d, actualAverageResult.getFiltrationTime());
		assertTrue(actualAverageResult.isDeterministic());
		assertEquals(1, actualAverageResult.getRealizations().length);
		assertEquals(1, actualAverageResult.size());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#average()}
	 */
	@Test
	void testAverage5() {
		RandomVariable actualAverageResult = (new RandomVariableLazyEvaluation(10.0d, -1, 10.0d)).average();
		assertEquals(0.0d, actualAverageResult.getFiltrationTime());
		assertTrue(actualAverageResult.isDeterministic());
		assertEquals(1, actualAverageResult.getRealizations().length);
		assertEquals(1, actualAverageResult.size());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cos()}
	 */
	@Test
	void testCos() {
		RandomVariable actualCosResult = (new RandomVariableLazyEvaluation(10.0d)).cos();
		assertEquals(-0.8390715290764524d, actualCosResult.getAverage());
		assertNull(actualCosResult.getOperator());
		assertEquals(1, actualCosResult.size());
		assertEquals(0.0d, actualCosResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#cos()}
	 */
	@Test
	void testCos2() {
		RandomVariable actualCosResult = (new RandomVariableLazyEvaluation(10.0d, 10, 10.0d)).cos();
		assertFalse(actualCosResult.isDeterministic());
		assertEquals(10, actualCosResult.size());
		assertEquals(10.0d, actualCosResult.getFiltrationTime());
		assertEquals(10, actualCosResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation.accrue(new RandomVariableFromDoubleArray(10.0d),
				10.0d);
		assertEquals(1010.0d, actualAccrueResult.getAverage());
		assertNull(actualAccrueResult.getOperator());
		assertEquals(1, actualAccrueResult.size());
		assertEquals(0.0d, actualAccrueResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue2() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation.accrue(new RandomVariableFromDoubleArray(10.0d),
				10.0d);
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(1.0d, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue3() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation.accrue(new Scalar(1.0d), 10.0d);
		assertEquals(110.0d, actualAccrueResult.getAverage());
		assertNull(actualAccrueResult.getOperator());
		assertEquals(1, actualAccrueResult.size());
		assertEquals(0.0d, actualAccrueResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAccrue4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:645)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.accrue(RandomVariableLazyEvaluation.java:1138)
		//   In order to prevent accrue(RandomVariable, double)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   accrue(RandomVariable, double).
		//   See https://diff.blue/R013 to resolve this issue.

		(new RandomVariableLazyEvaluation(10.0d)).accrue(null, 10.0d);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue5() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation
				.accrue(new RandomVariableFromDoubleArray(1.0d, 10, 1.0d), 10.0d);
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(1.0d, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue6() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation.accrue(new RandomVariableLazyEvaluation(1.0d),
				10.0d);
		assertEquals(110.0d, actualAccrueResult.getAverage());
		assertNull(actualAccrueResult.getOperator());
		assertEquals(1, actualAccrueResult.size());
		assertEquals(0.0d, actualAccrueResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation
				.accrue(new RandomVariableFromFloatArray(1.0d, 10, 1.0d), 10.0d);
		assertEquals(110.0d, actualAccrueResult.getAverage());
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(1.0d, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation
				.accrue(new RandomVariableLazyEvaluation(1.0d, 10, 1.0d), 10.0d);
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(1.0d, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue9() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation.accrue(new Scalar(Double.NaN), 10.0d);
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(1.0d, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue10() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation
				.accrue(new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN), 10.0d);
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(Double.NaN, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue11() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation
				.accrue(new RandomVariableLazyEvaluation(Double.NaN), 10.0d);
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(1.0d, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue12() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation
				.accrue(new RandomVariableFromFloatArray(Double.NaN, 10, Double.NaN), 10.0d);
		assertEquals(Double.NaN, actualAccrueResult.getAverage());
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(Double.NaN, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
		assertEquals(Double.NaN, actualAccrueResult.getMax());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#accrue(RandomVariable, double)}
	 */
	@Test
	void testAccrue13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualAccrueResult = randomVariableLazyEvaluation
				.accrue(new RandomVariableLazyEvaluation(Double.NaN, 10, Double.NaN), 10.0d);
		assertFalse(actualAccrueResult.isDeterministic());
		assertEquals(10, actualAccrueResult.size());
		assertEquals(Double.NaN, actualAccrueResult.getFiltrationTime());
		assertEquals(10, actualAccrueResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableFromDoubleArray(10.0d), 10.0d);
		assertEquals(0.09900990099009901d, actualDiscountResult.getAverage());
		assertNull(actualDiscountResult.getOperator());
		assertEquals(1, actualDiscountResult.size());
		assertEquals(0.0d, actualDiscountResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount2() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableFromDoubleArray(10.0d), 10.0d);
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(1.0d, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount3() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation.discount(new Scalar(1.0d), 10.0d);
		assertEquals(0.9090909090909091d, actualDiscountResult.getAverage());
		assertNull(actualDiscountResult.getOperator());
		assertEquals(1, actualDiscountResult.size());
		assertEquals(0.0d, actualDiscountResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testDiscount4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:645)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.discount(RandomVariableLazyEvaluation.java:1148)
		//   In order to prevent discount(RandomVariable, double)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   discount(RandomVariable, double).
		//   See https://diff.blue/R013 to resolve this issue.

		(new RandomVariableLazyEvaluation(10.0d)).discount(null, 10.0d);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount5() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableFromDoubleArray(1.0d, 10, 1.0d), 10.0d);
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(1.0d, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount6() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation.discount(new RandomVariableLazyEvaluation(1.0d),
				10.0d);
		assertEquals(0.9090909090909091d, actualDiscountResult.getAverage());
		assertNull(actualDiscountResult.getOperator());
		assertEquals(1, actualDiscountResult.size());
		assertEquals(0.0d, actualDiscountResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableFromFloatArray(1.0d, 10, 1.0d), 10.0d);
		assertEquals(0.9090909090909092d, actualDiscountResult.getAverage());
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(1.0d, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableLazyEvaluation(1.0d, 10, 1.0d), 10.0d);
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(1.0d, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount9() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation.discount(new Scalar(Double.NaN), 10.0d);
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(1.0d, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount10() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN), 10.0d);
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(Double.NaN, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount11() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableLazyEvaluation(Double.NaN), 10.0d);
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(1.0d, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount12() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableFromFloatArray(Double.NaN, 10, Double.NaN), 10.0d);
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(Double.NaN, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
		assertEquals(Double.NaN, actualDiscountResult.getMax());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#discount(RandomVariable, double)}
	 */
	@Test
	void testDiscount13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(1.0d, 10, 1.0d);
		RandomVariable actualDiscountResult = randomVariableLazyEvaluation
				.discount(new RandomVariableLazyEvaluation(Double.NaN, 10, Double.NaN), 10.0d);
		assertFalse(actualDiscountResult.isDeterministic());
		assertEquals(10, actualDiscountResult.size());
		assertEquals(Double.NaN, actualDiscountResult.getFiltrationTime());
		assertEquals(10, actualDiscountResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10.0d, actualChooseResult.getAverage());
		assertNull(actualChooseResult.getOperator());
		assertEquals(1, actualChooseResult.size());
		assertEquals(0.0d, actualChooseResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose2() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(-0.5d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10.0d, actualChooseResult.getAverage());
		assertNull(actualChooseResult.getOperator());
		assertEquals(1, actualChooseResult.size());
		assertEquals(0.0d, actualChooseResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose3() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualChooseResult.isDeterministic());
		assertEquals(10, actualChooseResult.size());
		assertEquals(10.0d, actualChooseResult.getFiltrationTime());
		assertEquals(10, actualChooseResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose4() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar valueIfTriggerNonNegative = new Scalar(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10.0d, actualChooseResult.getAverage());
		assertNull(actualChooseResult.getOperator());
		assertEquals(1, actualChooseResult.size());
		assertEquals(0.0d, actualChooseResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testChoose5() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:806)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.choose(RandomVariableLazyEvaluation.java:1158)
		//   In order to prevent choose(RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   choose(RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.choose(null, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose6() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d, 10, 10.0d);

		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualChooseResult.isDeterministic());
		assertEquals(10, actualChooseResult.size());
		assertEquals(10.0d, actualChooseResult.getFiltrationTime());
		assertEquals(10, actualChooseResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation valueIfTriggerNonNegative = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10.0d, actualChooseResult.getAverage());
		assertNull(actualChooseResult.getOperator());
		assertEquals(1, actualChooseResult.size());
		assertEquals(0.0d, actualChooseResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromFloatArray valueIfTriggerNonNegative = new RandomVariableFromFloatArray(10.0d, 10, 10.0d);

		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(10.0d, actualChooseResult.getAverage());
		assertFalse(actualChooseResult.isDeterministic());
		assertEquals(10, actualChooseResult.size());
		assertEquals(10.0d, actualChooseResult.getFiltrationTime());
		assertEquals(10, actualChooseResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose9() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation valueIfTriggerNonNegative = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);

		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualChooseResult.isDeterministic());
		assertEquals(10, actualChooseResult.size());
		assertEquals(10.0d, actualChooseResult.getFiltrationTime());
		assertEquals(10, actualChooseResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose10() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new Scalar(10.0d));
		assertEquals(10.0d, actualChooseResult.getAverage());
		assertNull(actualChooseResult.getOperator());
		assertEquals(1, actualChooseResult.size());
		assertEquals(0.0d, actualChooseResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testChoose11() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:807)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.choose(RandomVariableLazyEvaluation.java:1158)
		//   In order to prevent choose(RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   choose(RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.choose(new RandomVariableFromDoubleArray(10.0d), null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose12() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertFalse(actualChooseResult.isDeterministic());
		assertEquals(10, actualChooseResult.size());
		assertEquals(10.0d, actualChooseResult.getFiltrationTime());
		assertEquals(10, actualChooseResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableLazyEvaluation(10.0d));
		assertEquals(10.0d, actualChooseResult.getAverage());
		assertNull(actualChooseResult.getOperator());
		assertEquals(1, actualChooseResult.size());
		assertEquals(0.0d, actualChooseResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose14() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(10.0d, actualChooseResult.getAverage());
		assertFalse(actualChooseResult.isDeterministic());
		assertEquals(10, actualChooseResult.size());
		assertEquals(10.0d, actualChooseResult.getFiltrationTime());
		assertEquals(10, actualChooseResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#choose(RandomVariable, RandomVariable)}
	 */
	@Test
	void testChoose15() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray valueIfTriggerNonNegative = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualChooseResult = randomVariableLazyEvaluation.choose(valueIfTriggerNonNegative,
				new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertFalse(actualChooseResult.isDeterministic());
		assertEquals(10, actualChooseResult.size());
		assertEquals(10.0d, actualChooseResult.getFiltrationTime());
		assertEquals(10, actualChooseResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#abs()}
	 */
	@Test
	void testAbs() {
		RandomVariable actualAbsResult = (new RandomVariableLazyEvaluation(10.0d)).abs();
		assertEquals(10.0d, actualAbsResult.getAverage());
		assertNull(actualAbsResult.getOperator());
		assertEquals(1, actualAbsResult.size());
		assertEquals(0.0d, actualAbsResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#abs()}
	 */
	@Test
	void testAbs2() {
		RandomVariable actualAbsResult = (new RandomVariableLazyEvaluation(10.0d, 10, 10.0d)).abs();
		assertFalse(actualAbsResult.isDeterministic());
		assertEquals(10, actualAbsResult.size());
		assertEquals(10.0d, actualAbsResult.getFiltrationTime());
		assertEquals(10, actualAbsResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableFromDoubleArray(10.0d), 10.0d);
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertNull(actualAddProductResult.getOperator());
		assertEquals(1, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct2() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableFromDoubleArray(10.0d), 10.0d);
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct3() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(new Scalar(10.0d), 10.0d);
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertNull(actualAddProductResult.getOperator());
		assertEquals(1, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddProduct4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:645)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.addProduct(RandomVariableLazyEvaluation.java:1189)
		//   In order to prevent addProduct(RandomVariable, double)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   addProduct(RandomVariable, double).
		//   See https://diff.blue/R013 to resolve this issue.

		(new RandomVariableLazyEvaluation(10.0d)).addProduct(null, 10.0d);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct5() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableFromDoubleArray(10.0d, 10, 10.0d), 10.0d);
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct6() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableLazyEvaluation(10.0d), 10.0d);
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertNull(actualAddProductResult.getOperator());
		assertEquals(1, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableFromFloatArray(10.0d, 10, 10.0d), 10.0d);
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableLazyEvaluation(10.0d, 10, 10.0d), 10.0d);
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct9() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(new Scalar(Double.NaN), 10.0d);
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct10() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableFromDoubleArray(Double.NaN, 10, Double.NaN), 10.0d);
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(Double.NaN, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct11() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableLazyEvaluation(Double.NaN), 10.0d);
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct12() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableFromFloatArray(Double.NaN, 10, Double.NaN), 10.0d);
		assertEquals(Double.NaN, actualAddProductResult.getAverage());
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(Double.NaN, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
		assertEquals(Double.NaN, actualAddProductResult.getMin());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, double)}
	 */
	@Test
	void testAddProduct13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation
				.addProduct(new RandomVariableLazyEvaluation(Double.NaN, 10, Double.NaN), 10.0d);
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(Double.NaN, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct14() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertNull(actualAddProductResult.getOperator());
		assertEquals(1, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct15() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct16() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar factor1 = new Scalar(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertNull(actualAddProductResult.getOperator());
		assertEquals(1, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddProduct17() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:709)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.addProduct(RandomVariableLazyEvaluation.java:1203)
		//   In order to prevent addProduct(RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   addProduct(RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.addProduct(null, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct18() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d, 10, 10.0d);

		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct19() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation factor1 = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertNull(actualAddProductResult.getOperator());
		assertEquals(1, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct20() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromFloatArray factor1 = new RandomVariableFromFloatArray(10.0d, 10, 10.0d);

		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
		assertEquals(110.0d, actualAddProductResult.getMin());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct21() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation factor1 = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);

		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct22() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1, new Scalar(10.0d));
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertNull(actualAddProductResult.getOperator());
		assertEquals(1, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddProduct23() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:710)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.addProduct(RandomVariableLazyEvaluation.java:1203)
		//   In order to prevent addProduct(RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   addProduct(RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.addProduct(new RandomVariableFromDoubleArray(10.0d), (RandomVariable) null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct24() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct25() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableLazyEvaluation(10.0d));
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertNull(actualAddProductResult.getOperator());
		assertEquals(1, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct26() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(110.0d, actualAddProductResult.getAverage());
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
		assertEquals(110.0d, actualAddProductResult.getMin());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct27() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct28() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		Scalar factor1 = new Scalar(Double.NaN);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct29() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableLazyEvaluation factor1 = new RandomVariableLazyEvaluation(Double.NaN);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct30() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1, new Scalar(Double.NaN));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct31() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray factor1 = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableLazyEvaluation(Double.NaN));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(10.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addProduct(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddProduct32() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar factor1 = new Scalar(10.0d);
		RandomVariable actualAddProductResult = randomVariableLazyEvaluation.addProduct(factor1,
				new RandomVariableFromDoubleArray(Double.NEGATIVE_INFINITY, 10, Double.NEGATIVE_INFINITY));
		assertFalse(actualAddProductResult.isDeterministic());
		assertEquals(10, actualAddProductResult.size());
		assertEquals(0.0d, actualAddProductResult.getFiltrationTime());
		assertEquals(10, actualAddProductResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(11.0d, actualAddRatioResult.getAverage());
		assertNull(actualAddRatioResult.getOperator());
		assertEquals(1, actualAddRatioResult.size());
		assertEquals(0.0d, actualAddRatioResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio2() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio3() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar numerator = new Scalar(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(11.0d, actualAddRatioResult.getAverage());
		assertNull(actualAddRatioResult.getOperator());
		assertEquals(1, actualAddRatioResult.size());
		assertEquals(0.0d, actualAddRatioResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddRatio4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:709)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.addRatio(RandomVariableLazyEvaluation.java:1221)
		//   In order to prevent addRatio(RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   addRatio(RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.addRatio(null, new RandomVariableFromDoubleArray(10.0d));
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio5() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d, 10, 10.0d);

		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio6() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation numerator = new RandomVariableLazyEvaluation(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertEquals(11.0d, actualAddRatioResult.getAverage());
		assertNull(actualAddRatioResult.getOperator());
		assertEquals(1, actualAddRatioResult.size());
		assertEquals(0.0d, actualAddRatioResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio7() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromFloatArray numerator = new RandomVariableFromFloatArray(10.0d, 10, 10.0d);

		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
		assertEquals(11.0d, actualAddRatioResult.getMax());
		assertEquals(11.0d, actualAddRatioResult.getMin());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio8() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableLazyEvaluation numerator = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);

		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio9() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator, new Scalar(10.0d));
		assertEquals(11.0d, actualAddRatioResult.getAverage());
		assertNull(actualAddRatioResult.getOperator());
		assertEquals(1, actualAddRatioResult.size());
		assertEquals(0.0d, actualAddRatioResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddRatio10() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.apply(RandomVariableLazyEvaluation.java:710)
		//       at net.finmath.montecarlo.RandomVariableLazyEvaluation.addRatio(RandomVariableLazyEvaluation.java:1221)
		//   In order to prevent addRatio(RandomVariable, RandomVariable)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   addRatio(RandomVariable, RandomVariable).
		//   See https://diff.blue/R013 to resolve this issue.

		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		randomVariableLazyEvaluation.addRatio(new RandomVariableFromDoubleArray(10.0d), null);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio11() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d, 10, 10.0d));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio12() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableLazyEvaluation(10.0d));
		assertEquals(11.0d, actualAddRatioResult.getAverage());
		assertNull(actualAddRatioResult.getOperator());
		assertEquals(1, actualAddRatioResult.size());
		assertEquals(0.0d, actualAddRatioResult.getFiltrationTime());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio13() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromFloatArray(10.0d, 10, 10.0d));
		assertEquals(11.0d, actualAddRatioResult.getAverage());
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
		assertEquals(11.0d, actualAddRatioResult.getMax());
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio14() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableLazyEvaluation(10.0d, 10, 10.0d));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio15() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		Scalar numerator = new Scalar(Double.NaN);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio16() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableLazyEvaluation numerator = new RandomVariableLazyEvaluation(Double.NaN);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(10.0d));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio17() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator, new Scalar(Double.NaN));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio18() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d, 10, 10.0d);
		RandomVariableFromDoubleArray numerator = new RandomVariableFromDoubleArray(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableLazyEvaluation(Double.NaN));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(10.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}

	/**
	 * Method under test: {@link RandomVariableLazyEvaluation#addRatio(RandomVariable, RandomVariable)}
	 */
	@Test
	void testAddRatio19() {
		RandomVariableLazyEvaluation randomVariableLazyEvaluation = new RandomVariableLazyEvaluation(10.0d);
		Scalar numerator = new Scalar(10.0d);
		RandomVariable actualAddRatioResult = randomVariableLazyEvaluation.addRatio(numerator,
				new RandomVariableFromDoubleArray(Double.NEGATIVE_INFINITY, 10, Double.NEGATIVE_INFINITY));
		assertFalse(actualAddRatioResult.isDeterministic());
		assertEquals(10, actualAddRatioResult.size());
		assertEquals(0.0d, actualAddRatioResult.getFiltrationTime());
		assertEquals(10, actualAddRatioResult.getRealizations().length);
	}
}
