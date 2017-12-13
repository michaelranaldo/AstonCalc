package uk.co.ranaldo.calc;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * structure/calc-mvc/CalcView.java - View Component
 * Presentation only, no user actions.
 * @author Fred Swartz - December 2004
 * @author S H S Wong - 26-02-2011
 * @author Michael Ranaldo <michael@ranaldo.co.uk>
 */
public class CalcView extends JFrame {
    /**
     * Components
     */
    private final JTextField m_userInputTf = new JTextField(5);
    private final JTextField m_totalTf = new JTextField(20);
    private final JButton m_multiplyBtn = new JButton("Multiply");
    private final JButton m_clearBtn = new JButton("Clear");
    private final CalcModel  m_model;
    
    /**
     * Constructor, you're getting good at this.
     */
    CalcView(CalcModel model) {
        // Set up the logic
        this.m_model = model;
        
        // Initialize components
        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);
        
        // Lay out the components
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(m_userInputTf);
        content.add(m_multiplyBtn);
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);
        
        // Finalize the layout
        this.setContentPane(content);
        this.pack();
        
        this.setTitle("Simple Calc - MVC");
        // The window closing event should probably be passed to the Controller were this a real program. But it isn't.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void reset() {
        m_totalTf.setText(m_model.getValue());
    }
    
    String getUserInput() {
        return m_userInputTf.getText();
    }
    
    void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }
    
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    
    void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }
    
    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}
