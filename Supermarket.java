import java.util.*;
import myutil.*;

public class Supermarket{
    private MyList<Checkout> checkoutCounters;
    private MyList<Customer> customers;
    private MyList<String> items;
    private MyList<String> givenName;
    private MyList<String> surName;
    
    public static void main(String[] args){
        // Create the supermarket
        Supermarket supermarket = new Supermarket();
        
        // Present the items available in the supermarket
        supermarket.presentItems();
        waitMS(1000);
        
        // Run the simulation for 100 steps
        for (int i = 0; i < 100; i++)
        {
            supermarket.simulateOneStep();
            waitMS(300);
        }

        supermarket.showTerminalStatus();
    }
    
    public Supermarket(){
        // Create list with checkout counters
        checkoutCounters = new MyList<Checkout>();
        for (int i = 1; i <= 5; i++){
            checkoutCounters.add(new Checkout(i));
        }
        
        // Create list for the customers
        customers = new MyList<Customer>();
        
        // Create list with items
        items = new MyList<String>();
        items.add("food");
        items.add("clothes");
        items.add("utensils");

        // Create list with customer names
        givenName = new MyList<String>();
        givenName.add("Bob");
        givenName.add("Nick");
        givenName.add("Paul");
        
        // Create a list with customer surnames
        surName = new MyList<String>();
        surName.add("Chan");
        surName.add("Lee");
        surName.add("Wu");
    }
	
    public void presentItems()
    {
        System.out.println("Items available:");
        for(String item : items){
            System.out.println(item);
        }
    }
    
    public static void waitMS(int milliseconds) {
        try{
            Thread.sleep(milliseconds);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void simulateOneStep(){
        System.out.println();
        theCustomersAreArriving();
        customersAreShopping();
        customersWalkToCheckout();
        customersPaysAndLeaves();
    }
    
    public String pickArandomItem(){
        return items.getRandomElement();
    }
    
    private void theCustomersAreArriving(){
       
        if (Math.random() < 0.7){
            String name = givenName.getRandomElement() +
	                      ' ' +
	                      surName.getRandomElement();      
            customers.add(new Customer(name));
            System.out.println("The customer " +
                               name +
                               " enters.");
        }
    }
    
    private void customersAreShopping(){
    	for(Customer customer : customers){
    		customer.shop(this);
    	}
    }
    
    private void customersWalkToCheckout(){
    	// Notice the difference between this iteration structure and
    	// customersAreShopping. Why is this one different?
        Iterator<Customer> i = customers.iterator();
        while (i.hasNext()){
        	
            Customer customer = i.next();
            if (Customer.wantsToCheckout() && customer.hasItems()){
                customerWalksToCheckout(customer);
                
                i.remove();
            }
        }
    }
    
    private void customerWalksToCheckout(Customer customer)
    {
        // Choose a checkout counter at random and
        // place the customer in that queue
        Checkout checkout = checkoutCounters.getRandomElement();
        checkout.addCustomer(customer);

        System.out.println(customer.getCustomerName() +
			               " is in the checkout " +
			               checkout.getCheckoutNumber());
    }
    
    private void customersPaysAndLeaves(){
    	for(Checkout checkout : checkoutCounters){
            checkout.attendCustomer();
        }
    }

    public void showTerminalStatus(){
      System.out.println();
      System.out.println("At the end of line, there are " +
                         customers.size() +
			             " remaining customers.");
      
      System.out.println("At the cashiers:");
      for (Checkout k : checkoutCounters){
    	  k.printCustomerInfo();
      }
    }
    
}
