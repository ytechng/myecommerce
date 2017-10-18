package JavaEcommerce.MyEcommerce.dao;

import JavaEcommerce.MyEcommerce.dto.Address;
import JavaEcommerce.MyEcommerce.dto.Cart;
import JavaEcommerce.MyEcommerce.dto.User;

public interface UserDAO {

	/**
	 * Add new User 
	 * @param user
	 * @return boolean
	 */
	boolean addUser(User user);
	
	/**
	 * Add new Address
	 * @param address
	 * @return
	 */
	boolean addAddress(Address address);
	
	/**
	 * Add new Cart
	 * @param cart
	 * @return
	 */
	boolean addCart(Cart cart);
}
