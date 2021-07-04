package org.siit;

import java.util.ArrayList;
import java.util.List;

public class StringExpression implements Expression {
	
	private List<Object> elements;
	
	public StringExpression(String expression) {
		elements = new ArrayList<>();

		// 1 + 2 -> {"1", "+", "2"} // 1 +; //empty_string // 1 * 5 // + 1 2
		String[] tokens = expression.trim().split("\\s+");

		if (tokens.length % 2 == 0 || tokens[0].isEmpty()){
			throw new ValidationException("Expression must have an odd number of tokens.");
		}

		//TODO: implement case when you have more than 3 tokens: 1 + 1 * 2 / 4...

		for (int i=0; i<tokens.length; ++i) {
			elements.add(i % 2 == 0
					? parseNumber(tokens[i])
					: parseOperator(tokens[i])) ;
		}
	}

	private BinaryOperator parseOperator(String token){
		for (BinaryOperator operator : BinaryOperator.values()){
			if(operator.getSymbol().equals(token))
				return operator;
		}
//		return null;
		//throw ValidationException
		throw new ValidationException("Operator " + token + " is not yet implemented");
	}

	private Integer parseNumber(String number){
		//TODO: verify if number is a number; if not -> throw validationException

		if (number.length() == 0) {
			throw new ValidationException("No value was entered");
		}
		if ( ! isNumber(number) ) {
			throw new ValidationException("Value '" + number + "' is not a number");
		}

		return Integer.parseInt(number);
	}

	public static boolean isNumber(String string) {

		for (int i = 0; i<string.length(); i++) {
			if ( ! Character.isDigit(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public List<Object> getElements() {
		return elements;
	}
}
