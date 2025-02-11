import javax.swing.SwingUtilities;  // Add this import

public class FortuneTellerViewer {
    public static void main(String[] args) {
        // Create an instance of the FortuneTellerFrame and display the window
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);
        });
    }
}
