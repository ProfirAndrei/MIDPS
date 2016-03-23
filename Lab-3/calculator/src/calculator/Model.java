package calculator;

import java.math.BigDecimal;

/**
 * Created by Profir Andrei on 06.03.2016.
 */
public class Model {
    private BigDecimal mX;

    public BigDecimal calculations(String number, String operator) throws ArithmeticException {
        BigDecimal result = new BigDecimal("0");
        BigDecimal second = new BigDecimal(number);
        switch (operator) {
            case "plus":
                result = mX.add(second);
                break;

            case "minus":
                result = mX.subtract(second);
                break;

            case "multiply":
                result = mX.multiply(second);
                break;

            case "divide":
                if (second.doubleValue() == 0) {
                    if (mX.doubleValue() == 0)
                        throw new ArithmeticException("Result is undefined");
                    else
                        throw new ArithmeticException("Cannot divide by zero");
                }
                result = mX.divide(second, 20, BigDecimal.ROUND_HALF_UP);
                break;
        }

        return result;
    }

    public BigDecimal additionalCalculations(String number, String operator) {
        BigDecimal result = new BigDecimal("0");
        BigDecimal second = new BigDecimal(number);
        switch (operator) {
            case "sqrt":
                if (second.doubleValue() < 0)
                    throw new NumberFormatException("Invalid input");
                result = new BigDecimal("" + StrictMath.sqrt(second.doubleValue()));
                break;

            case "negate":
                result = second.negate();
                break;

            case "reciprocal":
                try {
                    result = (new BigDecimal("1")).divide(second, 20, BigDecimal.ROUND_HALF_UP);
                }
                catch (ArithmeticException e) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                break;

            case "sqr":
                try {
                    result = new BigDecimal(StrictMath.pow(second.doubleValue(), 2));
                }
                catch (NumberFormatException e) {
                    throw new NumberFormatException("Overflow");
                }
                break;

            case "percentage":
                if (mX != null)
                    result = mX.multiply(second.divide(new BigDecimal("100"),
                            10, BigDecimal.ROUND_HALF_UP));
                else
                    result = new BigDecimal("0");
                break;
        }

        return result;
    }

    public void setX(BigDecimal value) {
        mX = value;
    }

    public BigDecimal getX() {
        return mX;
    }
}
