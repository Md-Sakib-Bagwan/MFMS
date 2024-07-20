package view.InvestmentsDashboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Application.Main;
import contracts.InvestmentsDashboardContract;
import data.db.entities.investment.InvestmentItem;
import data.db.entities.user.User;
import model.InvestmentsDashboardModel;
import presenters.InvestmentsDashboardPresenter;
import presenters.LoginPresenter;
import utils.InfoJOptionPane;
import utils.Log;

public class InvestmentsDashboard implements InvestmentsDashboardContract.InvestmentsDashboardView {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private Object[] columns;

	// logger
	private static String CLASS;
	Log log;

	// arch instances
	private static InvestmentsDashboardContract.InvestmentsDashboardPresenter investmentsDashboardPresenter;

	// current login username
	JLabel usernameLabel;
	JLabel investedAmountLabel;

	/**
	 * Launch the application.
	 */
	@Override
	public void runInvestmentsDashboardWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvestmentsDashboard window = new InvestmentsDashboard();
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
	public InvestmentsDashboard() {
		initialize();
		investmentsDashboardPresenter = new InvestmentsDashboardPresenter(new InvestmentsDashboardModel(), this);
		CLASS = this.getClass().getSimpleName();
		populateJTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 0, 1196, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("INVESTMENTS DASHBOARD");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(23, 23, 311, 22);
		panel.add(lblNewLabel);

		JButton logoutButton = new JButton("Logout");
		logoutButton.setIcon(new ImageIcon(InvestmentsDashboard.class.getResource("/res/icons/logout_icon.png")));
		logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setBackground(Color.DARK_GRAY);
		logoutButton.setBounds(1035, 17, 118, 36);
		panel.add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeInvestmentDashboardWindow();
				Main.runApplication();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Welcome,");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(730, 28, 81, 14);
		panel.add(lblNewLabel_1);

		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(808, 26, 215, 18);
		panel.add(usernameLabel);
		usernameLabel.setText(LoginPresenter.getUsernameForInvestmentRef());

		JButton addInvestmentButton = new JButton("Add New Investment");
		addInvestmentButton.setIcon(new ImageIcon(InvestmentsDashboard.class.getResource("/res/icons/add_icon.png")));
		addInvestmentButton.setFont(new Font("Arial", Font.BOLD, 16));
		addInvestmentButton.setBounds(928, 559, 227, 34);
		frame.getContentPane().add(addInvestmentButton);
		addInvestmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new InvestmentInputDialog().openInvestmentInputDialog();
			}
		});

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(24, 550, 1130, 5);
		frame.getContentPane().add(separator);

		columns = new Object[] { "AMC name", "Fund name", "Invested amount", "Date of investment", "Balanced units",
				"Average NAV", "Current NAV", "Investment type", "Folio number", "XIRR", "Tenure of investment" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table = new JTable();
		table.setModel(model);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setForeground(Color.BLACK);
		table.setModel(model);
		table.setRowHeight(30);
		table.setBackground(Color.WHITE);
		table.setBounds(24, 106, 1131, 434);
		table.setSelectionForeground(Color.WHITE);
		table.setPreferredScrollableViewportSize(new Dimension(300, 200));
		table.setAutoCreateRowSorter(true);
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setForeground(Color.YELLOW);
		tableScrollPane.setBackground(Color.YELLOW);
		tableScrollPane.setBounds(24, 107, 1130, 438);
		JTableHeader jTableHeader = table.getTableHeader();
		jTableHeader.setFont(new Font("Arial", Font.BOLD, 13));
		frame.getContentPane().add(tableScrollPane);

		JLabel lblNewLabel_4 = new JLabel("Funds you have invested:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setBounds(24, 77, 198, 19);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("Invested Amount:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(26, 560, 135, 18);
		frame.getContentPane().add(lblNewLabel_3);

		investedAmountLabel = new JLabel("Some Amt.");
		investedAmountLabel.setForeground(Color.WHITE);
		investedAmountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		investedAmountLabel.setBounds(24, 582, 137, 13);
		frame.getContentPane().add(investedAmountLabel);

		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String amcName = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				String fundName = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
				String investedAmount = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
				String dateOfInvestment = table.getModel().getValueAt(table.getSelectedRow(), 3).toString();
				String balancedUnits = table.getModel().getValueAt(table.getSelectedRow(), 4).toString();
				String averageNav = table.getModel().getValueAt(table.getSelectedRow(), 5).toString();
				String currentNav = table.getModel().getValueAt(table.getSelectedRow(), 6).toString();
				String investmentType = table.getModel().getValueAt(table.getSelectedRow(), 8).toString();
				String folioNumber = table.getModel().getValueAt(table.getSelectedRow(), 8).toString();
				String xirr = table.getModel().getValueAt(table.getSelectedRow(), 9).toString();
				String tenure = table.getModel().getValueAt(table.getSelectedRow(), 10).toString();

				InvestmentUpdateDialog.openInvestmentUpdateDialog(
						amcName, fundName, investedAmount, dateOfInvestment, 
						balancedUnits, averageNav, currentNav, folioNumber, investmentType, xirr, tenure);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setIcon(new ImageIcon(InvestmentsDashboard.class.getResource("/res/icons/edit_icon.png")));
		btnNewButton_2.setBounds(815, 559, 103, 34);
		frame.getContentPane().add(btnNewButton_2);

		JButton redeemButton = new JButton("Redeem");
		redeemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InvestmentItem investmentItem = new InvestmentItem();
				
				investmentItem.username = LoginPresenter.getUsernameForInvestmentRef();
				investmentItem.investmentType = table.getModel().getValueAt(table.getSelectedRow(), 7).toString();
				investmentItem.folioNumber = Integer.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 8).toString());
				
				investmentsDashboardPresenter.onRedeemButtonClick(investmentItem);
			}
		});
		redeemButton.setFont(new Font("Arial", Font.BOLD, 16));
		redeemButton.setIcon(new ImageIcon(InvestmentsDashboard.class.getResource("/res/icons/redeem_icon.png")));
		redeemButton.setBounds(670, 559, 135, 34);
		frame.getContentPane().add(redeemButton);
	}

	@Override
	public void closeInvestmentDashboardWindow() {
		this.frame.dispose();
	}

	@Override
	public void showInfoJOptionPane(String message) {
		InfoJOptionPane.createInfoJOptionPane(frame, message);
	}

	public static void onDoneButtonClickFromDialog(InvestmentItem investmentItem) {
		investmentsDashboardPresenter.onDoneButtonClick(investmentItem);
	}
	
	public static void onUpdateButtonClickFromDialog(InvestmentItem investmentItem) {
		investmentsDashboardPresenter.onUpdateButtonClick(investmentItem);
	}

	@Override
	public void populateJTable() {
		model.setRowCount(0);

		int totalInvestedAmount = 0;
		
		User user = new User();
		user.username = usernameLabel.getText();
		ArrayList<InvestmentItem> investmentItems = investmentsDashboardPresenter.onLogin(user);

		for (int i = 0; i < investmentItems.size(); i++) {

			String amcName = investmentItems.get(i).amcName;
			String addInvestmentItem = investmentItems.get(i).fundName;
			String investedAmount = investmentItems.get(i).investedAmount;
			String dateOfInvestment = investmentItems.get(i).dateOfInvestment;
			String balancedUnit = investmentItems.get(i).balancedUnit;
			String averageNav = investmentItems.get(i).averageNav;
			String currentNav = investmentItems.get(i).currentNav;
			String investmentType = investmentItems.get(i).investmentType;
			String folioNumber = String.valueOf(investmentItems.get(i).folioNumber);
			String xirr = investmentItems.get(i).xirr;
			String tenureOfInvestment = investmentItems.get(i).tenureOfInvestment;
			
			totalInvestedAmount += Integer.valueOf(investedAmount);

			row = new Object[] { amcName, addInvestmentItem, investedAmount, dateOfInvestment, balancedUnit, averageNav,
					currentNav, investmentType, folioNumber, xirr, tenureOfInvestment };
			model.addRow(row);
		}
		
		investedAmountLabel.setText(String.valueOf("Rs. " + totalInvestedAmount));
	}
}
