package uk.co.ranaldo.calc.observer;

/**
 * structure/calc-mvc/CalcController.java - Controller Handles user interaction with listeners; calls View and Model as
 * needed.
 *
 * @author Fred Swatz - December 2004
 * @author S H S Wong - 26-02-2011
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class CalcObservedController {

    // The Controller needs to interact with both Model and View.
    private final CalcObservedModel m_model;
    private final CalcObservedView m_view;

    /**
     * Constructor!
     * @param model
     * @param view
     */
    public CalcObservedController(CalcObservedModel model, CalcObservedView view) {
        this.m_model = model;
        this.m_view = view;
        
        // So after twenty minutes, turns out it doesn't add observers automatically.
        // Who knew? The javadoc. Should go straight there next time.
        model.addObserver(view);

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
