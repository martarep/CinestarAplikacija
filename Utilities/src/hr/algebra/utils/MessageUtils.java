
package hr.algebra.utils;

import javax.swing.JOptionPane;


public class MessageUtils {

    public static void showInformationMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static int showConfirmDialog(String title, String message) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
    }

}
