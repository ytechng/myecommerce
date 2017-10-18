package JavaEcommerce.MyEcommerce.dao;

import java.util.List;

import JavaEcommerce.MyEcommerce.dto.Product;

public interface ProductDAO {

	/**
	 * Get all products
	 * @return
	 */
	List<Product> list();
	
	/**
	 * Get a single product based on id
	 * @param productId
	 * @return int
	 */
	Product get(int productId); 
	
	/**
	 * Add a new product
	 * @param product
	 * @return object
	 */
	boolean add(Product product); 
	
	/**
	 * Update product based on the product id supplied
	 * @param product
	 * @return boolean
	 */
	boolean update(Product product); 
	
	/**
	 * Delete product based on id supplied
	 * @param productId
	 * @return boolean
	 */
	boolean delete(Product productId); 
	
	
	/************************ Business methods **********************/
	
	/**
	 * Get all active products
	 * @return
	 */
	List<Product> listActiveProducts();
	
	/**
	 * Get products by their categories
	 * @param categoryId
	 * @return List
	 */
	List<Product> listActiveProductsByCategory(int categoryId);
	
	/**
	 * Get latest active product 
	 * @param count
	 * @return List
	 */
	List<Product> getLastestActiveProducts(int count);
	
}
