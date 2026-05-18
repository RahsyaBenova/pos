package pos;

import UI.LoginPage;

/**
 * Main entry point for the Warehouse Inventory application.
 */
public class pos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Safely launch the Login Page inside the Swing Event Dispatch Thread
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
}