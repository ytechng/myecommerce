package JavaEcommerce.MyEcommerce.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JavaEcommerce.MyEcommerce.dao.ProductDAO;
import JavaEcommerce.MyEcommerce.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Get all products
	 */
	@Override
	public List<Product> list() {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("FROM Product", Product.class)
					.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Get a single product based on id
	 */
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession()
					.get(Product.class, Integer.valueOf(productId));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Add a new product
	 */
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Update product by id supplied
	 */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Delete product based on id supplied
	 */
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Get all active products
	 */
	@Override
	public List<Product> listActiveProducts() {
		try {
			String selectActiveProduct = "FROM Product WHERE is_active = :active";
			
			return sessionFactory.getCurrentSession()
					.createQuery(selectActiveProduct, Product.class)
					.setParameter("active", true)
					.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Get products by their categories
	 */
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		try {
			String selectActiveProductByCategory = 
					"FROM Product WHERE active = :active AND categoryId = :categoryId";
			
			return sessionFactory.getCurrentSession()
					.createQuery(selectActiveProductByCategory, Product.class)
					.setParameter("active", true)
					.setParameter("categoryId", categoryId)
					.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Get latest active product 
	 */
	@Override
	public List<Product> getLastestActiveProducts(int count) {
		try {
			String selectLatestActiveProduct = 
					"FROM Product WHERE active = :active ORDER BY id";
			
			return sessionFactory.getCurrentSession()
					.createQuery(selectLatestActiveProduct, Product.class)
					.setParameter("active", true)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
