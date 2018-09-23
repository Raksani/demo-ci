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

}
