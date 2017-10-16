package JavaEcommerce.MyEcommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import JavaEcommerce.MyEcommerce.dao.CategoryDAO;
import JavaEcommerce.MyEcommerce.dao.ProductDAO;
import JavaEcommerce.MyEcommerce.dto.Category;
import JavaEcommerce.MyEcommerce.dto.Product;
import JavaEcommerce.MyEcommerce.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		
		logger.info("Inside PageConteroller index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		// Pass categories lists
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	
	/**
	 * Methodto load all products
	 * @return mv
	 */
	@RequestMapping(value={"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "All Products");
		
		// Pass categories lists
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		
		return mv;
	}
	
	/**
	 * Method to display category of products
	 * @param id
	 * @return mv
	 */
	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		// use CategoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		// Pass categories lists
		mv.addObject("categories", categoryDAO.list());
		
		// Pass single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
	}
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if (product == null) {
			throw new ProductNotFoundException();
		}
		
		// set view count by adding 1
		product.setViews(product.getViews() + 1);
		
		// update the view count
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	
	
	/**
	 * Below method are for learning purposes only
	 * they are not part of the project
	 * @param greeting
	 * @return
	 */
	
	// Using @RequestParam
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting) {
		if (greeting == null) {
			greeting = "Welcome to Java Development Class";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	// Using @PathVariable
	@RequestMapping(value="/test2/{greeting}")
	public ModelAndView test2(@PathVariable("greeting") String greeting) {
		if (greeting == null) {
			greeting = "Welcome to Java Development Class";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
}