package net.finmath.montecarlo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import net.finmath.stochastic.RandomVariable;
import net.finmath.time.TenorFromArray;
import net.finmath.time.TimeDiscretization;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BrownianMotionFromMersenneRandomNumbersTests {
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#BrownianMotionFromMersenneRandomNumbers(TimeDiscretization, int, int, int)}
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#getNumberOfFactors()}
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#getNumberOfPaths()}
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#getSeed()}
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#getTimeDiscretization()}
	 * </ul>
	 */
	@Test
	void testConstructor() {
		TenorFromArray tenorFromArray = new TenorFromArray(10.0d, 10, 0.5d);

		BrownianMotionFromMersenneRandomNumbers actualBrownianMotionFromMersenneRandomNumbers = new BrownianMotionFromMersenneRandomNumbers(
				tenorFromArray, 3, 10, 42);

		assertEquals(3, actualBrownianMotionFromMersenneRandomNumbers.getNumberOfFactors());
		assertEquals(10, actualBrownianMotionFromMersenneRandomNumbers.getNumberOfPaths());
		assertEquals(42, actualBrownianMotionFromMersenneRandomNumbers.getSeed());
		assertSame(tenorFromArray, actualBrownianMotionFromMersenneRandomNumbers.getTimeDiscretization());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#BrownianMotionFromMersenneRandomNumbers(TimeDiscretization, int, int, int)}
	 */
	@Test
	void testConstructor2() {
		TenorFromArray tenorFromArray = new TenorFromArray(10.0d, 10, 0.5d);

		BrownianMotionFromMersenneRandomNumbers actualBrownianMotionFromMersenneRandomNumbers = new BrownianMotionFromMersenneRandomNumbers(
				tenorFromArray, 3, 10, 42);

		assertEquals(3, actualBrownianMotionFromMersenneRandomNumbers.getNumberOfFactors());
		assertSame(tenorFromArray, actualBrownianMotionFromMersenneRandomNumbers.getTimeDiscretization());
		assertEquals(42, actualBrownianMotionFromMersenneRandomNumbers.getSeed());
		assertEquals(10, actualBrownianMotionFromMersenneRandomNumbers.getNumberOfPaths());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#BrownianMotionFromMersenneRandomNumbers(net.finmath.time.TimeDiscretization, int, int, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Number of factors must be greater or equal 1 (given 0).
		//       at org.apache.commons.lang3.Validate.isTrue(Validate.java:110)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.<init>(BrownianMotionFromMersenneRandomNumbers.java:76)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.<init>(BrownianMotionFromMersenneRandomNumbers.java:102)
		//   In order to prevent <init>(TimeDiscretization, int, int, int)
		//   from throwing IllegalArgumentException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(TimeDiscretization, int, int, int).
		//   See https://diff.blue/R013 to resolve this issue.

		new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d), 0, 0, 1);

	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#BrownianMotionFromMersenneRandomNumbers(net.finmath.time.TimeDiscretization, int, int, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Number of paths must be greater or equal 1 (given 0).
		//       at org.apache.commons.lang3.Validate.isTrue(Validate.java:110)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.<init>(BrownianMotionFromMersenneRandomNumbers.java:77)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.<init>(BrownianMotionFromMersenneRandomNumbers.java:102)
		//   In order to prevent <init>(TimeDiscretization, int, int, int)
		//   from throwing IllegalArgumentException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(TimeDiscretization, int, int, int).
		//   See https://diff.blue/R013 to resolve this issue.

		new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d), 3, 0, 42);

	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#BrownianMotionFromMersenneRandomNumbers(TimeDiscretization, int, int, int, RandomVariableFactory)}
	 */
	@Test
	void testConstructor5() {
		TenorFromArray tenorFromArray = new TenorFromArray(10.0d, 10, 0.5d);

		BrownianMotionFromMersenneRandomNumbers actualBrownianMotionFromMersenneRandomNumbers = new BrownianMotionFromMersenneRandomNumbers(
				tenorFromArray, 3, 10, 42, new RandomVariableFloatFactory());

		assertEquals(3, actualBrownianMotionFromMersenneRandomNumbers.getNumberOfFactors());
		assertSame(tenorFromArray, actualBrownianMotionFromMersenneRandomNumbers.getTimeDiscretization());
		assertEquals(42, actualBrownianMotionFromMersenneRandomNumbers.getSeed());
		assertEquals(10, actualBrownianMotionFromMersenneRandomNumbers.getNumberOfPaths());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#BrownianMotionFromMersenneRandomNumbers(net.finmath.time.TimeDiscretization, int, int, int, RandomVariableFactory)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor6() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Number of factors must be greater or equal 1 (given 0).
		//       at org.apache.commons.lang3.Validate.isTrue(Validate.java:110)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.<init>(BrownianMotionFromMersenneRandomNumbers.java:76)
		//   In order to prevent <init>(TimeDiscretization, int, int, int, RandomVariableFactory)
		//   from throwing IllegalArgumentException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(TimeDiscretization, int, int, int, RandomVariableFactory).
		//   See https://diff.blue/R013 to resolve this issue.

		TenorFromArray timeDiscretization = new TenorFromArray(10.0d, 10, 0.5d);

		new BrownianMotionFromMersenneRandomNumbers(timeDiscretization, 0, 0, 1, new RandomVariableFloatFactory());

	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#BrownianMotionFromMersenneRandomNumbers(net.finmath.time.TimeDiscretization, int, int, int, RandomVariableFactory)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor7() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Number of paths must be greater or equal 1 (given 0).
		//       at org.apache.commons.lang3.Validate.isTrue(Validate.java:110)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.<init>(BrownianMotionFromMersenneRandomNumbers.java:77)
		//   In order to prevent <init>(TimeDiscretization, int, int, int, RandomVariableFactory)
		//   from throwing IllegalArgumentException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   <init>(TimeDiscretization, int, int, int, RandomVariableFactory).
		//   See https://diff.blue/R013 to resolve this issue.

		TenorFromArray timeDiscretization = new TenorFromArray(10.0d, 10, 0.5d);

		new BrownianMotionFromMersenneRandomNumbers(timeDiscretization, 3, 0, 42, new RandomVariableFloatFactory());

	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getCloneWithModifiedSeed(int)}
	 */
	@Test
	void testGetCloneWithModifiedSeed() {
		TenorFromArray tenorFromArray = new TenorFromArray(10.0d, 10, 0.5d);

		BrownianMotion actualCloneWithModifiedSeed = (new BrownianMotionFromMersenneRandomNumbers(tenorFromArray, 3, 10,
				42)).getCloneWithModifiedSeed(42);
		assertEquals(3, actualCloneWithModifiedSeed.getNumberOfFactors());
		assertSame(tenorFromArray, actualCloneWithModifiedSeed.getTimeDiscretization());
		assertEquals(42, ((BrownianMotionFromMersenneRandomNumbers) actualCloneWithModifiedSeed).getSeed());
		assertEquals(10, actualCloneWithModifiedSeed.getNumberOfPaths());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getCloneWithModifiedTimeDiscretization(TimeDiscretization)}
	 */
	@Test
	void testGetCloneWithModifiedTimeDiscretization() {
		BrownianMotionFromMersenneRandomNumbers brownianMotionFromMersenneRandomNumbers = new BrownianMotionFromMersenneRandomNumbers(
				new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42);
		TenorFromArray tenorFromArray = new TenorFromArray(10.0d, 10, 0.5d);

		BrownianMotion actualCloneWithModifiedTimeDiscretization = brownianMotionFromMersenneRandomNumbers
				.getCloneWithModifiedTimeDiscretization(tenorFromArray);
		assertEquals(3, actualCloneWithModifiedTimeDiscretization.getNumberOfFactors());
		assertSame(tenorFromArray, actualCloneWithModifiedTimeDiscretization.getTimeDiscretization());
		assertEquals(42, ((BrownianMotionFromMersenneRandomNumbers) actualCloneWithModifiedTimeDiscretization).getSeed());
		assertEquals(10, actualCloneWithModifiedTimeDiscretization.getNumberOfPaths());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getIncrement(int, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetIncrement() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getBrownianIncrement(BrownianMotionFromMersenneRandomNumbers.java:134)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getIncrement(BrownianMotionFromMersenneRandomNumbers.java:118)
		//   In order to prevent getIncrement(int, int)
		//   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   getIncrement(int, int).
		//   See https://diff.blue/R013 to resolve this issue.

		(new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42)).getIncrement(1, 3);
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getIncrement(int, int)}
	 */
	@Test
	void testGetIncrement2() {
		RandomVariable actualIncrement = (new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d),
				3, 10, 42)).getIncrement(1, 1);
		assertEquals(0.9836123913372975d, actualIncrement.getMax());
		assertEquals(1, actualIncrement.getTypePriority());
		assertFalse(actualIncrement.isDeterministic());
		assertEquals(11.0d, actualIncrement.getFiltrationTime());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getIncrement(int, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetIncrement3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 0
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getBrownianIncrement(BrownianMotionFromMersenneRandomNumbers.java:134)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getIncrement(BrownianMotionFromMersenneRandomNumbers.java:118)
		//   In order to prevent getIncrement(int, int)
		//   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   getIncrement(int, int).
		//   See https://diff.blue/R013 to resolve this issue.

		(new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(Double.NaN, 10, 0.5d), 3, 10, 42)).getIncrement(1,
				3);
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getIncrement(int, int)}
	 */
	@Test
	void testGetIncrement4() {
		assertThrows(NegativeArraySizeException.class,
				() -> (new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, -1, 0.5d), 3, 10, 42))
						.getIncrement(1, 3));
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getIncrement(int, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetIncrement5() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.doGenerateBrownianMotion(BrownianMotionFromMersenneRandomNumbers.java:149)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getBrownianIncrement(BrownianMotionFromMersenneRandomNumbers.java:127)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getIncrement(BrownianMotionFromMersenneRandomNumbers.java:118)
		//   In order to prevent getIncrement(int, int)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   getIncrement(int, int).
		//   See https://diff.blue/R013 to resolve this issue.

		(new BrownianMotionFromMersenneRandomNumbers(null, 3, 10, 42)).getIncrement(1, 3);
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getBrownianIncrement(int, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetBrownianIncrement() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getBrownianIncrement(BrownianMotionFromMersenneRandomNumbers.java:134)
		//   In order to prevent getBrownianIncrement(int, int)
		//   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   getBrownianIncrement(int, int).
		//   See https://diff.blue/R013 to resolve this issue.

		(new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42))
				.getBrownianIncrement(1, 3);
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getBrownianIncrement(int, int)}
	 */
	@Test
	void testGetBrownianIncrement2() {
		RandomVariable actualBrownianIncrement = (new BrownianMotionFromMersenneRandomNumbers(
				new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42)).getBrownianIncrement(1, 1);
		assertEquals(0.9836123913372975d, actualBrownianIncrement.getMax());
		assertEquals(1, actualBrownianIncrement.getTypePriority());
		assertFalse(actualBrownianIncrement.isDeterministic());
		assertEquals(11.0d, actualBrownianIncrement.getFiltrationTime());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getBrownianIncrement(int, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetBrownianIncrement3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 0
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getBrownianIncrement(BrownianMotionFromMersenneRandomNumbers.java:134)
		//   In order to prevent getBrownianIncrement(int, int)
		//   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   getBrownianIncrement(int, int).
		//   See https://diff.blue/R013 to resolve this issue.

		(new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(Double.NaN, 10, 0.5d), 3, 10, 42))
				.getBrownianIncrement(1, 3);
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getBrownianIncrement(int, int)}
	 */
	@Test
	void testGetBrownianIncrement4() {
		assertThrows(NegativeArraySizeException.class,
				() -> (new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, -1, 0.5d), 3, 10, 42))
						.getBrownianIncrement(1, 3));
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getBrownianIncrement(int, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetBrownianIncrement5() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.doGenerateBrownianMotion(BrownianMotionFromMersenneRandomNumbers.java:149)
		//       at net.finmath.montecarlo.BrownianMotionFromMersenneRandomNumbers.getBrownianIncrement(BrownianMotionFromMersenneRandomNumbers.java:127)
		//   In order to prevent getBrownianIncrement(int, int)
		//   from throwing NullPointerException, add constructors or factory
		//   methods that make it easier to construct fully initialized objects used in
		//   getBrownianIncrement(int, int).
		//   See https://diff.blue/R013 to resolve this issue.

		(new BrownianMotionFromMersenneRandomNumbers(null, 3, 10, 42)).getBrownianIncrement(1, 3);
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#getRandomVariableForConstant(double)}
	 */
	@Test
	void testGetRandomVariableForConstant() {
		assertEquals(10.0d,
				(new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42))
						.getRandomVariableForConstant(10.0d)
						.getMax());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#equals(Object)}
	 */
	@Test
	void testEquals() {
		assertNotEquals(new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42), null);
		assertNotEquals(new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42),
				"Different type to BrownianMotionFromMersenneRandomNumbers");
	}

	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#equals(Object)}
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#hashCode()}
	 * </ul>
	 */
	@Test
	void testEquals2() {
		BrownianMotionFromMersenneRandomNumbers brownianMotionFromMersenneRandomNumbers = new BrownianMotionFromMersenneRandomNumbers(
				new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42);
		assertEquals(brownianMotionFromMersenneRandomNumbers, brownianMotionFromMersenneRandomNumbers);
		int expectedHashCodeResult = brownianMotionFromMersenneRandomNumbers.hashCode();
		assertEquals(expectedHashCodeResult, brownianMotionFromMersenneRandomNumbers.hashCode());
	}

	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#equals(Object)}
	 *   <li>{@link BrownianMotionFromMersenneRandomNumbers#hashCode()}
	 * </ul>
	 */
	@Test
	void testEquals3() {
		BrownianMotionFromMersenneRandomNumbers brownianMotionFromMersenneRandomNumbers = new BrownianMotionFromMersenneRandomNumbers(
				new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42);
		BrownianMotionFromMersenneRandomNumbers brownianMotionFromMersenneRandomNumbers1 = new BrownianMotionFromMersenneRandomNumbers(
				new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42);

		assertEquals(brownianMotionFromMersenneRandomNumbers, brownianMotionFromMersenneRandomNumbers1);
		int expectedHashCodeResult = brownianMotionFromMersenneRandomNumbers.hashCode();
		assertEquals(expectedHashCodeResult, brownianMotionFromMersenneRandomNumbers1.hashCode());
	}

	/**
	 * Method under test: {@link BrownianMotionFromMersenneRandomNumbers#equals(Object)}
	 */
	@Test
	void testEquals4() {
		BrownianMotionFromMersenneRandomNumbers brownianMotionFromMersenneRandomNumbers = new BrownianMotionFromMersenneRandomNumbers(
				new TenorFromArray(0.5d, 10, 0.5d), 3, 10, 42);
		assertNotEquals(brownianMotionFromMersenneRandomNumbers,
				new BrownianMotionFromMersenneRandomNumbers(new TenorFromArray(10.0d, 10, 0.5d), 3, 10, 42));
	}
}
