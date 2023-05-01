package Assignment01;

public class CommissionEmployee extends Employees{
	private double commissionRate;
	private double grossSales;
	
	public CommissionEmployee(String firstName, String lastName, String Ssn, double commissionRate, double grossSales) {
		super(firstName, lastName, Ssn);
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
	}

	@Override
	public void Earnings() {
		StringTo( commissionRate * grossSales);
	}
	@Override
	public void StringTo(double wage) {
		System.out.println("Commission Employee: "+getFname()+" "+getLname()+"\n"+"Social Security Number: "+getSsn()+"\nGross Sales: "+getGrossSales()+"\nCommission Rate: "+getCommissionRate()+"\nTotal Salary: "+wage);
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}
	
}
