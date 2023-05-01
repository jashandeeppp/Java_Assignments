package Assignment01;

public class HourlyEmployee extends Employees{
	private double hourlyWage;
	private double hoursWorked;
	public HourlyEmployee(String firstName, String lastName, String SSN, double hourlyWage, double hoursWorked) {
		super(firstName, lastName, SSN);
		this.hourlyWage = hourlyWage;
		this.hoursWorked = hoursWorked;
	}
	@Override
	public void Earnings() {
		if(hoursWorked <= 40) {
			StringTo(hourlyWage * hoursWorked);
		}else if(hoursWorked > 40) {
			StringTo ((40*hourlyWage)+((hoursWorked-40)*hourlyWage*1.5));
		}	
	}
	@Override
	public void StringTo(double wage) {
		System.out.println("Hourly Employee: "+getFname()+" "+getLname()+"\n"+"Social Security Number: "+getSsn()+"\n"+"Hourly Wage: "+getHourlyWage()+"\n"+"Hours Worked: "+getHoursWorked()+"\n"+"Total Wage: "+wage);
	}
	
	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	

}
