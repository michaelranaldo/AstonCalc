package uk.co.ranaldo.calc;


/**
 * structure/calc-mvc/CalcMVC.java - Calculator in MVC pattern.
 * A calculator with multiple views.
 * @author Fred Swartz - December 2004
 * @author S H S Wong - 26-02-2011
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class CalcMVC {
    
    public static void main(String[] args) {
        CalcModel model = new CalcModel();
        CalcView view1 = new CalcView(model);
        CalcController controller1 = new CalcController(model, view1);
        CalcView view2 = new CalcView(model);
        CalcController controller2 = new CalcController(model, view2);
        
        view1.setVisible(true);
        view2.setVisible(true);
    }
}