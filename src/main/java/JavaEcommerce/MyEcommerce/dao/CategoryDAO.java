package JavaEcommerce.MyEcommerce.dao;

import java.util.List;

import JavaEcommerce.MyEcommerce.dto.Category;

public interface CategoryDAO {
	
	List<Category> list(); // get all categories
	
	Category get(int id); // get a single category
	
	boolean add(Category category); // add new category
	
	boolean update(Category category); // update category
	
	boolean delete(Category category); // delete category

}