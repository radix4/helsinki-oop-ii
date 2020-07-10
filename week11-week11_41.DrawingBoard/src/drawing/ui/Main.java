/**
 * This program draws a UI smile face.
 * @author  Thang Cao
 * @since   07/09/2020
 * */

package drawing.ui;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }
}
