import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonsTable {
    // var initialization
    static Connect prsn = new Connect();

    public static JPanel panel;

    public static JTextField textField1;
    public static JTextField textField2;
    public static JTextField textField3;
    public static JTextField textField4;
    public static JTextField textField5;
    public static JTextField textField6;
    public static JTextField textField7;
    public static JTextField textField8;
    public static JTextField textField9;
    public static JTextField textField10;
    public static JTextField textField11;

    public static String inputData1;
    public static String inputData2;
    public static String inputData3;
    public static String inputData4;
    public static String inputData5;
    public static String inputData6;
    public static String inputData7;
    public static String inputData8;
    public static String inputData9;
    public static String inputData10;

    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;
    public static JLabel label4;
    public static JLabel label5;
    public static JLabel label6;
    public static JLabel label7;
    public static JLabel label8;
    public static JLabel label9;
    public static JLabel label10;

    public static JButton sendButton;
    public static JButton getButton;

    public static JComboBox<String> transportComboBox;
    public static JComboBox<String> menuComboBox;
    public static JComboBox<String> drinksComboBox;

    static String firstNumber;
    static String secondNumber;
    static String thirdNumber;

    // panel for the item new
    public static JPanel createNewPersonsPanel() {
        panel = new JPanel(new GridLayout(30, 1));

        label1 = new JLabel("First Name");
        textField1 = new JTextField(20);

        label2 = new JLabel("Last Name");
        textField2 = new JTextField(20);

        label3 = new JLabel("AGE");
        textField3 = new JTextField(20);

        label4 = new JLabel("Address");
        textField4 = new JTextField(20);

        label5 = new JLabel("Phone Number");
        textField5 = new JTextField(20);

        label6 = new JLabel("EMAIL");
        textField6 = new JTextField(20);

        label7 = new JLabel("BUDGET");
        textField7 = new JTextField(20);

        label8 = new JLabel("Transport");
         
        
        
        label9 = new JLabel("Menu");
        textField9 = new JTextField(20);

        label10 = new JLabel("Drinks");
        textField10 = new JTextField(20);

        getButton = new JButton("get info");
        sendButton = new JButton("send info");

        transportComboBox = new JComboBox<>();
        menuComboBox = new JComboBox<>();
        drinksComboBox = new JComboBox<>();

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    
                    String[] transportOptions = prsn.getTransportOptions();
                    transportComboBox.setModel(new DefaultComboBoxModel<>(transportOptions));

                    String[] menuOptions = prsn.getMenuOptions();
                    menuComboBox.setModel(new DefaultComboBoxModel<>(menuOptions));

                    String[] drinksOptions = prsn.getDrinksOptions();
                    drinksComboBox.setModel(new DefaultComboBoxModel<>(drinksOptions));
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputData1 = textField1.getText(); // last name
                inputData2 = textField2.getText(); // first name
                inputData3 = textField3.getText(); // age
                inputData4 = textField4.getText(); // address
                inputData5 = textField5.getText(); // phone number
                inputData6 = textField6.getText(); // email
                inputData7 = textField7.getText(); // budget
                inputData8 = (String) transportComboBox.getSelectedItem(); // transport
                inputData9 = (String) menuComboBox.getSelectedItem(); // menu
                inputData10 = (String) drinksComboBox.getSelectedItem(); // drinks

                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(inputData8);

                if (matcher.find()) {
                    // Extract the matched number
                    firstNumber = matcher.group();
                } else {
                    System.out.println("No number found in the string.");
                }

                matcher = pattern.matcher(inputData9);

                if (matcher.find()) {
                    // Extract the matched number
                    secondNumber = matcher.group();
                } else {
                    System.out.println("No number found in the string.");
                }

                matcher = pattern.matcher(inputData10);

                if (matcher.find()) {
                    // Extract the matched number
                    thirdNumber = matcher.group();
                } else {
                    System.out.println("No number found in the string.");
                }

                String query = "INSERT INTO PERSONS(LAST_NAME, FIRST_NAME, AGE, ADDRESS, PHONE_NUMBER, EMAIL, BUDGET, TRANSPORT, MENU, DRINKS) VALUES('"
                + inputData1 + "','" + inputData2 + "'," + inputData3 + ",'"
                + inputData4 + "'," + inputData5 + ",'" + inputData6
                + "'," + inputData7 + "," + firstNumber + "," + secondNumber
                + "," + thirdNumber + ")";
                
                boolean st = prsn.populateTable(query);
                    
                    if(st){
                        System.out.println("inserted persons ok");
                    } else {
                        System.out.println("inserted persons not ok");
                    }
            }
        });

        panel.add(label1);
        panel.add(textField1);

        panel.add(label2);
        panel.add(textField2);

        panel.add(label3);
        panel.add(textField3);

        panel.add(label4);
        panel.add(textField4);

        panel.add(label5);
        panel.add(textField5);

        panel.add(label6);
        panel.add(textField6);

        panel.add(label7);
        panel.add(textField7);

        panel.add(label8);
        panel.add(transportComboBox);

        panel.add(label9);
        panel.add(menuComboBox);

        panel.add(label10);
        panel.add(drinksComboBox);

        panel.add(getButton);
        panel.add(sendButton);

        return panel;
    }

    
    
    // panel for the item All
    public static JPanel showItemPersons(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        sendButton = new JButton("Receive info");

        // Create a table model with some data
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("ID");
            tableModel.addColumn("First name");
            tableModel.addColumn("Last name");
            tableModel.addColumn("Age");
            tableModel.addColumn("Address");
            tableModel.addColumn("phone number");
            tableModel.addColumn("email");
            tableModel.addColumn("budget");
            tableModel.addColumn("transport");
            tableModel.addColumn("menu");
            tableModel.addColumn("drinks");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0); // sa nu se multiplice randurile in interfata
                try {
                    prsn.viewTablePersons(tableModel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JTable table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        scrollPane.setPreferredSize(new Dimension(screenSize.width*60/100, 200));
        panel.add(scrollPane);

        panel.add(sendButton);

        return panel;
    }

    // panel for the item delete
    public static JPanel deleteItemPersons(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        label1 = new JLabel("Select ID to be deleted");
        textField11 = new JTextField(20);

        sendButton = new JButton("Delete info");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputDataId = textField11.getText();
               //TODO: e foreign key si trb dat delete in cascada parca
                String query = "DELETE FROM PERSONS WHERE ID_PERSON = ";

                query = query.concat(inputDataId);
                
                boolean st = prsn.deleteTable(query);

                if (st) {
                    System.out.println("delete row persons ok");
                } else {
                    System.out.println("delete persons not ok");
                }
            }
        });

        panel.add(label1);
        panel.add(textField11);
        panel.add(sendButton);

        return panel;
    }
}
