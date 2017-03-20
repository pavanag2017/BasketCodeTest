package inf;

import java.math.BigDecimal;
import java.util.Map;

public interface Basket {

	Map<String, Item> addItem(Item item , Map<String, Item> myBasketTemp);
	
	BigDecimal calculateTotal( Map<String, Item> myBasket);
	
	void checkValidItemQuantity(Item item); // throws BigBasketInvalidQuantityException;
	 
	public int size();

}
