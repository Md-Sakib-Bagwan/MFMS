package utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorJOptionPane {

	public static void createErrorJOptionPane(JFrame frame, String messageText) {
		JOptionPane.showMessageDialog(frame, messageText, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
