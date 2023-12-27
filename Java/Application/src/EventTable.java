import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventTable {
    // var initialization
    JPanel panel;
    JTextField textField;
    JButton sendButton;

    public JPanel init(JFrame mainFrame){
        // Create a panel
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a text field for input
        textField = new JTextField(20);

        // Create a button for sending data to the database
        sendButton = new JButton("event");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text field
                //String inputData = textField.getText();

                // Simulate sending data to the database
                //sendToDatabase(inputData);

                // Clear the text field after sending
                textField.setText("");
            }
        });

        // Add components to the panel
        panel.add(textField);
        panel.add(sendButton);

        // Add the panel to the frame
        mainFrame.getContentPane().add(panel);

        return panel;
    }
}
