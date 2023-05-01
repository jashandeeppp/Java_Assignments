package Assignment01;

/*
	•	A company pays its employees on a weekly basis.
	•	The employees are of four types:
	•	Salaried employees are paid a fixed weekly salary regardless of the number of hours worked.
	•	Hourly employees are paid by the hour and receive "time-and-a-half" overtime pay for all hours worked in excess of 40 hours.
	•	Commission employees are paid a percentage of their sales.
	•	Salaried-commission employees receive a base salary plus a percentage of their sales.
	•	For the current pay period, the company has decided to reward salaried-commission employees by adding 10% to their base salaries.
	•	The company wants to implement an app that performs its payroll calculations polymorphically.
	•	Use class Employee to represent the general concept of an employee.
	•	SalariedEmployee, CommissionEmployee and HourlyEmployee extend Employee.
	•	Class SalaryPlusCommissionEmployee – which extends CommissionEmployee – represents the last employee type.
	•	Base class Employee provides method Earnings, in addition to the properties that manipulate Employee’s instance variables.
	•	Each earnings calculation depends on the employee’s class, so we override Earnings in each class.
	•	The app iterates through the array and calls method Earnings for each Employee object. These method calls are processed polymorphically.
*/

public class Assignment01 {
	public static void main(String[] args) {
		Employees obj1 = new HourlyEmployee("Jashandeep", "Singh", "128954", 15, 44);
		Employees obj2 = new HourlyEmployee("Dimpi", "Patel", "789654", 17, 60);
		Employees obj3 = new SalariedEmployee("Manvir", "Singh", "123589", 400);
		Employees obj4 = new SalariedEmployee("Jagdeep", "Singh", "987271", 300);
		Employees obj5 = new CommissionEmployee("Rajish", "Kumar", "459632", 0.1, 100);
		Employees obj6 = new CommissionEmployee("Jarnail", "Sandhu", "785123", 0.08, 250);
		SalaryPlusCommissionEmployee obj7 = new SalaryPlusCommissionEmployee("Arsh","Singh","458961", 0.1, 110, 250);
		SalaryPlusCommissionEmployee obj8 = new SalaryPlusCommissionEmployee("Ravleen","Kaur","546982", 0.2, 200,100);
		Employees[] main = { obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8 };
		System.out.println("########### PayRoll App ###########");
		System.out.println("------------------------------------------------");
		for (int i = 0; i < main.length; i++) {
			Employees object1 = main[i];
			object1.Earnings();
			System.out.println("------------------------------------------------");
			System.out.println();
		}
	}
}
//Employees[] mainobj ={(new HourlyEmployee("Jashan", "Singh", "12345", 15, 44)),(new SalariedEmployee("Manvir", "Singh", "12358", 400)),(new CommissionEmployee("Dimpi", "Patel", "j123654", 0.05, 100)), (new SalaryPlusCommissionEmployee("Arsh", "Singh", "45896", 0.1, 100, 200))} ;
//
//for(int i = 0; i<mainobj.length; i++) {
//	Employees obj1 =  mainobj[i];
//	obj1.Earnings();
//}