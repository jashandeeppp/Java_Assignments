package Assignment01;

public class SalariedEmployee extends Employees {
	private double weeklySalary;
	public SalariedEmployee(String firstName, String lastName, String Ssn, double weeklySalary) {
		super(firstName, lastName, Ssn);
		this.weeklySalary = weeklySalary;
		
	}
	@Override
	public void Earnings() {
		StringTo (weeklySalary);
	}
	@Override
	public void StringTo(double wage) {
			System.out.println("Salaried Employee: "+getFname()+" "+getLname()+"\n"+"Social Security Number: "+getSsn()+"\n"+"Weekly Salary: "+wage);
	}

}
