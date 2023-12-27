import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DatabaseInputExampleWithMenu {
    private List<String> database = new ArrayList<>();
    private JPanel cardPanel;
    private static final String INPUT_PANEL = "InputPanel";
    private static final String BUTTON_PANEL = "ButtonPanel";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DatabaseInputExampleWithMenu().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Database Input Example");

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");

        // Create menu items
        JMenuItem inputMenuItem = new JMenuItem("Input Form");
        JMenuItem buttonMenuItem = new JMenuItem("Hello Button");

        // Add action listeners to menu items
        inputMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the input form panel when the "Input Form" menu item is selected
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, INPUT_PANEL);
            }
        });

        buttonMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the button panel when the "Hello Button" menu item is selected
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, BUTTON_PANEL);
            }
        });

        // Add the menu items to the menus
        fileMenu.add(inputMenuItem);
        viewMenu.add(buttonMenuItem);

        // Add the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Create a panel with CardLayout
        cardPanel = new JPanel(new CardLayout());

        // Create the input form panel
        JPanel inputPanel = createInputPanel();

        // Create the button panel
        JPanel buttonPanel = createButtonPanel();

        // Add panels to the cardPanel
        cardPanel.add(inputPanel, INPUT_PANEL);
        cardPanel.add(buttonPanel, BUTTON_PANEL);

        // Add the cardPanel to the frame
        frame.getContentPane().add(cardPanel);

        // Set default close operation and size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputData = textField.getText();
                sendToDatabase(inputData);
                textField.setText("");
            }
        });

        panel.add(textField);
        panel.add(sendButton);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton helloButton = new JButton("Hello There");

        helloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello There button clicked!");
            }
        });

        panel.add(helloButton);

        return panel;
    }

    private void sendToDatabase(String data) {
        database.add(data);
        System.out.println("Data sent to the database: " + data);
    }
}
