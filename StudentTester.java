//************DO NOT MODIFY THIS FILE **********/

public class StudentTester {
	
	public static void testValidation()
	{
		String customerConfig = "DDDDDDDDDD";
		String[][] foodStallConfigA = {
				{"ShopA", "NDMSB"}
				,{"ShopB", "NDMSB"}
				,{"ShopC", "B"}
				,{"ShopD", "NDMSB"}
				,{"ShopE", "NDMSB"}
				,{"ShopF", "BMS"}
				};
		CanteenICT canteen = new CanteenICT("test1");
		canteen.setCustomers(customerConfig, null);
		canteen.setFoodStalls(foodStallConfigA);
		canteen.setTables(2);
		
		//check budget
		System.out.println("Canteen "+canteen.getName()+(canteen.validateCanteen()?" passes":" does not pass")+" the validation. Installation cost: "
		+canteen.getInstallCost()+" baht, while maximum budget is "+CanteenICT.MAX_BUDGET+" :(");
		
		//check food
		String[][] foodStallConfigB = {
				{"ShopA", "DMSB"}
				,{"ShopB", "NDMB"}
				,{"ShopC", "NS"}
				};
		canteen = new CanteenICT("test2");
		canteen.setCustomers(customerConfig, null);
		canteen.setFoodStalls(foodStallConfigB);
		canteen.setTables(2);
		System.out.println("Canteen "+canteen.getName()+(canteen.validateCanteen()?" passes":" does not pass")+" the validation."
		+" There must be at least one food stall that sell all the dishes requried by each customer.");
		
		//check tables 
		String[][] foodStallConfigC = {
				{"ShopA", "NDMSB"}
				,{"ShopB", "NDMSB"}
				};
		canteen = new CanteenICT("test3");
		canteen.setCustomers(customerConfig, null);
		canteen.setFoodStalls(foodStallConfigC);
		System.out.println("Canteen "+canteen.getName()+(canteen.validateCanteen()?" passes":" does not pass")+" the validation."
				+" Have you added some tables to your canteen where customers can sit and eat their food?");
		
	
		canteen = new CanteenICT("test4");
		canteen.setCustomers(customerConfig, null);
		canteen.setFoodStalls(foodStallConfigC);	
		canteen.setTables(2);
		System.out.println("Canteen "+canteen.getName()+(canteen.validateCanteen()?" passes":" does not pass")+" the validation."
				+" Allright! Good to go.");
		
	}
	
	public static void testOneWay()
	{
		String customerConfig = "DDDDDDDDDD";
		String[][] foodStallConfig = {
				{"Bamboo Shop", "NDMSB"}
				};
		CanteenICT canteen = new CanteenICT("oneway");
		System.out.println("@@@ Initializing "+canteen.setCustomers(customerConfig, null)+" customers.");
		System.out.println("@@@ Initializing "+canteen.setFoodStalls(foodStallConfig)+" food stalls.");
		System.out.println("@@@ Initializing "+canteen.setTables(1)+" tables, each of which has "+Table.MAX_SEATS+" seats.");	
		System.out.println("@@@ The installation cost is "+canteen.getInstallCost()+" baht. The maximum budget is "+CanteenICT.MAX_BUDGET+" baht.");
		
		System.out.println("@@@ Validating Canteen ICT .... "+canteen.validateCanteen());
	
		canteen.simulate();
	
	}
	
	public static void testDebug()
	{
		String customerConfig = "DDDDDDDD";
		String[][] foodStallConfig = {
				{"Bamboo Shop", "NDMSB"}
				,{"PigPan Deli", "NDMSB"}
				};
		
		CanteenICT canteen = new CanteenICT("debug");
		System.out.println("@@@ Initializing "+canteen.setCustomers(customerConfig, null)+" customers.");
		System.out.println("@@@ Initializing "+canteen.setFoodStalls(foodStallConfig)+" food stalls.");
		System.out.println("@@@ Initializing "+canteen.setTables(2)+" tables, each of which has "+Table.MAX_SEATS+" seats.");
		
		System.out.println("@@@ The installation cost is "+canteen.getInstallCost()+" baht. The maximum budget is "+CanteenICT.MAX_BUDGET+" baht.");
		
		System.out.println("@@@ Validating Canteen ICT .... "+canteen.validateCanteen());
	
		canteen.simulate();
	}	
	
	public static void testSimple()
	{
		String customerConfig = "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD";
		String[][] foodStallConfig = {
				{"Bamboo Shop", "NDMSB"}
				,{"PigPan Deli", "NDMSB"}
				,{"BlueMART Vending Machine", "NDMSB"}
				};
		
		CanteenICT canteen = new CanteenICT("simple");
		System.out.println("@@@ Initializing "+canteen.setCustomers(customerConfig, null)+" customers.");
		System.out.println("@@@ Initializing "+canteen.setFoodStalls(foodStallConfig)+" food stalls.");
		System.out.println("@@@ Initializing "+canteen.setTables(2)+" tables, each of which has "+Table.MAX_SEATS+" seats.");
		
		System.out.println("@@@ The installation cost is "+canteen.getInstallCost()+" baht. The maximum budget is "+CanteenICT.MAX_BUDGET+" baht.");
		
		System.out.println("@@@ Validating Canteen ICT .... "+canteen.validateCanteen());
	
		canteen.simulate();
	}	
	
