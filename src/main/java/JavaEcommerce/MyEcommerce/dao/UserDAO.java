package JavaEcommerce.MyEcommerce.dao;

import java.util.List;

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
	 * @return boolean
	 */
	boolean addAddress(Address address);
	
	/**
	 * Update Cart
	 * @param cart
	 * @return boolean
	 */
	boolean updateCart(Cart cart);
	
	/**
	 * Get User By Email
	 * @param email
	 * @return user
	 */
	User getUserByEmail(String email);
	
	/**
	 * Get User Billing Address
	 * @param user
	 * @return address
	 */
	Address getBillingAddress(int user);
	
	/**
	 * List User Shipping Addresses
	 * @param user
	 * @return list
	 */
	List<Address> listShippingAddresses(int user);
}
