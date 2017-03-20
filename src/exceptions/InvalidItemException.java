package exceptions;

@SuppressWarnings("serial")
public class InvalidItemException extends BasketException {

	public InvalidItemException(String msg){
		super(msg);
	}
}
