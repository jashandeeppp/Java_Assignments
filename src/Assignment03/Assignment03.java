package Assignment03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/*
	A store maintains a record of all its online sales. Each sale records both the customer and the product details as follows:
	CustomerID FirstName LastName ProductID ProductName SingleItemPrice ItemsPurchased
	At the end of each week based on this record the store prepares a bill for each customer and updates its products inventory.
	Write a program that works with two maps – one of customers based on CustomerID and the other of products based on ProductID. 
	The program will read all the records from the file “Sales.txt”. Each line will result in two operations: 
	-	Insert a new entry or update an existing entry in products map: update the count of the purchases of this product       
	-	Insert a new entry or update an existing entry in customers map: 
	update the total amount to be paid by this customer based on the price of this product multiplied by the number of items purchased.
	For example, reading the following line: 
	1005 Abigail Adams 5020 blouse 45 2
	should update the entry with key 5020 in products map increasing the count of purchases by 2 and 
	should update the entry with key 1005 in customers map increasing the total bill for the customer by 90 dollars.
	After reading through all the records the program should produce two printouts: 
	one of all the customers with their final bills and another of all the products with their total count of purchased items. 
	Every customer and every product must be mentioned in the printout only once.
	The main method should be as short as possible.
 */

public class Assignment03 {
	public static void processor(String content) {
		Map<Integer, Integer> products = new LinkedHashMap<>();
		Map<Integer, Integer> customers = new LinkedHashMap<>();
		String [] customer = content.split(","); // splits the string with comma

		int [] productsId = new int[customer.length];
		int [] productsQuantity = new int[customer.length];
		int [] customerId = new int[customer.length];
		int [] productPrice = new int[customer.length];
		for (int i = 0;i<customer.length;i++) {
			String [] details = customer[i].split(" ");
			for(int j = 0; j<details.length; j++) {
				customerId[i] = Integer.parseInt(details[0]);
				productsId[i] = Integer.parseInt(details[3]);
				productPrice[i] = Integer.parseInt(details[5]);
				productsQuantity[i] = Integer.parseInt(details[6]);
			}
		}

		for(int i = 0;i<productsId.length; i++) {
			if (products.containsKey(productsId[i])) {
			    products.put(productsId[i],(products.get(productsId[i])+productsQuantity[i]));
			} else { 
				products.put(productsId[i],productsQuantity[i]);
			}
			if(customers.containsKey(customerId[i])) {
				customers.put(customerId[i],(customers.get(customerId[i])+(productPrice[i] * productsQuantity[i])));
			}else {
				customers.put(customerId[i], (productPrice[i] * productsQuantity[i]));
			}
		}
		print(products,customers);
	}

	public static void print(Map<Integer, Integer> products, Map<Integer, Integer> customers ) {
		System.out.println("######## General Store ########");
		System.out.println("---------------------------------");
		System.out.println("***** Products List *****");
		System.out.println("Product's Id\tQuantity");
		for (Map.Entry<Integer, Integer> me :products.entrySet()) {
			System.out.print(me.getKey() + "\t\t");
			System.out.println(me.getValue());
			}
		System.out.println();
		System.out.println("***** Customer's Bill List *****");
		System.out.println("Customer's Id\tTotal Bill");
		for (Map.Entry<Integer, Integer> me :customers.entrySet()) {
		    System.out.print(me.getKey() + "\t\t");
		    System.out.println(me.getValue()); 
		}
	}

	public static void reader() throws IOException{
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("Sales.txt"));
			String str, content = "";
			while ((str = fileReader.readLine()) != null) {
				content = content + str +",";
			}
			processor(content);
		}
		catch (Exception ex){
			System.out.println("Unable to read the file.");
		}
		finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		reader();
	}

}

