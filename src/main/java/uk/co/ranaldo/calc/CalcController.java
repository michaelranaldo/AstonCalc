package uk.co.ranaldo.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * structure/calc-mvc/CalcController.java - Controller
 * Handles user interaction with listeners; calls View and Model as needed.
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
    CalcController(CalcModel model, CalcView view) {
        this.m_model = model;
        this.m_view = view;
        
        // Add listeners to the view
        view.addMultiplyListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
    }
    
    /**
     * Inner Class, MultiplyListener.
     * When a multiplication is requested:
     * 1 - Get the user input number from the View.
     * 2 - Call the model to multiply by this number.
     * 3 - Get the result from the Model.
     * 4 - Tell the View to update the result.
     * 4.1 - If there was an error, tell the View to display it
     */
    class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                m_model.multiplyBy(m_view.getUserInput());
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException numberFormatException) {
                m_view.showError(numberFormatException.getMessage());
            }
        }
    } // Inner task completed, returning to your normal programming
    
    /**
     * Inner Class, ClearListener.
     * When a clearification is requested:
     * 1 - Reset the model.
     * 2 - Reset the view.
     */
    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    } // Inner task completed, returning to your normal programming
}
