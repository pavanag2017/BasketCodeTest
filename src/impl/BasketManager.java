package impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import enumTypes.ItemEnum;
import exceptions.BasketException;
import exceptions.BasketInvalidException;
import exceptions.InvalidItemException;

import impl.BasketItems;
import inf.Item;

/**
 * Basket Manager to calculate the total and size of basket with unique items
 * @author 238329
 *
 */
public class BasketManager {

	private Map<String, Item> basket = new HashMap<String, Item>();

	// For testing purpose, populating basket with default 
	// items. In actual project, there will be no populate method
	public BasketManager(){
		
		populate();	
	}
	
	public BasketManager(Map<String, Item> bsk){
		basket = bsk;
	}

	private void populate(){
		
		BasketItems apple = new BasketItems(1,new BigDecimal(1001),String.valueOf(ItemEnum.Apple));
		BasketItems orange = new BasketItems(21,new BigDecimal(1002),String.valueOf(ItemEnum.Orange));
		BasketItems graps = new BasketItems(5,new BigDecimal(1003),String.valueOf(ItemEnum.Grapes));
		BasketItems banana = new BasketItems(2,new BigDecimal(1004),String.valueOf(ItemEnum.Banana));
		BasketItems peach = new BasketItems(87,new BigDecimal(1005),String.valueOf(ItemEnum.Peach));
		
		try{
			addItem(apple);
			addItem(orange);
			addItem(graps);
			addItem(banana);
			addItem(peach);
		}catch(Exception eX){
			System.out.println("Exception !!!!!!!!!! " + eX.getMessage());
		}
	}
	
	
	public void addItem(Item item) throws BasketException{
		
		if(basket == null ){
			throw new BasketInvalidException("Basket in Invalid");
		}
		
		if(item == null || 
				item.getName() == null || 
				"".equalsIgnoreCase(item.getName().trim()) ) 
			throw new InvalidItemException("The item you are trying to add is invalid or null ");
		
		if(!isValidEnumEntry(item.getName())){
			throw new InvalidItemException("Item (" + item.getName() + ") not allowed in basket!");
		}
		
		if(this.basket.containsKey(item.getName())){
			int quantity = item.getQuantity();
			
			// Rare situation that key is present but item is null
			if(basket.get(item.getName()) != null){
				quantity =+basket.get(item.getName()).getQuantity();
			}
			// Else condition is NOT exception as item will be added to the basket
			
			item.setQuantity(quantity);
		}
		basket.put(item.getName(), item);
	}
	
	private boolean isValidEnumEntry(String itemName){
		
		try{
			ItemEnum.valueOf(itemName);
		}catch(IllegalArgumentException eX){
			return false;
		}
		return true;
	}
	
	/*
	 * The method allows to calculates the total price of Basket
	 */
	public BigDecimal getBasketPrice(){
		BigDecimal total=new BigDecimal(0.0);

		if(basket == null || basket.isEmpty()){
			return total;
		}
		
		for( String itemName : basket.keySet()){
			if(itemName == null)continue;

			Item item = basket.get(itemName);
			total = total.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
		}

		return total;
	}
	
	
	/*
	 * The method allows to calculates the total price of Basket
	 */
	public int getTotalQuantity(){
		int totalQuantity=0;

		if(basket == null || basket.isEmpty()){
			return totalQuantity;
		}
		
		for( String itemName : basket.keySet()){
			if(itemName == null)continue;

			Item item = basket.get(itemName);
			totalQuantity += item.getQuantity();
		}

		return totalQuantity;
	}
}
