package JavaEcommerce.MyEcommerce.dao;

import java.util.List;

import JavaEcommerce.MyEcommerce.dto.Cart;
import JavaEcommerce.MyEcommerce.dto.CartLine;

public interface CartLineDAO {
	
	/**
	 * Update Cart
	 * @param cart
	 * @return boolean
	 */
	boolean updateCart(Cart cart);

	/**
	 * Get all CartLine by the id
	 * @return list
	 */
	public List<CartLine> list(int cartId);
	
	/**
	 * Get a single cart line based on id
	 * @param cartId
	 * @return int
	 */
	public CartLine get(int cartId); 
	
	/**
	 * Add a new cartline
	 * @param cartLine
	 * @return boolean
	 */
	public boolean add(CartLine cartLine); 
	
	/**
	 * Update cartLine based on the id supplied
	 * @param cartLine
	 * @return boolean
	 */
	public boolean update(CartLine cartLine); 
	
	/**
	 * Delete cartline based on id supplied
	 * @param cartLine
	 * @return boolean
	 */
	public boolean delete(CartLine cartLine); 
	
	
	/************************ Business methods **********************/
	
	/**
	 * Get all available cartline
	 * @param cartId (int)
	 * @return list
	 */
	public List<CartLine> listAvailable(int cartId);
	
	/**
	 * Get cartline by their cartId and productId
	 * @param cartId (int), productId (int)
	 * @return cartLine
	 */
	public CartLine getByCartAndProduct(int cartId, int productId);
	
}