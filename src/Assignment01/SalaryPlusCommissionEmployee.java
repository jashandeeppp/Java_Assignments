package Assignment01;

public class SalaryPlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;
	public SalaryPlusCommissionEmployee(String firstName, String lastName, String Ssn, double commissionRate, double grossSales, double baseSalary) {
		super(firstName, lastName, Ssn, commissionRate, grossSales);
		this.baseSalary = baseSalary;
	}
	@Override
	public void Earnings() {
		baseSalary += baseSalary*0.1;
		StringTo(baseSalary+getCommissionRate()*getGrossSales());
	}
	@Override
	public void StringTo(double wage) {
			System.out.println("Base Salaried Commission Employee: "+getFname()+" "+getLname()+"\n"+"Social Security Number: "+getSsn()+"\nGross Sales: "+getGrossSales()+"\nCommission Rate: "+getCommissionRate()+"\nBase Salary: "+getBaseSalary()+"\nTotal Salary: "+wage);
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
}
