import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

public class App {
    // var initialization
    public static int screenHeight = 0;
    public static int screenWidth = 0;
    public static JFrame frame;
    public static MenuBar menuBar;
    public static Dimension screenSize;

    public static void main(String[] args) {
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
        menuBar = new MenuBar();
        menuBar.init(frame);

        // Set the frame to be visible
        frame.setVisible(true);

        //Connect conn = new Connect();
        //conn.init();
        //conn.close();
    }
}
