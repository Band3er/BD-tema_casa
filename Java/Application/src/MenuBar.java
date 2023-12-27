import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    // var initialization
    JMenu fileMenu;
    JMenu tableDrinks;
    JMenu tableEntries;
    JMenu tableEvent;
    JMenu tableMenu;
    JMenu tableMoney;
    JMenu tablePersons;
    JMenu tableTransportation;
    JMenuItem newItem; 
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    public void init(JFrame mainFrame){
        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        fileMenu = new JMenu("File");
        tablePersons = new JMenu("Persons");
        tableEvent = new JMenu("Event");
        tableEntries = new JMenu("Entries");
        tableTransportation = new JMenu("Transportation");
        tableMenu = new JMenu("Menu");
        tableMoney = new JMenu("Money");
        tableDrinks = new JMenu("Drinks");

        // Create menu items
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        // Add action listeners to menu items
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add menu items to the menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Add a separator line
        fileMenu.add(exitItem);

        // Add the menu's to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(tableEvent);
        menuBar.add(tableTransportation);
        menuBar.add(tableMenu);
        menuBar.add(tableMoney);
        menuBar.add(tableDrinks);
        menuBar.add(tablePersons);
        menuBar.add(tableEntries);

        // Set the menu bar for the main frame
        mainFrame.setJMenuBar(menuBar);
    }
}
