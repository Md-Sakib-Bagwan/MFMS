package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import contracts.RegistrationContract;
import model.RegistrationModel;
import presenters.RegistrationPresenter;
import utils.ErrorJOptionPane;
import utils.InfoJOptionPane;
import utils.Log;

public class RegistrationWindow implements RegistrationContract.RegistrationView {

	// UI elements
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField usernameTextField;
	private JPasswordField confirmPasswordField;
	private JPasswordField pinPasswordField;
	private JPasswordField confirmPinPasswordField;

	// Logger
	private static String CLASS;
	Log log;

	// arch instances
	RegistrationPresenter registrationPresenter;

	/**
	 * Launch the application.
	 */
	@Override
	public void runRegistrationWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationWindow window = new RegistrationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrationWindow() {
		initialize();
		CLASS = this.getClass().getSimpleName();
		registrationPresenter = new RegistrationPresenter(this, new RegistrationModel());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 0, 496, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Create An Account");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 23, 224, 27);
		panel.add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(10, 195, 460, 30);
		frame.getContentPane().add(passwordField);

		JLabel lblNewLabel_5_1 = new JLabel("Password");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setBackground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(10, 171, 69, 19);
		frame.getContentPane().add(lblNewLabel_5_1);

		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(10, 132, 460, 30);
		frame.getContentPane().add(usernameTextField);

		JLabel lblNewLabel_5 = new JLabel("Username");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 108, 80, 20);
		frame.getContentPane().add(lblNewLabel_5);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
		confirmPasswordField.setBounds(10, 258, 460, 30);
		frame.getContentPane().add(confirmPasswordField);

		JLabel lblNewLabel_5_1_1 = new JLabel("Confirm Password");
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setBackground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5_1_1.setBounds(10, 234, 129, 20);
		frame.getContentPane().add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_5_1_1_1 = new JLabel("Create Login PIN");
		lblNewLabel_5_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_5_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5_1_1_1.setBounds(10, 297, 118, 21);
		frame.getContentPane().add(lblNewLabel_5_1_1_1);

		pinPasswordField = new JPasswordField();
		pinPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c)) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_BACK_SPACE)) {
					arg0.consume();
				}
			}
		});
		pinPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
		pinPasswordField.setBounds(10, 321, 460, 30);
		frame.getContentPane().add(pinPasswordField);

		confirmPinPasswordField = new JPasswordField();
		confirmPinPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c)) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_BACK_SPACE)) {
					arg0.consume();
				}
			}
		});
		confirmPinPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
		confirmPinPasswordField.setBounds(10, 384, 460, 30);
		frame.getContentPane().add(confirmPinPasswordField);

		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Confirm Login PIN");
		lblNewLabel_5_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_5_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5_1_1_1_1.setBounds(10, 360, 129, 18);
		frame.getContentPane().add(lblNewLabel_5_1_1_1_1);

		JButton createAccountButton = new JButton("Create An Account");
		createAccountButton
				.setIcon(new ImageIcon(RegistrationWindow.class.getResource("/res/icons/create_account.png")));
		createAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
		createAccountButton.setBounds(250, 423, 220, 34);
		frame.getContentPane().add(createAccountButton);
		createAccountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String username = usernameTextField.getText();
				String password = new String(passwordField.getPassword());
				String confirmPassword = new String(confirmPasswordField.getPassword());
				String loginPin = new String(pinPasswordField.getPassword());
				String confirmPinPassword = new String(confirmPinPasswordField.getPassword());

				if (!password.equals(confirmPassword)) {
					showErrorJOptionPane("Password fields dosen't match");
					return;
				}

				if (!loginPin.equals(confirmPinPassword)) {
					showErrorJOptionPane("Login pin fields dosen't match");
					return;
				}

				if (!checkAllFields()) {
					return;
				}

				if (!checkLoginPinPasswordField()) {
					return;
				}

				if (!checkConfirmLoginPinPasswordField()) {
					return;
				}

				registrationPresenter.onCreateAccountButtonClick(username, password, loginPin);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Already have an account?");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 496, 220, 20);
		frame.getContentPane().add(lblNewLabel_1);

		JButton loginButton = new JButton("Login");
		loginButton.setIcon(new ImageIcon(RegistrationWindow.class.getResource("/res/icons/login_icon.png")));
		loginButton.setFont(new Font("Arial", Font.BOLD, 16));
		loginButton.setBounds(219, 488, 111, 34);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registrationPresenter.onLoginButtonClick();
				new LoginWindow().runLoginWindow();
			}
		});

		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(83, 113, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("*");
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(83, 175, 45, 13);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("*");
		lblNewLabel_2_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(141, 238, 45, 13);
		frame.getContentPane().add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("*");
		lblNewLabel_2_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_3.setBounds(131, 301, 45, 13);
		frame.getContentPane().add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("*");
		lblNewLabel_2_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_4.setBounds(139, 364, 45, 13);
		frame.getContentPane().add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("*");
		lblNewLabel_2_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_5.setBounds(16, 83, 16, 13);
		frame.getContentPane().add(lblNewLabel_2_5);

		JLabel lblNewLabel_3 = new JLabel("Marked fields are mandatory");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(28, 80, 180, 15);
		frame.getContentPane().add(lblNewLabel_3);
	}

	@Override
	public void closeRegistrationWindow() {
		frame.dispose();
	}

	private boolean checkAllFields() {

		if (usernameTextField.getText().toString().isEmpty()) {
			showErrorJOptionPane("Username field is empty");
			return false;
		}

		if (passwordField.getPassword().length == 0) {
			showErrorJOptionPane("Password field is empty");
			return false;
		}

		if (confirmPasswordField.getPassword().length == 0) {
			showErrorJOptionPane("Confirm password field is empty");
			return false;
		}

		if (pinPasswordField.getPassword().length == 0) {
			showErrorJOptionPane("Login pin field is empty");
			return false;
		}

		if (confirmPinPasswordField.getPassword().length == 0) {
			showErrorJOptionPane("Confirm login pin field is empty");
			return false;
		}

		return true;
	}

	private boolean checkLoginPinPasswordField() {

		if (pinPasswordField.getPassword().length <= 3) {
			showErrorJOptionPane("Login pin is less than 4 digits");
			return false;
		}

		if (pinPasswordField.getPassword().length > 4) {
			showErrorJOptionPane("Login pin is more than 4 digits");
			return false;
		}

		return true;
	}

	private boolean checkConfirmLoginPinPasswordField() {

		if (confirmPinPasswordField.getPassword().length <= 3) {
			showErrorJOptionPane("Confirm login pin is less than 4 digits");
			return false;
		}

		if (confirmPinPasswordField.getPassword().length > 4) {
			showErrorJOptionPane("Confirm login pin is more than 4 digits");
			return false;
		}

		return true;
	}

	@Override
	public void showErrorJOptionPane(String errorMessage) {
		ErrorJOptionPane.createErrorJOptionPane(frame, errorMessage);
	}

	@Override
	public void showInfoJOptionPane(String infoMessage) {
		InfoJOptionPane.createInfoJOptionPane(frame, infoMessage);
	}
}
