package JavaEcommerce.MyEcommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import JavaEcommerce.MyEcommerce.dao.CategoryDAO;
import JavaEcommerce.MyEcommerce.dao.ProductDAO;
import JavaEcommerce.MyEcommerce.dto.Category;
import JavaEcommerce.MyEcommerce.dto.Product;
import JavaEcommerce.MyEcommerce.util.FileUploadUtility;
import JavaEcommerce.MyEcommerce.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ProductManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductManagementController.class);

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		mv.addObject("btnTitle", "Add Product");
		mv.addObject("btnClass", "btn btn-info");
		mv.addObject("faClass", "fa fa-plus-circle");
		
		Product nProduct = new Product();
		
		// set few of the fields
		nProduct.setMerchantId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("successMsg", "Product added successfully.");
			}
		}
		
		return mv;
	}
	
	// handling new product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product mProduct, 
			BindingResult results, Model model, HttpServletRequest request) {
		
		// handle image validation for new products
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
			
		} else { // there is file to be uploaded during product update
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		// check if there are any errros
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("errorMsg", "Validation failed for Product Submission!");
			
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		if (mProduct.getId() == 0) {
			// create a new product record
			productDAO.add(mProduct);
		} else {
			// update the product
			productDAO.add(mProduct);
		}
		
		
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String productActivation(@PathVariable int id) {
		
		// get product with the id supplied from the database
		Product product = productDAO.get(id);
		
		boolean isActive = product.isActive();
		
		// activating and deactivating product based on id value
		product.setActive(!product.isActive());
		
		// update the product
		productDAO.update(product);
		
		return (isActive) ? 
				"You have successfully deactivated the product with id "+ product.getId() : 
				"You have successfully activated the product with id "+ product.getId();
	}
	
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		mv.addObject("btnTitle", "Update Product");
		mv.addObject("btnClass", "btn btn-primary");
		mv.addObject("faClass", "fa fa-edit");
		
		// fetch product from the database 
		Product uProduct = productDAO.get(id);
		
		// set the product fetched from the databse		
		mv.addObject("product", uProduct);
		
		return mv;
	} 
	
	// return categories on all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		return categoryDAO.list();
	}
}
