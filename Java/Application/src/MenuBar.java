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

    JMenuItem newItemMoney;
    JMenuItem allItemMoney;
    JMenuItem deleteItemMoney;

    JMenuItem newItemDrinks;
    JMenuItem allItemDrinks;
    JMenuItem deleteItemDrinks;

    JMenuItem newItemPersons;
    JMenuItem allItemPersons;
    JMenuItem deleteItemPersons;

    JMenuItem newItemEntries;
    JMenuItem allItemEntries;
    JMenuItem deleteItemEntries;

    public void init(JFrame mainFrame){
        // Create a menu bar
        menuBar = new JMenuBar();

        // Create a menu
        fileMenu = new JMenu("File");
        tableEvent = new JMenu("Event");
        tableTransportation = new JMenu("Transportation");
        tableMenu = new JMenu("Menu");
        tableMoney = new JMenu("Money");
        tableDrinks = new JMenu("Drinks");
        tablePersons = new JMenu("Persons");
        tableEntries = new JMenu("Entries");

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

        // create MONEY items
        newItemMoney = new JMenuItem("New");
        allItemMoney = new JMenuItem("All");
        deleteItemMoney = new JMenuItem("Delete");

        // create DRINKS items
        newItemDrinks = new JMenuItem("New");
        allItemDrinks = new JMenuItem("All");
        deleteItemDrinks = new JMenuItem("Delete");

        // create PERSONS items
        newItemPersons = new JMenuItem("New");
        allItemPersons = new JMenuItem("All");
        deleteItemPersons = new JMenuItem("Delete");

        // create ENTRIES items
        newItemEntries = new JMenuItem("New");
        allItemEntries = new JMenuItem("All");
        deleteItemEntries = new JMenuItem("Delete");

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

        // for the table MONEY
        tableMoney.add(newItemMoney);
        tableMoney.add(allItemMoney);
        tableMoney.add(deleteItemMoney);

        // for the table DRINKS
        tableDrinks.add(newItemDrinks);
        tableDrinks.add(allItemDrinks);
        tableDrinks.add(deleteItemDrinks);

        // for the table PERSONS
        tablePersons.add(newItemPersons);
        tablePersons.add(allItemPersons);
        tablePersons.add(deleteItemPersons);

        // for the table ENTRIES
        tableEntries.add(newItemEntries);
        tableEntries.add(allItemEntries);
        tableEntries.add(deleteItemEntries);
        
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

        // action listener for the table Event
        eventListener();
        transportationListener();
        menuListener();
        moneyListener();
        drinksListener();
        personsListener();
        entriesListener();
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
                App.showCard("newMenuPanel");
            }
        });

        allItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("allMenuPanel");
            }
        });

        deleteItemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("deleteMenuPanel");
            }
        });
    }

    // money table item listener
    public void moneyListener(){
        newItemMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("newMoneyPanel");
            }
        });

        allItemMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("allMoneyPanel");
            }
        });

        deleteItemMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("deleteMoneyPanel");
            }
        });
    }

    // drinks table item listener
    public void drinksListener(){
        newItemDrinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("newDrinksPanel");
            }
        });

        allItemDrinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("allDrinksPanel");
            }
        });

        deleteItemDrinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("deleteDrinksPanel");
            }
        });
    }

    // method for the PERSONS table, menu items listener
    public void personsListener(){
        newItemPersons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("newPersonsPanel");
            }
        });

        allItemPersons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("allPersonsPanel");
            }
        });

        deleteItemPersons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("deletePersonsPanel");
            }
        });
    }

    // method for the ENTRIES table, menu items listener
    public void entriesListener(){
        newItemEntries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("newEntriesPanel");
            }
        });

        allItemEntries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("allEntriesPanel");
            }
        });

        deleteItemEntries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("deleteEntriesPanel");
            }
        });
    }
}
