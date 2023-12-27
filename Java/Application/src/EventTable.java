import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventTable {
    // var initialization
    JPanel panel;
    JTextField textField;

    public void init(JFrame frame){
        // Create a panel
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a text field for input
        textField = new JTextField(20);
    }
}
