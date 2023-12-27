import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Organizare gratar");

        // Create a JButton
        //JButton button = new JButton("Click Me");

        // Add ActionListener to the button
        /* button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform an action when the button is clicked
                System.out.println("Button Clicked!");
            }
        }); */

        // Add the button to the JFrame
        //frame.getContentPane().add(button);

        // Set default close operation and size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame based on the pc's specs
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.pack();
        frame.setSize(screenSize.width / 2, screenSize.height / 2);
        
        // The location of the frame is set to center
        frame.setLocationRelativeTo(null);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
