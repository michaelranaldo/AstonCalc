package uk.co.ranaldo.calc;

import java.math.BigInteger;

/**
 * Model.
 * This model is independent of the user interface. It could just as easily be used by a command line or web interface.
 * @author Fred Swartz - December 2004
 * @author S H S Wong = 26-02-2011
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class CalcModel {
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
    CalcModel() {
        reset();
    }
    
    /**
     * Reset to initial value.
     */
    public void reset() {
        m_total = new BigInteger(INITIAL_VALUE);
    }
    
    /**
     * Multiply current total by a given number.
     * @param operand Number (String) to multiply by
     */
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigInteger(operand));
    }
    
    /**
     * Return current calculator total.
     */
    public String getValue() {
        return m_total.toString();
    }
}
