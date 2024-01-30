// File: FoodStall
// Description: Every activity in food stall
// Project: 1
//
// ID: 6588187
// Name: Punyaporn Putthajaksri
// Section: 2
//
// On my honor, Punyaporn Putthajaksri, this project assignment is my own work
// and I have not provided this code to any other students.


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FoodStall {
	
	//**************************** DO NOT MODIFY **********************************//
	public static final int MAX_QUEUE = 5;			//Max number of customers waiting to order food 
	public static enum Menu{NOODLES, DESSERT, MEAT, SALAD, BEVERAGE};	//Different type of food type
	public static final int[] INSTALLATION_COST = {4000, 2500, 5000, 3500, 2000};	//Installation cost of each food type
	public static final int[] COOKING_TIME = {2, 1, 3, 2, 1};	//Time to cook each food type
	public static final int[] EAT_TIME = {6, 5, 10, 5, 2};	//Time for a customer to eat each food type
	
	
	private String foodStallName = null;	//The name of this food stall
	private List<Menu> availableMenu = new ArrayList<Menu>();	//List of all the available food types 
	private CanteenICT canteen = null;	//Reference to the CanteenICT object
	private List<Customer> customerQueue = new ArrayList<Customer>();	//List of the customers at this food stall
	
	protected int orderTime = -1;	//internal reference when someone orders food
	private int cookingTime = -1;	//internal reference to keep track of cooking time for the current order
	protected int takePaymentTime = -1;	//internal reference when someone makes payment
	private int processingTime = -1;	// internal reference to keep track of payment processing time for the current customer
	//********************************************************************************//
//	public List<Customer> cusQueue = new ArrayList<Customer>();
	
	/**
	 * Constructor. Initializing name, canteen reference, and menu
	 * @param name
	 * @param _canteen
	 * @param menu
	 */
	public FoodStall(String name, CanteenICT _canteen, List<Menu> menu)
	{
		//******************* YOUR CODE HERE **********************
		foodStallName = name;
		canteen = _canteen;
		for(int i=0;i<menu.size();i++) {
			availableMenu.add(menu.get(i));
		}
		//*****************************************************
		
	}	
		
	//************************************** DO NOT MODIFY ************************************************//
	public String getName()
	{
		return this.foodStallName;
	}
	
	public List<FoodStall.Menu> getMenu()
	{
		return this.availableMenu;
	}
	
	public List<Customer> getCustomerQueue()
	{
		return this.customerQueue;
	}
	
	/**
	 * Takes order and returns the amount of time required to cook the dishes. 
	 * 
	 * If cannot take order, return -1. E.g. Still cooking, waiting for pick-up, or does not have one of the required dishes
	 * @param dishes
	 * @return
	 */
	public int takeOrder(List<Menu> dishes)	//cook in batch
	{
		if(this.isCooking()) return -1;	//if cooking then return no
		if(this.isReadyToServe()) return -1; //food not picked up yet, return false.
		if(!this.availableMenu.containsAll(new HashSet<Menu>(dishes))) return -1;	//if cannot cook one of the dishes, return false
		this.orderTime = canteen.getCurrentTime();
		this.cookingTime = 0;	//calculate cooking time
		for(Menu dish: dishes)
		{
			this.cookingTime += FoodStall.COOKING_TIME[dish.ordinal()];
		}
		return this.cookingTime;
	}
	
	/**
	 * Return true if the food stall is available to take order
	 * @return
	 */
	public boolean isWaitingForOrder()
	{
		return this.orderTime < 0;
	}
	
	/**
	 * Return true if currently cooking something.
	 * @return
	 */
	public boolean isCooking()
	{
		return (canteen.getCurrentTime() - this.orderTime) <= this.cookingTime;
	}
	
	/**
	 * Return true of the food is ready to be served 
	 * @return
	 */
	public boolean isReadyToServe()
	{
		return !this.isCooking() && this.orderTime > 0;
	}
	
	
	/**
	 * If called, reset the internal clocks so that the food stall is available to take order again.
	 * @return
	 */
	public boolean serve()
	{
		if(!this.isReadyToServe()) return false;
		if(!this.isPaid()) return false;
		this.orderTime = -1;
		this.cookingTime = -1;
		this.takePaymentTime = -1;
		this.processingTime = -1;
		return true;
	}
	
	 /** Takes payment and set the payment time to the current time.
	 * 
	 * If cannot take a payment, return false. E.g. Still cooking, 
	 */
	public boolean takePayment(Customer.Payment payment) 
	{
		if(isReadyToServe()) {
			this.takePaymentTime = canteen.getCurrentTime();
			this.processingTime = Customer.PAYMENT_TIME[payment.ordinal()]; 
			return true;
		}
		return false;
	}
	
	/**
	 * Return true, if the food is already paid by the first customer in line or not
	 * @return
	 */
	public boolean isPaid() 
	{
		return (this.isReadyToServe() && ((canteen.getCurrentTime() - this.takePaymentTime) > this.processingTime));
	}
	
	//**********************************************************************************************************//
	
}
