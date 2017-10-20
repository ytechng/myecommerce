package JavaEcommerce.MyEcommerce.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import JavaEcommerce.MyEcommerce.dao.ProductDAO;
import JavaEcommerce.MyEcommerce.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("JavaEcommerce.MyEcommerce");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	/*@Test
	public void testProductCRUD() {
		
		// add new product test
		product = new Product();
		
		product.setName("Galaxy S5");
		product.setBrand("Nokia");
		product.setDescription("This is a new Samsung running on android os");
		product.setUnitPrice(27000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setMerchantId(2);
		
		assertEquals("Something went wrong while adding new product!", 
				true, productDAO.add(product));
		
		// select and update product test
		product = productDAO.get(1);
		product.setName("Xperia Z5 Premium");

		assertEquals("Something went wrong while updating the product!", 
				true, productDAO.update(product));
		
		// delete a product test
		assertEquals("Something went wrong while deleting the product!", 
				true, productDAO.delete(product));
		
		// product lists test
		assertEquals("Something went wrong while fetching the list of products!", 
				8, productDAO.list().size());
	}*/
	
	/*@Test
	public void testListActiveProduct() {
		
		assertEquals("Something went wrong while fetching active list of products!", 
				7, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductByCategory() {
		
		assertEquals("Something went wrong while fetching active category list of products!", 
				1, productDAO.listActiveProductsByCategory(1).size());
		
		assertEquals("Something went wrong while fetching active category list of products!", 
				3, productDAO.listActiveProductsByCategory(2).size());
		
		assertEquals("Something went wrong while fetching active category list of products!", 
				3, productDAO.listActiveProductsByCategory(3).size());
	}
	
	@Test
	public void testGetLatestActiveProduct() {
		
		assertEquals("Something went wrong while getting latest active products!", 
				5, productDAO.getLastestActiveProducts(5).size());
	}
*/
}
