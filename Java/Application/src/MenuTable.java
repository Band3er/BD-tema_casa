import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuTable {
    // var initialization
    static Connect mnu = new Connect();

    public static JPanel panel;

    public static JTextField textField1;
    public static JTextField textField2;
    public static JTextField textField3;
    public static JTextField textField4;

    public static String inputData1;
    public static String inputData2;
    public static String inputData3;

    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;

    public static JButton sendButton;

    // panel for the item new
    public static JPanel createNewMenuPanel() {
        panel = new JPanel(new GridLayout(10, 1));
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
                // Handle the button action
                
                inputData1 = textField1.getText();
                inputData2 = textField2.getText();
                inputData3 = textField3.getText();
                // Perform actions related to the MENU table

                // Display a message 
                String query = "INSERT INTO MENU(NAME, DESCRIPTION, COST) VALUES('" + 
                    inputData1 + "','" + inputData2 + "'," + inputData3 + ")";

              
                    boolean st = mnu.populateTable(query);
                    
                    if(st){
                        System.out.println("inserted menu ok");
                    } else {
                        System.out.println("inserted menu not ok");
                    }
            }
        });

        panel.add(label1);
        panel.add(textField1);
        
        panel.add(label2);
        panel.add(textField2);
        
        panel.add(label3);
        panel.add(textField3);


        panel.add(sendButton);

        return panel;
    }
    
    // panel for the item All
    public static JPanel showItemMenu(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        sendButton = new JButton("Receive info");

        // Create a table model with some data
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Description");
        tableModel.addColumn("Cost");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0); // sa nu se multiplice randurile in interfata
                try {
                    mnu.viewTableMenu(tableModel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JTable table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        panel.add(sendButton);

        return panel;
    }

    // panel for the item delete
    public static JPanel deleteItemMenu(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        label1 = new JLabel("Select ID to be deleted");
        textField4 = new JTextField(20);

        sendButton = new JButton("Delete info");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputDataId = textField4.getText();
               
                String query = "DELETE FROM MENU WHERE ID_MENU = ";

                query = query.concat(inputDataId);
                
                boolean st = mnu.deleteTable(query);

                if (st) {
                    System.out.println("delete row menu ok");
                } else {
                    System.out.println("delete menu not ok");
                }
            }
        });

        panel.add(label1);
        panel.add(textField4);
        panel.add(sendButton);

        return panel;
    }
}
