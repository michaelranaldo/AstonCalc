package uk.co.ranaldo.calc.observer;

import java.math.BigInteger;
import java.util.Observable;

/**
 * Code is based on that written by Fred Swartz and S H S Wong within uk.co.ranaldo.calc.basic.CalcModel with the
 * exception of an added "Observable" tag and some extra functions to keep the model synchronized.
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class CalcObservedModel extends Observable {

    /**
     * Constants
     */
    private static final String INITIAL_VALUE = "1";

    /**
     * ... Member variable defining state of calculator
     */
    private BigInteger m_total;

    /**
     * Constructor, but you know that.
     */
    public CalcObservedModel() {
        reset();
    }

    /**
     * Reset to initial value.
     */
    public void reset() {
        m_total = new BigInteger(INITIAL_VALUE);
        fireChange(m_total.toString());
    }

    /**
     * Multiply current total by a given number.
     *
     * @param operand Number (String) to multiply by
     */
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigInteger(operand));
        fireChange(m_total.toString());
    }

    /**
     * Return current calculator total.
     * @return String representation of current value
     */
    public String getValue() {
        return m_total.toString();
    }
    
    private void fireChange(String value) {
        setChanged();
        notifyObservers(value);
    }
}
