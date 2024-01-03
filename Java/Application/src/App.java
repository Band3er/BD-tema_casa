import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static int screenHeight = 0;
    public static int screenWidth = 0;
    public static JFrame frame;
    public static MenuBar menuBar;
    public static CardLayout cardLayout;
    public static JPanel cardPanel;

    public static Connect conn;

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
        cardPanel.add(mainInterface(), "mainInterface"); // the main content
        
        // EVENT Panles
        cardPanel.add(EventTable.createNewEventPanel(), "newEventPanel"); // Content for the New Event table
        cardPanel.add(EventTable.showItemEvent(), "allEventPanel"); // Content for the All Event table
        cardPanel.add(EventTable.deleteItemEvent(), "deleteEventPanel"); // Content for the Delete Event table

        // TRANSPORTATIONS Panels
        cardPanel.add(TransportationTable.createNewTransportPanel(), "newTransportPanel"); // Content for the New Event table
        cardPanel.add(TransportationTable.showItemTransport(), "allTransportPanel"); // Content for the All Event table
        cardPanel.add(TransportationTable.deleteItemTransport(), "deleteTransportPanel"); // Content for the Delete Event table

        // MENU Panels
        cardPanel.add(MenuTable.createNewMenuPanel(), "newMenuPanel"); // Content for the New Event table
        cardPanel.add(MenuTable.showItemMenu(), "allMenuPanel"); // Content for the All Event table
        cardPanel.add(MenuTable.deleteItemMenu(), "deleteMenuPanel"); // Content for the Delete Event table

        // MONEY Panels
        cardPanel.add(MoneyTable.createNewMoneyPanel(), "newMoneyPanel"); // Content for the New Event table
        cardPanel.add(MoneyTable.showItemMoney(), "allMoneyPanel"); // Content for the All Event table
        cardPanel.add(MoneyTable.deleteItemMoney(), "deleteMoneyPanel"); // Content for the Delete Event table

        // DRINKS Panels
        cardPanel.add(DrinksTable.createNewDrinksPanel(), "newDrinksPanel"); // Content for the New Event table
        cardPanel.add(DrinksTable.showItemDrinks(), "allDrinksPanel"); // Content for the All Event table
        cardPanel.add(DrinksTable.deleteItemDrinks(), "deleteDrinksPanel"); // Content for the Delete Event table

        // PERSONS Panels
        cardPanel.add(PersonsTable.createNewPersonsPanel(), "newPersonsPanel"); // Content for the New Event table
        cardPanel.add(PersonsTable.showItemPersons(), "allPersonsPanel"); // Content for the All Event table
        cardPanel.add(PersonsTable.deleteItemPersons(), "deletePersonsPanel"); // Content for the Delete Event table

        // ENTRIES Panels
        cardPanel.add(EntriesTable.createNewEntriesPanel(), "newEntriesPanel"); // Content for the New Event table
        cardPanel.add(EntriesTable.showItemEntries(), "allEntriesPanel"); // Content for the All Event table
        cardPanel.add(EntriesTable.deleteItemEntries(), "deleteEntriesPanel"); // Content for the Delete Event table

        // Add cardPanel to the frame
        frame.getContentPane().add(cardPanel);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    public static void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }

    private static JPanel mainInterface(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton initButton = new JButton("Initialize DataBase connection");
        JButton closeButton = new JButton("Release DataBase connection");

        Connect conn = new Connect();

        initButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean init = conn.init();

                if(init){
                    System.out.println("Connection established");
                } else {
                    System.out.println("Connection not established");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean close = conn.close();

                if(close){
                    System.out.println("Connection closed succesfully");
                } else {
                    System.out.println("Connection not closed succesfully");
                }
            }
        });

        panel.add(initButton);
        panel.add(closeButton);

        return panel;
    }
}
