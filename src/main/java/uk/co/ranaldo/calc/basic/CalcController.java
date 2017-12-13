package uk.co.ranaldo.calc.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * structure/calc-mvc/CalcController.java - Controller Handles user interaction with listeners; calls View and Model as
 * needed.
 *
 * @author Fred Swatz - December 2004
 * @author S H S Wong - 26-02-2011
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class CalcController {

    // The Controller needs to interact with both Model and View.
    private final CalcModel m_model;
    private final CalcView m_view;

    /**
     * Constructor!
     */
    public CalcController(CalcModel model, CalcView view) {
        this.m_model = model;
        this.m_view = view;

        // Add listeners to the view
        view.addMultiplyListener(e -> {
            try {
                m_model.multiplyBy(m_view.getUserInput());
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
            }
        });
        
        view.addClearListener(e -> {
            m_model.reset();
            m_view.reset();
        });
    }
}
