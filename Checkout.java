import myutil.*;

public class Checkout{
	
	private MyQueue<Customer> queue;
	private Customer currentCustomer;
	private int checkoutNumber;

	public Checkout(int i){
		queue = new MyQueue<Customer>();
		currentCustomer = null;
		checkoutNumber = i;
	}

	public void addCustomer(Customer customer){
		queue.enqueue(customer);
	}
	
	public void attendCustomer() {
		if (currentCustomer == null){
			if (!queue.empty()) {
				currentCustomer = queue.dequeue();

				System.out.println("Now serving " +
						currentCustomer.getCustomerName() +
						" at checkout " + checkoutNumber);
			}
		}
		else {
			if (currentCustomer.hasItems()){
				String item = currentCustomer.pickUpNextItem();
				System.out.println(currentCustomer.getCustomerName() +
						" paying " + item +
						" at checkout " + checkoutNumber);
			}
			else{
				System.out.println(currentCustomer.getCustomerName() +
						" finishes and leaves.");

				currentCustomer = null;
			}
		}
	}

	public void printCustomerInfo(){
		System.out.print("At checkout" +
				checkoutNumber +
				" has " +
				queue.size() +
				" people left " +
				"shopping.");
		if (currentCustomer != null){
			System.out.println(currentCustomer.getCustomerName());
		}
		else if (!queue.empty()){
			System.out.println(queue.dequeue().getCustomerName());
		}
		else{ 
			System.out.println("None");
		}
	}
	
	public int getCheckoutNumber()
	{
		return checkoutNumber;
	}

}
