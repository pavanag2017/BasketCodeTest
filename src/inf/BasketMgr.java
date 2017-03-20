package inf;

public interface BasketMgr {

	/**
	 * This method is used to check if the Fruit is a valid fruit or not.
	 * @param item
	 * @throws BigBasketNotAllowedFruitException
	 */
	void checkIfValidFruit(Item item);//throws BigBasketNotAllowedFruitException;

}
