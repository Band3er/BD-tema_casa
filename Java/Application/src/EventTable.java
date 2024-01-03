import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class EventTable {
    // var initialization
    static Connect evnt = new Connect();

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
    public static JPanel createNewEventPanel() {
        panel = new JPanel(new GridLayout(10, 1));
        panel.setLayout(new FlowLayout());

        label1 = new JLabel("Name");
        textField1 = new JTextField(20);

        label2 = new JLabel("Date Event");
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // Don't know about the formatter, but there it is...
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());


        label3 = new JLabel("Location");
        textField3 = new JTextField(20);

        sendButton = new JButton("send info");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "event" button action
                // For example, get the text from the textField
                inputData1 = textField1.getText();

                Object selectedDateObject = datePicker.getModel().getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                inputData2 = dateFormat.format((Date) selectedDateObject);

                inputData3 = textField3.getText();
                // Perform actions related to the "Event" table

                //Display a message (you can customize this part)
                String query = "INSERT INTO EVENT(NAME, DATE_EVENT, LOCATION) VALUES('" + 
                    inputData1 + "','" + inputData2 + "','" + inputData3 + "')";

                    boolean st = evnt.populateTable(query);

                    if(st){
                        System.out.println("inserted Event ok");
                    } else {
                        System.out.println("inserted Event not ok");
                    }
            }
        });

        panel.add(label1);
        panel.add(textField1);

        panel.add(label2);
        panel.add(datePicker);

        panel.add(label3);
        panel.add(textField3);

        panel.add(sendButton);

        return panel;
    }


    
       
    // panel for the item All
    public static JPanel showItemEvent(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        sendButton = new JButton("Receive info");

        // Create a table model with some data
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Date");
        tableModel.addColumn("Location");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0); // sa nu se multiplice randurile in interfata
                try {
                    evnt.viewTableEvent(tableModel);
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
    public static JPanel deleteItemEvent(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        label1 = new JLabel("Select ID to be deleted");
        textField4 = new JTextField(20);

        sendButton = new JButton("Delete info");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputDataId = textField4.getText();
               
                String query = "DELETE FROM EVENT WHERE ID_EVENT = ";

                query = query.concat(inputDataId);
                
                boolean st = evnt.deleteTable(query);

                if (st) {
                    System.out.println("delete row event ok");
                } else {
                    System.out.println("delete event not ok");
                }
            }
        });

        panel.add(label1);
        panel.add(textField4);
        panel.add(sendButton);

        return panel;
    }
}
