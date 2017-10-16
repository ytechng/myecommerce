package JavaEcommerce.MyEcommerce.dao;

import java.util.List;

import JavaEcommerce.MyEcommerce.dto.Product;

public interface ProductDAO {

	List<Product> list(); // get all products
	
	Product get(int productId); // get a single product
	
	boolean add(Product product); // add new product
	
	boolean update(Product product); // update product
	
	boolean delete(Product productId); // delete product
	
	// Business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLastestActiveProducts(int count);
	
}
