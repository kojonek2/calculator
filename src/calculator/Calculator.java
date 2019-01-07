package calculator;

public class Calculator {

	/**
	 * Solves ax^2 + bx + c = 0
	 * @return list of roots. When no roots are found then empty list is returned
	 */
	public static double[] squareRootsOfQuadraticEquation(double a, double b, double c) {
		if (a == 0)
			throw new IllegalArgumentException("a can't be equal to 0");
		
		double discriminant = b * b - 4 * a * c;
		if (discriminant < 0)
			return new double[0];
		
		if (discriminant == 0) {
			double result = (-b - Math.sqrt(discriminant)) / (2 * a);
			return new double[] { result };
		}
		
		double result1 = (-b - Math.sqrt(discriminant)) / (2 * a);
		double result2 = (-b - Math.sqrt(discriminant)) / (2 * a);
		return new double[] { result1, result2 };
	}
	
}
