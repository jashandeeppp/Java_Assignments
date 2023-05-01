package Assignment01;

abstract class Employees {
	private String fname;
	private String lname;
	private String Ssn;

	public Employees(String firstName, String lastName, String Ssn) {
		this.fname = firstName;
		this.lname = lastName;
		this.Ssn = Ssn;
	}

	public abstract void Earnings();
	public void StringTo(double wage) {
		System.out.println(getFname()+" "+getLname()+" "+getSsn());
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getSsn() {
		return Ssn;
	}
	public void setSsn(String ssn) {
		Ssn = ssn;
	}

}
