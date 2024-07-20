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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import contracts.LoginContract;
import model.LoginModel;
import presenters.LoginPresenter;
import utils.ErrorJOptionPane;
import utils.InfoJOptionPane;
import view.InvestmentsDashboard.InvestmentsDashboard;

public class LoginWindow implements LoginContract.LoginView {

	// UI elements
	public JFrame frame;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JPasswordField loginPinPasswordField;

	// arch instances
	private LoginPresenter loginPresenter;

	/**
	 * Launch the application.
	 */
	@Override
	public void runLoginWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
		initialize();
		loginPresenter = new LoginPresenter(this, new LoginModel());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 0, 300, 472);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mutual Fund");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setBounds(57, 159, 176, 28);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Investment Management System");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 189, 267, 28);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Manage all your mutual fund investments");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(16, 235, 264, 22);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("at one place");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(90, 258, 97, 22);
		panel.add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(13, 227, 267, 5);
		panel.add(separator);

		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_4.setBounds(335, 39, 89, 29);
		frame.getContentPane().add(lblNewLabel_4);

		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameTextField.setBounds(335, 113, 308, 30);
		frame.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Username");
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(335, 92, 75, 20);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Password");
		lblNewLabel_5_1.setBackground(Color.WHITE);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(335, 157, 75, 18);
		frame.getContentPane().add(lblNewLabel_5_1);

		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordTextField.setBounds(335, 179, 308, 30);
		frame.getContentPane().add(passwordTextField);

		JButton loginButton = new JButton("Login");
		loginButton.setIcon(new ImageIcon(LoginWindow.class.getResource("/res/icons/login_icon.png")));
		loginButton.setFont(new Font("Arial", Font.BOLD, 14));
		loginButton.setBounds(335, 288, 103, 34);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!checkAllFields()) {
					return;
				}

				if (!checkLoginPinField()) {
					return;
				}

				String username = usernameTextField.getText();
				char[] password = passwordTextField.getPassword();
				char[] login_pin = loginPinPasswordField.getPassword();
				loginPresenter.onLoginButtonClick(username, password, login_pin);
			}
		});

		JButton createAccountButton = new JButton("Create An Account");
		createAccountButton.setIcon(new ImageIcon(LoginWindow.class.getResource("/res/icons/create_account.png")));
		createAccountButton.setFont(new Font("Arial", Font.BOLD, 14));
		createAccountButton.setBounds(335, 398, 206, 34);
		frame.getContentPane().add(createAccountButton);
		createAccountButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginPresenter.onCreateAccountButtonClick();
			}
		});

		loginPinPasswordField = new JPasswordField();
		loginPinPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c)) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_BACK_SPACE)) {
					arg0.consume();
				}
			}
		});
		loginPinPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
		loginPinPasswordField.setBounds(335, 246, 308, 30);
		frame.getContentPane().add(loginPinPasswordField);

		JLabel lblNewLabel_7 = new JLabel("Login PIN");
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_7.setBounds(335, 224, 69, 20);
		frame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("Don't have an account?");
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(335, 370, 205, 18);
		frame.getContentPane().add(lblNewLabel_6);
	}

	private boolean checkAllFields() {

		if (usernameTextField.getText().isEmpty()) {
			showErrorJOptionPane("Username field is empty");
			return false;
		}

		if (passwordTextField.getPassword().length == 0) {
			showErrorJOptionPane("Password field is empty");
			return false;
		}

		if (loginPinPasswordField.getPassword().length == 0) {
			showErrorJOptionPane("Login pin field is empty");
			return false;
		}

		return true;
	}

	private boolean checkLoginPinField() {
		if (loginPinPasswordField.getPassword().length <= 3) {
			showErrorJOptionPane("Login pin is less than 4 digits");
			return false;
		}

		if (loginPinPasswordField.getPassword().length > 4) {
			showErrorJOptionPane("Login pin is more than 4 digits");
			return false;
		}

		return true;
	}

	@Override
	public void closeLoginWindow() {
		frame.dispose();
	}

	@Override
	public void showErrorJOptionPane(String errorMessage) {
		ErrorJOptionPane.createErrorJOptionPane(frame, errorMessage);
	}

	@Override
	public void showInfoJOptionPane(String infoMessage) {
		InfoJOptionPane.createInfoJOptionPane(frame, infoMessage);
	}

	@Override
	public void openInvestmentsDashboardWindow() {
		new InvestmentsDashboard().runInvestmentsDashboardWindow();
	}

	@Override
	public void openRegistrationWindow() {
		new RegistrationWindow().runRegistrationWindow();
	}
}
