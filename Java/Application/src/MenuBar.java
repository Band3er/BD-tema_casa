import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    // var initialization
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu tableDrinks;
    JMenu tableEntries;
    JMenu tableEvent;
    JMenu tableMenu;
    JMenu tableMoney;
    JMenu tablePersons;
    JMenu tableTransportation;
    JMenuItem newItemFile; 
    JMenuItem openItemFile;
    JMenuItem saveItemFile;
    JMenuItem newItemEvent;
    JMenuItem allItemEvent;
    JMenuItem deleteItemEvent;

    public void init(JFrame mainFrame){
        // Create a menu bar
        menuBar = new JMenuBar();

        // Create a menu
        fileMenu = new JMenu("File");
        //tablePersons = new JMenu("Persons");
        tableEvent = new JMenu("Event");
        //tableEntries = new JMenu("Entries");
        //tableTransportation = new JMenu("Transportation");
        //tableMenu = new JMenu("Menu");
        //tableMoney = new JMenu("Money");
        //tableDrinks = new JMenu("Drinks");

        // Create menu items
        newItemFile = new JMenuItem("New");
        openItemFile = new JMenuItem("Open");
        saveItemFile = new JMenuItem("Save");

        newItemEvent = new JMenuItem("New");
        allItemEvent = new JMenuItem("All");
        deleteItemEvent = new JMenuItem("Delete");

        newItemEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("eventPanel");
            }
        });

        // Add menu items to the menu
        fileMenu.add(newItemFile);
        fileMenu.add(openItemFile);
        fileMenu.add(saveItemFile);
        
        // for table Event
        tableEvent.add(newItemEvent);
        tableEvent.add(allItemEvent);
        tableEvent.add(deleteItemEvent);
        
        // Add the menu's to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(tableEvent);
        //menuBar.add(tableTransportation);
        //menuBar.add(tableMenu);
        //menuBar.add(tableMoney);
        //menuBar.add(tableDrinks);
        //menuBar.add(tablePersons);
        //menuBar.add(tableEntries);


        // Set the menu bar for the main frame
        mainFrame.setJMenuBar(menuBar);
    }
}
