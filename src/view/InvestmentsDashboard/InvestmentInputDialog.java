package view.InvestmentsDashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.db.entities.investment.InvestmentItem;

public class InvestmentInputDialog extends JDialog {

	/**
	 * declaring a static final serialVersionUID serializable class
	 * InvestmentInputDialog
	 */
	private static final long serialVersionUID = 1L;

	private static JTextField amcNameTextField;
	private static JTextField averageNavTextField;
	private static JTextField currentNavTextField;
	private static JTextField investedAmountTextField;
	private static JTextField dateOfInvestmentTextField;
	private static JTextField balancedUnitTextField;
	private static JTextField fundNameTextField;
	private static JTextField folioNumberTextField;
	private static JTextField xirrTextField;
	private static JTextField tenureOfInvestmentTextField;

	private static JLabel errorLabel;

	private JComboBox<String> investmentTypeComboBox;

	private static InvestmentItem investmentItemInput;

	private static String CLASS;

	/**
	 * Launch the application.
	 */
	public static void openInvestmentInputDialog() {
		try {
			InvestmentInputDialog dialog = new InvestmentInputDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InvestmentInputDialog() {

		CLASS = this.getClass().getSimpleName();

		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 553, 458);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 0, 540, 65);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("FILL FOLLOWING DETAILS TO ADD NEW INVESTMENT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 20, 433, 27);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("AMC Name");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 75, 78, 13);
		getContentPane().add(lblNewLabel_1);

		amcNameTextField = new JTextField();
		amcNameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		amcNameTextField.setBounds(10, 94, 517, 30);
		getContentPane().add(amcNameTextField);
		amcNameTextField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Average NAV");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 257, 162, 13);
		getContentPane().add(lblNewLabel_2);

		averageNavTextField = new JTextField();
		averageNavTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		averageNavTextField.setBounds(10, 278, 162, 30);
		getContentPane().add(averageNavTextField);
		averageNavTextField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Investment Type");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(366, 256, 118, 17);
		getContentPane().add(lblNewLabel_3);

		investmentTypeComboBox = new JComboBox<String>();
		investmentTypeComboBox.addItem("SIP");
		investmentTypeComboBox.addItem("Lumpsum");
		investmentTypeComboBox.setFont(new Font("Arial", Font.BOLD, 14));
		investmentTypeComboBox.setBounds(366, 278, 161, 30);
		getContentPane().add(investmentTypeComboBox);

		JLabel lblNewLabel_4 = new JLabel("Current NAV");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(189, 257, 150, 13);
		getContentPane().add(lblNewLabel_4);

		currentNavTextField = new JTextField();
		currentNavTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		currentNavTextField.setBounds(188, 277, 162, 30);
		getContentPane().add(currentNavTextField);
		currentNavTextField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Invested Amount");
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 195, 150, 13);
		getContentPane().add(lblNewLabel_5);

		investedAmountTextField = new JTextField();
		investedAmountTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		investedAmountTextField.setBounds(10, 214, 162, 30);
		getContentPane().add(investedAmountTextField);
		investedAmountTextField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Date of Investment");
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6.setBounds(188, 194, 150, 17);
		getContentPane().add(lblNewLabel_6);

		dateOfInvestmentTextField = new JTextField();
		dateOfInvestmentTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		dateOfInvestmentTextField.setBounds(188, 214, 162, 30);
		getContentPane().add(dateOfInvestmentTextField);
		dateOfInvestmentTextField.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Balanced Units");
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_7.setBounds(366, 196, 118, 13);
		getContentPane().add(lblNewLabel_7);

		balancedUnitTextField = new JTextField();
		balancedUnitTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		balancedUnitTextField.setBounds(366, 214, 161, 30);
		getContentPane().add(balancedUnitTextField);
		balancedUnitTextField.setColumns(10);

		fundNameTextField = new JTextField();
		fundNameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		fundNameTextField.setColumns(10);
		fundNameTextField.setBounds(10, 154, 517, 30);
		getContentPane().add(fundNameTextField);

		JLabel lblNewLabel_1_1 = new JLabel("Fund Name");
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 135, 87, 13);
		getContentPane().add(lblNewLabel_1_1);

		folioNumberTextField = new JTextField();
		folioNumberTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		folioNumberTextField.setColumns(10);
		folioNumberTextField.setBounds(10, 338, 162, 30);
		getContentPane().add(folioNumberTextField);

