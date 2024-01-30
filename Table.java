// File: Table
// Description: every activity at the table
// Project: 1
//
// ID: 6588187
// Name: Punyaporn Putthajaksri
// Section: 2
//
// On my honor, Punyaporn Putthajaksri, this project assignment is my own work
// and I have not provided this code to any other students.


import java.util.ArrayList;
import java.util.List;

public class Table {
	//********************** DO NOT MODIFY *****************************//
	public static final int MAX_SEATS = 4;	//Max number of customers for one table
	private static int countTables = 0;	//A static variable to assign a unique table ID
	
	private int tableID = -1;	//table ID
	private List<Customer> seatedCustomers = new ArrayList<Customer>();	//List of seated customers
	//*****************************************************************//
//	public List<Customer> seatedCus = new ArrayList<Customer>();
	
	
	//************************************ DO NOT MODIFY ****************************************//
	/**
	 * Constructor
	 */
	public Table()
	{
		countTables++;
		tableID = countTables;
	}
	
	public int getID()
	{
		return this.tableID;
	}
	
	public List<Customer> getSeatedCustomers()
	{
		return this.seatedCustomers;
	}
	
	/**
	 * Returns true if the table is currently fully occupied 
	 * @return
	 */
	public boolean isFull()
	{	
		if(seatedCustomers == null) 
			return true;
	
		return this.seatedCustomers.size() >= MAX_SEATS;
	}
	//*******************************************************************************************//
	
	
	//******************************************** YOUR ADDITIONAL CODE HERE (IF ANY) *******************************//

	//****************************************************************************************************//
			

}
