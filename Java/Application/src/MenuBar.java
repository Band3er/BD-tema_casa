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
    JMenuItem newItemTransport;
    JMenuItem allItemTransport;
    JMenuItem deleteItemTransport;
    JMenuItem newItemMenu;
    JMenuItem allItemMenu;
    JMenuItem deleteItemMenu;

    public void init(JFrame mainFrame){
        // Create a menu bar
        menuBar = new JMenuBar();

        // Create a menu
        fileMenu = new JMenu("File");
        //tablePersons = new JMenu("Persons");
        tableEvent = new JMenu("Event");
        //tableEntries = new JMenu("Entries");
        tableTransportation = new JMenu("Transportation");
        tableMenu = new JMenu("Menu");
        //tableMoney = new JMenu("Money");
        //tableDrinks = new JMenu("Drinks");

        // Create File items
        newItemFile = new JMenuItem("New");
        openItemFile = new JMenuItem("Open");
        saveItemFile = new JMenuItem("Save");

        // create EVENT items
        newItemEvent = new JMenuItem("New");
        allItemEvent = new JMenuItem("All");
        deleteItemEvent = new JMenuItem("Delete");

        // create TRANSPORATIONS items
        newItemTransport = new JMenuItem("New");
        allItemTransport = new JMenuItem("All");
        deleteItemTransport = new JMenuItem("Delete");

        // create MENU items
        newItemMenu = new JMenuItem("New");
        allItemMenu = new JMenuItem("All");
        deleteItemMenu = new JMenuItem("Delete");

        // Add menu items to the file
        fileMenu.add(newItemFile);
        fileMenu.add(openItemFile);
        fileMenu.add(saveItemFile);
        
        // for table Event
        tableEvent.add(newItemEvent);
        tableEvent.add(allItemEvent);
        tableEvent.add(deleteItemEvent);

        // for the table Transportation
        tableTransportation.add(newItemTransport);
        tableTransportation.add(allItemTransport);
        tableTransportation.add(deleteItemTransport);

        // for the table MENU
        tableMenu.add(newItemMenu);
        tableMenu.add(allItemMenu);
        tableMenu.add(deleteItemMenu);
        
        // Add the menu's to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(tableEvent);
        menuBar.add(tableTransportation);
        menuBar.add(tableMenu);
        //menuBar.add(tableMoney);
        //menuBar.add(tableDrinks);
        //menuBar.add(tablePersons);
        //menuBar.add(tableEntries);


        // Set the menu bar for the main frame
        mainFrame.setJMenuBar(menuBar);

        // action listener for the table Event
        eventListener();
        transportationListener();
        menuListener();
    }

    // method for the EVENT table, menu items listener
    public void eventListener(){
        newItemEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("newEventPanel");
            }
        });

        allItemEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("allEventPanel");
            }
        });

        deleteItemEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("deleteEventPanel");
            }
        });
    }

    public void transportationListener(){
        newItemTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("newTransportPanel");
            }
        });

        allItemTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("allTransportPanel");
            }
        });

        deleteItemTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("deleteTransportPanel");
            }
        });
    }

    // Menu table item listener
    public void menuListener(){
        newItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("newEventPanel");
            }
        });

        allItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("allEventPanel");
            }
        });

        deleteItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("deleteEventPanel");
            }
        });
    }
}
