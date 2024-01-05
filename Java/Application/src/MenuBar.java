import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    // var initialization
    JMenuBar menuBar;

    JMenu mainInterface;
    JMenu tableDrinks;
    JMenu tableEvent;
    JMenu tableMenu;
    JMenu tablePersons;
    JMenu tableTransportation;

    JMenuItem mainItem;

    JMenuItem newItemEvent;
    JMenuItem allItemEvent;
    JMenuItem deleteItemEvent;

    JMenuItem newItemTransport;
    JMenuItem allItemTransport;
    JMenuItem deleteItemTransport;

    JMenuItem newItemMenu;
    JMenuItem allItemMenu;
    JMenuItem deleteItemMenu;

    JMenuItem newItemDrinks;
    JMenuItem allItemDrinks;
    JMenuItem deleteItemDrinks;

    JMenuItem newItemPersons;
    JMenuItem allItemPersons;
    JMenuItem deleteItemPersons;

    public void init(JFrame mainFrame){
        // Create a menu bar
        menuBar = new JMenuBar();

        // Create a menu
        mainInterface = new JMenu("Main");
        tableEvent = new JMenu("Event");
        tableTransportation = new JMenu("Transportation");
        tableMenu = new JMenu("Menu");
        tableDrinks = new JMenu("Drinks");
        tablePersons = new JMenu("Persons");

        // create main item
        mainItem = new JMenuItem("main");

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

        // create DRINKS items
        newItemDrinks = new JMenuItem("New");
        allItemDrinks = new JMenuItem("All");
        deleteItemDrinks = new JMenuItem("Delete");

        // create PERSONS items
        newItemPersons = new JMenuItem("New");
        allItemPersons = new JMenuItem("All");
        deleteItemPersons = new JMenuItem("Delete");
        
        // for the main interface
        mainInterface.add(mainItem);

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

        // for the table DRINKS
        tableDrinks.add(newItemDrinks);
        tableDrinks.add(allItemDrinks);
        tableDrinks.add(deleteItemDrinks);

        // for the table PERSONS
        tablePersons.add(newItemPersons);
        tablePersons.add(allItemPersons);
        tablePersons.add(deleteItemPersons);
        
        // Add the menu's to the menu bar
        menuBar.add(mainInterface);
        menuBar.add(tableEvent);
        menuBar.add(tableTransportation);
        menuBar.add(tableMenu);
        menuBar.add(tableDrinks);
        menuBar.add(tablePersons);


        // Set the menu bar for the main frame
        mainFrame.setJMenuBar(menuBar);

        // action listener for the table Event
        mainListener();
        eventListener();
        transportationListener();
        menuListener();
        drinksListener();
        personsListener();
    }

    // method for the main panel
    public void mainListener(){
        mainItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the showCard method in the App class to switch to the "eventPanel"
                App.showCard("mainInterface");
            }
        });
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

    // method for the TRANSPORTATION table, menu items listener
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

    // method for the MENU table, menu items listener
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

    // method for the DRINKS table, menu items listener
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
}
