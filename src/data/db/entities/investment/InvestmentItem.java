package data.db.entities.investment;

public class InvestmentItem {
	public String username;
	public String amcName;
	public String fundName;
	public String investedAmount;
	public String dateOfInvestment;
	public String balancedUnit;
	public String averageNav;
	public String currentNav;
	public String investmentType;
	public int folioNumber;
	public String xirr;
	public String tenureOfInvestment;

	public InvestmentItem() {
	}

	public InvestmentItem(String username, String amcName, String fundName, String investedAmount,
			String dateOfInvestment, String balancedUnit, String averageNav, String currentNav, String investmentType,
			int folioNumber, String xirr, String tenureOfInvestment) {
		super();
		this.username = username;
		this.amcName = amcName;
		this.fundName = fundName;
		this.investedAmount = investedAmount;
		this.dateOfInvestment = dateOfInvestment;
		this.balancedUnit = balancedUnit;
		this.averageNav = averageNav;
		this.currentNav = currentNav;
		this.investmentType = investmentType;
		this.folioNumber = folioNumber;
		this.xirr = xirr;
		this.tenureOfInvestment = tenureOfInvestment;
	}

}
