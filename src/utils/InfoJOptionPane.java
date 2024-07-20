package utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InfoJOptionPane {
	public static void createInfoJOptionPane(JFrame frame, String messageText) {
		JOptionPane.showMessageDialog(frame, messageText, "Info", JOptionPane.INFORMATION_MESSAGE);
	}
}
