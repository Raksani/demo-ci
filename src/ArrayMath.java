/**
 * Some linear algebra methods, for testing.
 * 
 * @author jim
 *
 */
public class ArrayMath {

	public static double dotProduct(double[] x, double[] y) {
		int size = Math.min(x.length, y.length);
		double product = 0.0;
		for (int k = 0; k < size; k++) {
			product += x[k]*y[k];
		}
		return product;
	}
}
