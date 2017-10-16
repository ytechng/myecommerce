package JavaEcommerce.MyEcommerce.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import JavaEcommerce.MyEcommerce.dao.CategoryDAO;
import JavaEcommerce.MyEcommerce.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("JavaEcommerce.MyEcommerce");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
/*	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Mobiles");
		category.setDescription("This is a description for mobile phones");
		category.setImageUrl("mobils.png");
		
		assertEquals("Test Category successfully added to the table", true, 
				categoryDAO.add(category));
	}*/
	
/*	@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(2);
		
		assertEquals("Successfully feteched a single record from category table", "Laptops", 
				category.getName());
	}*/
	
/*	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(2);
		
		category.setName("Computers");
		
		assertEquals("Updated a single record on category table", true, 
				categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(2);
		
		assertEquals("Deleted a single record from category table", true,
				categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory() {
		
		assertEquals("Successfully fetched records from category table", 1,
				categoryDAO.list().size());
	}*/
	
	@Test
	public void testCategoryCRUD() {
		// Adding the first test category
		category = new Category();

		category.setName("Mobiles");
		category.setDescription("This is a description for mobile phones");
		category.setImageUrl("mobils.png");
				
		assertEquals("Test Category successfully added to the table", true, categoryDAO.add(category));
				
		// Adding the second test category
		category = new Category();

		category.setName("Laptops");
		category.setDescription("This is a description for Laptops");
		category.setImageUrl("mobils.png");

		assertEquals("Test Category successfully added to the table", true, categoryDAO.add(category));
		
		// Fetch single category
		category = categoryDAO.get(2);
		
		assertEquals("Successfully feteched a single record from category table", "Laptops", 
				category.getName());
		
		// Update a category
		category = categoryDAO.get(2);
		
		category.setName("Televisions");
		
		assertEquals("Updated a single record on category table", true, 
				categoryDAO.update(category));
		
		// Delete a category
		category = categoryDAO.get(1);
		
		assertEquals("Deleted a single record from category table", true,
				categoryDAO.delete(category));
		
		// Fetch all category
		assertEquals("Successfully fetched records from category table", 1,
				categoryDAO.list().size());
		
	}

}