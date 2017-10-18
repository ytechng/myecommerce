package JavaEcommerce.MyEcommerce.dao;

import java.util.List;

import JavaEcommerce.MyEcommerce.dto.Category;

public interface CategoryDAO {
	
	/**
	 * Get all category
	 */
	List<Category> list();
	
	/**
	 * Get a single category based on id
	 */
	Category get(int id); 
	
	/**
	 * Add a new category to the database table
	 */
	boolean add(Category category); 
	
	/**
	 * Update category based on id
	 */
	boolean update(Category category); 
	
	/**
	 * Delete category based on id
	 */
	boolean delete(Category category); 

}