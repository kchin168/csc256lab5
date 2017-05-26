import myutil.*;

public class Customer{
	private MyStack<String> shoppingBasket;
	private String name;

	public Customer(String namn)
	{
		shoppingBasket = new MyStack<String>();
		this.name = namn;
	}
	
	public void shop(Supermarket supermarket){
		if (Math.random() < 0.25){
			String item = supermarket.pickArandomItem();

			shoppingBasket.push(item);
			System.out.println(name + " add 1 " + item +  " in the shopping cart.");
		}
	}

	public static boolean wantsToCheckout(){
		return Math.random() < 0.25;
	}
	
	public String pickUpNextItem(){
		return shoppingBasket.pop();
	}

	public boolean hasItems(){
		return !shoppingBasket.empty();
	}

	public String getCustomerName(){
		return name;
	}
}
