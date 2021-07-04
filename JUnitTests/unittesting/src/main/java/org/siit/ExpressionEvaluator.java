package org.siit;


import java.util.List;

public class ExpressionEvaluator {

    public static int evaluate(Expression expression) {
        List<Object> elem = expression.getElements();

        if (elem.size() == 1){
            return (int) elem.get(0);
        }

        //TODO: implement case when elem has more than 3 elements


        int result = (int) elem.get(0);
        for (int i=0; i<(elem.size()-1)/2; ++i) {
            result = evalBinary(
                    result,
                    (int) elem.get(i*2+2),
                    (BinaryOperator) elem.get(i*2+1));
        }
        return result;

    }

    private static int evalBinary(int op1, int op2, BinaryOperator op) {
        return switch (op) {
            case ADD -> op1 + op2;
            case SUBTRACT -> op1 - op2;
            case MULTIPLY -> op1 * op2;
            case DIVIDE -> op1 / op2;
            case MODULUS -> op1 % op2;
            default -> throw new ValidationException("Unknown operator: " + op);
        };
    }

}
