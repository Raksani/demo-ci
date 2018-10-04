import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayMathTest {
	final double TOL = 1.0E-6;

	@Test
	public void testDotProduct() {
		double[] x = {5.2};
		double[] y = {-7.5};
		double result = ArrayMath.dotProduct(x, y);
		assertEquals( x[0]*y[0], result, TOL);
		
		// vector of larger dimension
		x = new double[] {1, 3, 5, 7, 9};
		y = new double[] {-2, 0.2, 4, -1, 10.0};
		assertEquals( 101.6, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( 101.6, ArrayMath.dotProduct(y, x), TOL);
	}

	@Test
	public void testDotProductHugeVectors() {
		int len = 1_000_000;
		double[] x = new double[len];
		double[] y = new double[len];
		Random rand = new Random();
		double product = 0.0;
		for(int k=0; k<len; k++) {
			// to avoid overflowing the product using floats for elements
			double xk = (double) rand.nextFloat();
			double yk = (double) rand.nextFloat();
			x[k] = xk;
			y[k] = yk;
			product += xk*yk;
		}
		assertEquals( product, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( product, ArrayMath.dotProduct(y, x), TOL);
	}

	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testDotProductLengthsNotSame() {
		
		double[] x = new double[] {1, 3, 5, 7, 9};
		double[] y = new double[] {-2, 0.2, 4};
		assertEquals( 18.6, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( 18.6, ArrayMath.dotProduct(y, x), TOL);
	}
	
	@Test
	public void testSaxpyEmptyVector() {
		double[] x = new double[] { };
		double[] y = new double[] { };
		double[] r = ArrayMath.saxpy(10.0, x, y);
		assertEquals(0, r.length);
	}

	@Test
	public void testSaxpyTypicalVector() {
		double[] x = new double[] {-2.0, 2.5, 4.0 };
		double[] y = new double[] {10.0, 20.0, 30.0};
		double[] expect = {8.0, 22.5, 34.0};
		double[] r = ArrayMath.saxpy(1.0, x, y);
		assertArrayEquals(expect, r, TOL);
		// change the multiplier only
		expect = new double[] {-10.0, 45.0, 70.0};
		double[] r2 = ArrayMath.saxpy(10.0, x, y);
		assertArrayEquals(expect, r2, TOL);
	}
	
	@Test
	public void testSumSquaresEasyArray() {
		double[] y = new double[] {10.0, 20.0, 30.0};
		double expected = 10*10 + 20*20 + 30*30;
		assertEquals( expected, ArrayMath.sumSquares(y), TOL);
	}
}
