package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	
	public void checkout(String status) { //this is a joinpoint
		System.out.println("checkout method from shoppingCart called with status: "+status);
	}

	public int quantity() {
		return 2;
	}
}
