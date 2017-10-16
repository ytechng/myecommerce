package JavaEcommerce.MyEcommerce.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

	/**
	 * serialVersion Id
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ProductNotFoundException() {
		this("Product is not available");
	}

	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