		JLabel lblNewLabel_2_1 = new JLabel("Folio Number");
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 319, 141, 13);
		getContentPane().add(lblNewLabel_2_1);

		xirrTextField = new JTextField();
		xirrTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		xirrTextField.setColumns(10);
		xirrTextField.setBounds(189, 338, 162, 30);
		getContentPane().add(xirrTextField);

		JLabel lblNewLabel_2_1_1 = new JLabel("XIRR");
		lblNewLabel_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(189, 319, 141, 13);
		getContentPane().add(lblNewLabel_2_1_1);

		tenureOfInvestmentTextField = new JTextField();
		tenureOfInvestmentTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		tenureOfInvestmentTextField.setColumns(10);
		tenureOfInvestmentTextField.setBounds(366, 338, 162, 30);
		getContentPane().add(tenureOfInvestmentTextField);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Tenure of investment");
		lblNewLabel_2_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(366, 319, 161, 13);
		getContentPane().add(lblNewLabel_2_1_1_1);

		JButton doneButton = new JButton("Done");
		doneButton.setFont(new Font("Arial", Font.BOLD, 16));
		doneButton.setBounds(425, 379, 102, 31);
		getContentPane().add(doneButton);
		doneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkAllFields()) {
					errorLabel.setText(null);

					dispose();

					String amcName = amcNameTextField.getText();
					String fundName = fundNameTextField.getText();
					String investedAmount = investedAmountTextField.getText();
					String dateOfInvestment = dateOfInvestmentTextField.getText();
					String balancedUnits = balancedUnitTextField.getText();
					String averageNav = averageNavTextField.getText();
					String currentNav = currentNavTextField.getText();
					String investmentType = investmentTypeComboBox.getSelectedItem().toString();
					int folioNumber = Integer.parseInt(folioNumberTextField.getText());
					String xirr = xirrTextField.getText();
					String tenureOfInvestment = tenureOfInvestmentTextField.getText();

					investmentItemInput = new InvestmentItem();

					investmentItemInput.amcName = amcName;
					investmentItemInput.fundName = fundName;
					investmentItemInput.investedAmount = investedAmount;
					investmentItemInput.dateOfInvestment = dateOfInvestment;
					investmentItemInput.balancedUnit = balancedUnits;
					investmentItemInput.averageNav = averageNav;
					investmentItemInput.currentNav = currentNav;
					investmentItemInput.investmentType = investmentType;
					investmentItemInput.folioNumber = folioNumber;
					investmentItemInput.xirr = xirr;
					investmentItemInput.tenureOfInvestment = tenureOfInvestment;

					InvestmentsDashboard.onDoneButtonClickFromDialog(investmentItemInput);
				}
			}
		});

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
		cancelButton.setBounds(313, 379, 102, 31);
		getContentPane().add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Arial", Font.ITALIC, 11));
		errorLabel.setBounds(10, 396, 293, 14);
		getContentPane().add(errorLabel);
	}

	private static boolean checkAllFields() {

		if (amcNameTextField.getText().isEmpty()) {
			errorLabel.setText("AMC name field is empty");
			return false;
		}

		if (fundNameTextField.getText().isEmpty()) {
			errorLabel.setText("Fund name field is empty");
			return false;
		}

		if (investedAmountTextField.getText().isEmpty()) {
			errorLabel.setText("Invested amount field is empty");
			return false;
		}

		if (dateOfInvestmentTextField.getText().isEmpty()) {
			errorLabel.setText("Date of investment field is empty");
			return false;
		}

		if (balancedUnitTextField.getText().isEmpty()) {
			errorLabel.setText("Balanced unit field is empty");
			return false;
		}

		if (averageNavTextField.getText().isEmpty()) {
			errorLabel.setText("Average NAV field is empty");
			return false;
		}

		if (currentNavTextField.getText().isEmpty()) {
			errorLabel.setText("Current NAV field is empty");
			return false;
		}

		if (folioNumberTextField.getText().isEmpty()) {
			errorLabel.setText("Folio number field is empty");
			return false;
		}

		if (xirrTextField.getText().isEmpty()) {
			errorLabel.setText("XIRR field is empty");
			return false;
		}

		if (tenureOfInvestmentTextField.getText().isEmpty()) {
			errorLabel.setText("Tenure of investment field is empty");
			return false;
		}

		return true;
	}
}
