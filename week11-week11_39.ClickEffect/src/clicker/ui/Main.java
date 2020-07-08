/**
 * This program implements a calculator to counter the number of click.
 * @author  Thang Cao
 * @since   07/07/2020
 * */

package clicker.ui;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }
}
