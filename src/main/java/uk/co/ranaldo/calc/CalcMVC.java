package uk.co.ranaldo.calc;

import uk.co.ranaldo.calc.basic.CalcController;
import uk.co.ranaldo.calc.basic.CalcModel;
import uk.co.ranaldo.calc.basic.CalcView;
import uk.co.ranaldo.calc.observer.CalcObservedController;
import uk.co.ranaldo.calc.observer.CalcObservedModel;
import uk.co.ranaldo.calc.observer.CalcObservedView;

/**
 * structure/calc-mvc/CalcMVC.java - Calculator in MVC pattern. A calculator with multiple views.
 *
 * @author Fred Swartz - December 2004
 * @author S H S Wong - 26-02-2011
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class CalcMVC {
    
    public static void main(String[] args) {
        startBasic();
        startObserver();
    }

    private static void startBasic() {
        CalcModel model = new CalcModel();
        CalcView view1 = new CalcView(model);
        CalcController controller1 = new CalcController(model, view1);
        CalcView view2 = new CalcView(model);
        CalcController controller2 = new CalcController(model, view2);

        view1.setVisible(true);
        view2.setVisible(true);
    }

    private static void startObserver() {
        CalcObservedModel model = new CalcObservedModel();
        CalcObservedView view3 = new CalcObservedView(model);
        CalcObservedController controller3 = new CalcObservedController(model, view3);
        CalcObservedView view4 = new CalcObservedView(model);
        CalcObservedController controller4 = new CalcObservedController(model, view4);

        view3.setVisible(true);
        view4.setVisible(true);
    }
}