	public static void testCongestion()
	{
		String customerConfig = 
				"DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
				+ "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
				+ "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD";
		String[][] foodStallConfig = {
				{"Bamboo Shop", "NDMSB"}
				,{"PigPan Deli", "NDMSB"}
				,{"MU Library Cafe", "NDMSB"}
				};
		
		CanteenICT canteen = new CanteenICT("congestion");
		System.out.println("@@@ Initializing "+canteen.setCustomers(customerConfig, null)+" customers.");
		System.out.println("@@@ Initializing "+canteen.setFoodStalls(foodStallConfig)+" food stalls.");
		System.out.println("@@@ Initializing "+canteen.setTables(1)+" tables, each of which has "+Table.MAX_SEATS+" seats.");
		
		System.out.println("@@@ The installation cost is "+canteen.getInstallCost()+" baht. The maximum budget is "+CanteenICT.MAX_BUDGET+" baht.");
		
		System.out.println("@@@ Validating Canteen ICT .... "+canteen.validateCanteen());
	
		canteen.simulate();
	}
	
	public static void testLarge()
	{
		String customerConfig = "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
				+ "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
				+ "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
				+"DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
				+ "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
				+ "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD";
		String[][] foodStallConfig = {
				{"Bamboo Shop", "NDMSB"}
				,{"PigPan Deli", "NDMSB"}
				,{"MU Library Cafe", "NDMSB"}
				,{"BlueMART Vending Machine", "NDMSB"}
				};
		
		CanteenICT canteen = new CanteenICT("large");
		System.out.println("@@@ Initializing "+canteen.setCustomers(customerConfig, null)+" customers.");
		System.out.println("@@@ Initializing "+canteen.setFoodStalls(foodStallConfig)+" food stalls.");
		System.out.println("@@@ Initializing "+canteen.setTables(10)+" tables, each of which has "+Table.MAX_SEATS+" seats.");
		
		System.out.println("@@@ The installation cost is "+canteen.getInstallCost()+" baht. The maximum budget is "+CanteenICT.MAX_BUDGET+" baht.");
		
		System.out.println("@@@ Validating Canteen ICT .... "+canteen.validateCanteen());
	
		canteen.simulate();
	}
	
	
	
	public static void testBonus()
	{	
		String customerConfig  = "ISSPPIIIAPIAPAIPIIIPIASIISIASSIAPAAPPIPIPP"
				+ "IISSSPSAPSAPIAAAIAPAIISAASSIASAAASPISSSAPASISSIAISPIISIS"
				+ "PPSIPAIISAPSAIISPISASIAPAAAIAIAIIPIPPSAPPASIPPIPIAPPAIPA"
				+ "SIPPPAPAPSAPIPPAIAPSIASSPSAASIAAISSSIAASSIASPA";
		String customerPayment = "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
				+ "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"
				+ "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"
				+ "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM";
		String[][] foodStallConfig = {
				{"Bamboo Shop", "NDMSB"}
				,{"N Only", "N"}
				,{"Dessert Only", "D"}
				,{"M&S&B Only", "MSB"}
				,{"N&D&B Only", "NDB"}
				,{"N&M&S&B Only", "NMSB"}
				,{"D&M&S&B Only", "DMSB"}
		};
	
		CanteenICT canteen = new CanteenICT("bonus");
		System.out.println("@@@ Initializing "+canteen.setCustomers(customerConfig, customerPayment)+" customers.");
		System.out.println("@@@ Initializing "+canteen.setFoodStalls(foodStallConfig)+" food stalls.");
		System.out.println("@@@ Initializing "+canteen.setTables(5)+" tables, each of which has "+Table.MAX_SEATS+" seats.");
	
		System.out.println("@@@ The installation cost is "+canteen.getInstallCost()+" baht. The maximum budget is "+CanteenICT.MAX_BUDGET+" baht.");
	
		System.out.println("@@@ Validating Canteen ICT .... "+canteen.validateCanteen());
	
		canteen.simulate();	

	}
	
	public static void main(String[] args)
	{
		
		//Uncomment each case, one by one, to test your code. Do not uncomment all at once.
		
		//testValidation();
		testOneWay();
//		testDebug();
		//testSimple();
//		testCongestion();	// This may take up to a minute
//		testLarge();		// This may take up to a minute
		
		
		//testBonus();	//For Bonus
	}

}
