import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTable {
    // var initialization
    public static JPanel panel;
    public static JTextField textField;
    public static JButton sendButton;

    public static JPanel createEventPanel() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        textField = new JTextField(20);
        sendButton = new JButton("event");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "event" button action
                // For example, get the text from the textField
                String inputData = textField.getText();
                // Perform actions related to the "Event" table

                // Display a message (you can customize this part)
                JOptionPane.showMessageDialog(null, "Event Data: " + inputData);

                // Clear the text field after handling the action
                textField.setText("");
            }
        });

        panel.add(textField);
        panel.add(sendButton);

        return panel;
    }
}
