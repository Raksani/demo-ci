import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayMathTest {
	final double TOL = 1.0E-6;

	@Test
	public void testDotProduct() {
		double[] x = {5.2};
		double[] y = {-7.5};
		double result = ArrayMath.dotProduct(x, y);
		assertEquals( x[0]*y[0], result, TOL);
		
		x = new double[] {1, 3, 5, 7, 9};
		y = new double[] {-2, 0.2, 4};
		assertEquals( 18.6, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( 18.6, ArrayMath.dotProduct(y, x), TOL);
	}

}
