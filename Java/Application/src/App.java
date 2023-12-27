import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Desktop.Action;
import java.awt.event.ActionListener;

public class App {
    // var initialization
    public static int screenHeight = 0;
    public static int screenWidth = 0;

    public static JFrame frame; // main Frame
    public static MenuBar menuBar;
    public static Dimension screenSize;

    public static EventTable eventTable;

    //Connect conn;

    //private static final String 
    private JPanel cardPanel;

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new App().createAndShowGUI());

        //conn = new Connect();
        //conn.init();
        //conn.close();
    }

    private void createAndShowGUI(){
        // Create a JFrame
        frame = new JFrame("Organizare gratar");

        // Set default close operation and size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame based on the pc's specs
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.pack();
        screenWidth = screenSize.width * 70 / 100;
        screenHeight = screenSize.height * 70 / 100;
        frame.setSize(screenWidth, screenHeight);

        // The location of the frame is set to center
        frame.setLocationRelativeTo(null);

        // Menu bar that contains all tables
        menuBar = new MenuBar();
        menuBar.init(frame);
        


        // table EVENT
        eventTable = new EventTable();


        cardPanel = new JPanel(new CardLayout());

        cardPanel.add(eventTable.init(frame));

        frame.getContentPane().add(cardPanel);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
