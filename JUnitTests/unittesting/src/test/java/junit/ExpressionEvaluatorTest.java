package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.siit.Expression;
import org.siit.ExpressionEvaluator;
import org.siit.StringExpression;

import java.util.List;

class ExpressionEvaluatorTest {

	// given a list of elements -> should be the result of calling the constructor in StringExpression
	// verify the actual result of the operation

	private Expression mockExpression (List<Object> elements){
		Expression expr = Mockito.mock(Expression.class);
		Mockito.when(expr.getElements()).thenReturn(elements);
		return expr;
	}

	@Test
	void testZeroConstant() {
		Assertions.assertEquals(0, ExpressionEvaluator.evaluate( new StringExpression("0")));
	}
	
	@Test
	void testFiveConstant() {
		Assertions.assertEquals(5, ExpressionEvaluator.evaluate(new StringExpression("5")));
	}
	
	@Test
	void testMultiDigitConstant() {
		Assertions.assertEquals(123435, ExpressionEvaluator.evaluate(new StringExpression("123435")));
	}
	
	@Test
	void testSimpleAddition() {
		// 1 + 1
		int result = ExpressionEvaluator.evaluate(
				new StringExpression ("1 + 1"));
		Assertions.assertEquals(2, result);
	}

	//TODO: test -> 1 * 2 ; 1 + 1 + 1

	@Test
	void testSimpleMultiplication() {
		Assertions.assertEquals(2, ExpressionEvaluator.evaluate(new StringExpression("1 * 2")));
	}

	@Test
	void testMultipleOperandsAddition() {
		Assertions.assertEquals(3, ExpressionEvaluator.evaluate(new StringExpression("1 + 1 + 1")));
	}

	
}
