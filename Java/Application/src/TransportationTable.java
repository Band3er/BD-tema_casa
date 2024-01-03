import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransportationTable {
    // var initialization
    public static JPanel panel;

    public static JTextField textField1;
    public static JTextField textField2;
    public static JTextField textField3;

    public static String inputData1;
    public static String inputData2;
    public static String inputData3;

    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;

    public static JButton sendButton;

    // panel for the item new
    public static JPanel createNewTransportPanel() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        label1 = new JLabel("Name");
        textField1 = new JTextField(20);

        label2 = new JLabel("Description");
        textField2 = new JTextField(20);

        label3 = new JLabel("Cost");
        textField3 = new JTextField(20);

        sendButton = new JButton("send info");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "event" button action
                // For example, get the text from the textField
                inputData1 = textField1.getText();
                inputData2 = textField2.getText();
                inputData3 = textField3.getText();
                // Perform actions related to the "Event" table

                // Display a message (you can customize this part)
                JOptionPane.showMessageDialog(null, "Name: " + inputData1 + ", Descripton: " + inputData2 + ", Cost:" + inputData3);

                // Clear the text field after handling the action
                textField1.setText("");
            }
        });

        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        panel.add(sendButton);

        return panel;
    }
    
    // panel for the item All
    public static JPanel showItemTransport(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

       

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });


        return panel;
    }

    // panel for the item delete
    public static JPanel deleteItemTransport(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

    

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });

      

        return panel;
    }
}
