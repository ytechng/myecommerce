package JavaEcommerce.MyEcommerce.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JavaEcommerce.MyEcommerce.dao.CategoryDAO;
import JavaEcommerce.MyEcommerce.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// all category list
	@Override
	public List<Category> list() {

		String activeCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery(activeCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	// get a single category
	@Override
	public Category get(int id) {

		try {
			return sessionFactory.getCurrentSession()
					.get(Category.class, Integer.valueOf(id));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// add new category
	@Override
	public boolean add(Category category) {

		try {
			// add category to the database table
			sessionFactory.getCurrentSession().persist(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// update category
	@Override
	public boolean update(Category category) {

		try {
			// update category in the database table
			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete category
	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
	}

}
