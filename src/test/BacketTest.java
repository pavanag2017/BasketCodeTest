package test;

import impl.BasketItems;
import impl.BasketManager;
import inf.Item;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import org.junit.Test;

import enumTypes.ItemEnum;
import exceptions.BasketException;


public class BacketTest {
	
	BasketManager basket = null;
	
	
	@Before
	public void setUp() throws Exception {
		basket = new BasketManager();

	}
	
	// Positive Condition - Test correct basket total
	@Test
	public final void testBasketTotalValue() {
		Map<String, Item> basketList = createBasket();
		basket = new BasketManager(basketList);
		BigDecimal d = basket.getBasketPrice();
		assertTrue(new BigDecimal(5370).equals(d));
	}
	
	// Negative Condition - Test incorrect basket total
	@Test
	public final void testBasketTotalIncorrectValue() {
		Map<String, Item> basketList = createBasket();
		basket = new BasketManager(basketList);
		BigDecimal d = basket.getBasketPrice();
		assertFalse(new BigDecimal(1070).equals(d));
	}

	// Positive Condition - Test correct basket Quantity total
	@Test
	public final void testBasketQuantityValue() {
		Map<String, Item> basketList = createBasket();
		basket = new BasketManager(basketList);
		int qty = basket.getTotalQuantity();
		assertTrue("Quantity is correct ",qty == 5);
	}		
	
	// Negative Condition - Test incorrect basket Quantity total
	@Test
	public final void testBasketQuantityIncorrectValue() {
		Map<String, Item> basketList = createBasket();
		basket = new BasketManager(basketList);
		int qty = basket.getTotalQuantity();
		assertFalse ("Quantity is in correct ",qty == 7);
	}

	private Map<String, Item> createBasket(){

		Map<String, Item> basket = new HashMap<String, Item>();
		BasketItems apple = new BasketItems(1,new BigDecimal(1000),String.valueOf(ItemEnum.Apple));
		BasketItems orange = new BasketItems(1,new BigDecimal(1020),String.valueOf(ItemEnum.Orange));
		BasketItems graps = new BasketItems(1,new BigDecimal(1050),String.valueOf(ItemEnum.Grapes));
		BasketItems banana = new BasketItems(1,new BigDecimal(1100),String.valueOf(ItemEnum.Banana));
		BasketItems peach = new BasketItems(1,new BigDecimal(1200),String.valueOf(ItemEnum.Peach));
		
		basket.put(String.valueOf(ItemEnum.Orange), orange);
		basket.put(String.valueOf(ItemEnum.Apple), apple);
		basket.put(String.valueOf(ItemEnum.Grapes), graps);
		basket.put(String.valueOf(ItemEnum.Banana), banana);
		basket.put(String.valueOf(ItemEnum.Peach), peach);
		
		return basket;
	}

	// Negative Condition - Test addition of null Item 
	@Test(expected=BasketException.class) 
	public final void testBasketItemNull() throws BasketException {
			basket.addItem(null);
	}

	// Negative Condition - Test addition of invalid Item type
	@Test(expected=BasketException.class) 
	public final void testBasketInvalidItemNew() throws BasketException {
		System.out.println("testBasketInvalidItemNew - Start");
		BasketItems testItem = new BasketItems(1,new BigDecimal(1100),"Invalid");	
		basket.addItem(testItem);
	}
}
