package model;

import enums.ArithmeticOperation;
import enums.TrigonometricFunction;

public class Model {

	private ArithmeticOperation arithmeticOperation = ArithmeticOperation.ADDITION;
	private TrigonometricFunction trigonometricFunction = TrigonometricFunction.SIN;
	
	public void setArithmeticOperator(ArithmeticOperation arithmeticOperation) {
		this.arithmeticOperation = arithmeticOperation;
	}
	
	
	public void setTrigonometricFunction(TrigonometricFunction trigonometricFunction) {
		this.trigonometricFunction = trigonometricFunction;
	}
	
	public double calculateArithmeticResult(double input1, double input2) {
		switch (arithmeticOperation) {
		case ADDITION:
			return input1 + input2;
		case SUBSTRACTION:
			return input1 - input2;
		case MULTIPLICATION:
			return input1 * input2;
		case QUOTIENT:
			return input1 / input2;
		default:
			return Double.NaN;
		}
	}
	
	public double calculateTrigonometricResult(double input) {
		switch (trigonometricFunction) {
		case SIN:
			return Math.sin(input);
		case COS:
			return Math.cos(input);
		case TAN:
			return Math.tan(input);
		case COT:
			return 1 / Math.tan(input);
		default:
			return Double.NaN;
		}
	}
	
}
