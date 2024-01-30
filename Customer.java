// File: Customer
// Description: the activity of the customers in canteen
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

public class Customer {
	
	//*********************** DO NOT MODIFY ****************************//
	public static enum CustomerType{DEFAULT, STUDENT, PROFESSOR, ATHLETE, ICTSTUDENT};	//Different types of customers 
	private static int customerRunningNumber = 1;	//static variable for assigning a unique ID to a customer
	private CanteenICT canteen = null;	//reference to the CanteenICT object
	private int customerID = -1;		//this customer's ID
	protected CustomerType customerType = CustomerType.DEFAULT;	//the type of this customer, initialized with a DEFAULT customer.
	protected List<FoodStall.Menu> requiredDishes = new ArrayList<FoodStall.Menu> ();	//List of required dishes
	
	public static enum Payment{DEFAULT, CASH, MOBILE};
	public static final int[] PAYMENT_TIME = {3, 2, 1};
	protected Payment payment = Payment.DEFAULT;
	
	protected int state = 0; // 0 wait-to-enter, 1 wait-to-order, 2 ordering, 
							 // 3 making payment, 4 wait-to-seat, 5 siting, 
							 // 6 eating, 7 done
	//*****************************************************************//
	
	
	/**
	 * Constructor. Initialize canteen reference, default customer type, and default payment method. 
	 * 				Initialize other values as needed
	 * @param _canteen
	 */
	public Customer(CanteenICT _canteen)
	{
		//******************* YOUR CODE HERE **********************
		canteen = _canteen;
		this.customerID = customerRunningNumber++;
		for(FoodStall.Menu e : FoodStall.Menu.values()) { //get eating time
        	this.eattime += FoodStall.EAT_TIME[e.ordinal()];
        }
		requiredDishes.add(FoodStall.Menu.NOODLES);
		requiredDishes.add(FoodStall.Menu.DESSERT);
		requiredDishes.add(FoodStall.Menu.MEAT);
		requiredDishes.add(FoodStall.Menu.SALAD);
		requiredDishes.add(FoodStall.Menu.BEVERAGE);
		tb = null;
		myfs = null;
		//*****************************************************
	}
	
	/**
	 * Constructor. Initialize canteen reference, default customer type, and specific payment method.
	 * 				Initialize other values as needed 
	 * @param _canteen
	 * @param payment
	 */
			
	public Customer(CanteenICT _canteen, Payment payment)	
	{
		//******************* YOUR CODE HERE **********************
		canteen = _canteen;
		this.payment = payment;
		this.customerType = CustomerType.DEFAULT;
		this.customerID = customerRunningNumber++;
		for(FoodStall.Menu e : FoodStall.Menu.values()) { //get eating time
        	this.eattime += FoodStall.EAT_TIME[e.ordinal()];
        }
		requiredDishes.add(FoodStall.Menu.NOODLES);
		requiredDishes.add(FoodStall.Menu.DESSERT);
		requiredDishes.add(FoodStall.Menu.MEAT);
		requiredDishes.add(FoodStall.Menu.SALAD);
		requiredDishes.add(FoodStall.Menu.BEVERAGE);
		tb = null;
		myfs = null;
		
		//*****************************************************
	}
	
	
	
	/**
	 * Depends on the current state of the customer, different action will be taken
	 * @return true if the customer has to move to the next queue, otherwise return false
	 */
	public boolean takeAction()
	{
		//************************** YOUR CODE HERE **********************//
		if(this.state==0){
			state++;
		}
		if(this.state==1) {
			canteen.getwaitToEnterQueue().add(this);
			//find shortest queue
			if(canteen.getwaitToEnterQueue().get(0).customerID==this.getCustomerID() ) {
				for(FoodStall n : canteen.getfsList()) {
					if(n.equals(canteen.findshortestfsqueue()) && n.getCustomerQueue().size()<FoodStall.MAX_QUEUE && n.getMenu().containsAll(requiredDishes)) {
						myfs=n;
					}
				}
				if(myfs!=null) {
					myfs.getCustomerQueue().add(this);
					canteen.getwaitToEnterQueue().remove(this);
					jot("@D"+this.customerID+"-"+this.state+" queues up at "+myfs.getName()+"  and waiting to order.");
					state++;
					
					return true;
				}
			}return false;
		}
//		else if(state==2) {
//			for(int i=0;i<canteen.getfsList().size();i++) {
//				if(myfs.getCustomerQueue().get(0).equals(this)) {
//					if(myfs.isWaitingForOrder()) {
//						myfs.takeOrder(this.requiredDishes);
//						jot("@D"+this.customerID+"-"+this.state+" orders from "+myfs.getName()+", and will need to wait for 9 periods to cook.");
//						state++;
//					}
//				}
//			}
//		}
		
		return false; 
		
		//**************************************************************//
		
	}
	
	
	//******************************************** YOUR ADDITIONAL CODE HERE (IF ANY) *******************************//
	FoodStall myfs = null;
	Table tb = null;
	int eattime = 0;
	int k=0,x=0,y=0;
	
	public void eating() {
		eattime--;
	}
	//****************************************************************************************************//
				
	

	//***************For hashing, equality checking, and general purposes. DO NOT MODIFY **************************//	
	
	public CustomerType getCustomerType()
	{
		return this.customerType;
	}
	
	public int getCustomerID()
	{
		return this.customerID;
	}
	
	public Payment getPayment()
	{
		return this.payment;
	}
	
	public List<FoodStall.Menu> getRequiredFood()
	{
		return this.requiredDishes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerType=" + customerType +", payment="+payment.name()+"]";
	}

	public String getCode()
	{
		return this.customerType.toString().charAt(0)+""+this.customerID;
	}
	
	/**
	 * print something out if VERBOSE is true 
	 * @param str
	 */
	public void jot(String str)
	{
		if(CanteenICT.VERBOSE) System.out.println(str);
		
		if(CanteenICT.WRITELOG) CanteenICT.append(str, canteen.name+"_state.log");
	}


	//*************************************************************************************************//
	
}
