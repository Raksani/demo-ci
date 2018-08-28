/**
 * Some linear algebra methods, for testing.
 * 
 * @author jim
 *
 */
public class ArrayMath {

	/**
	 * Compute dot product of two vectors.
	 * If the sizes differ, dot product is computed over
	 * the minimum of the two vector lengths. That is, extra
	 * elements from one vector are ignored.
	 * @param x first vector to multiply
	 * @param y second vector to multiply
	 * @return dot-product of x and y 
	 */
	public static double dotProduct(double[] x, double[] y) {
		int size = Math.min(x.length, y.length);
		double product = 0.0;
		for (int k = 0; k < size; k++) {
			product += x[k]*y[k];
		}
		return product;
	}
}
