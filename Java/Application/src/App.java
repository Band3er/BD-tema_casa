import javax.swing.*;
import java.awt.*;

public class App {
    public static int screenHeight = 0;
    public static int screenWidth = 0;
    public static JFrame frame;
    public static MenuBar menuBar;
    public static CardLayout cardLayout;
    public static JPanel cardPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().createAndShowGUI());
    }

   private void createAndShowGUI() {
        frame = new JFrame("Organizare gratar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame based on the pc's specs
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.pack();
        screenWidth = screenSize.width * 70 / 100;
        screenHeight = screenSize.height * 70 / 100;
        frame.setSize(screenWidth, screenHeight);

        // The location of the frame is set to center
        frame.setLocationRelativeTo(null);

        // Menu bar that contains all tables
        menuBar = new MenuBar();
        menuBar.init(frame);

        // Set up CardLayout and JPanel for dynamic content
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add the main panel and the event panel to cardPanel
        cardPanel.add(new JPanel(), "mainPanel"); // Placeholder for the main content
        
        // EVENT Panles
        cardPanel.add(EventTable.createNewEventPanel(), "newEventPanel"); // Content for the New Event table
        cardPanel.add(EventTable.showItemEvent(), "allEventPanel"); // Content for the All Event table
        cardPanel.add(EventTable.deleteItemEvent(), "deleteEventPanel"); // Content for the Delete Event table

        // TRANSPORTATIONS Panels
        cardPanel.add(TransportationTable.createNewTransportPanel(), "newTransportPanel"); // Content for the New Event table
        cardPanel.add(TransportationTable.showItemTransport(), "allTransportPanel"); // Content for the All Event table
        cardPanel.add(TransportationTable.deleteItemTransport(), "deleteTransportPanel"); // Content for the Delete Event table

        // Add cardPanel to the frame
        frame.getContentPane().add(cardPanel);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    public static void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }
}
