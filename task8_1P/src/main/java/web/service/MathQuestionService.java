package web.service;

public class MathQuestionService {

	/**
	 * Calculate Q1 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q1Addition(String number1, String number2) {

		if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
			throw new IllegalArgumentException("Input cannot be empty");
		}

		try {
			double result = Double.parseDouble(number1) + Double.parseDouble(number2);
			return result;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid number format");
		}
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double q2Subtraction(String number1, String number2) {

		if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
			throw new IllegalArgumentException("Input cannot be empty");
		}

		try {
			double result = Double.parseDouble(number1) - Double.parseDouble(number2);
			return result;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid number format");
		}
	}
	public static double q3Multiplication(String number1, String number2) {

	    if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
	        throw new IllegalArgumentException("Input cannot be empty");
	    }

	    try {
	        double result = Double.parseDouble(number1) * Double.parseDouble(number2);
	        return result;
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Invalid number format");
	    }
	}
}

