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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		new ProductValidator().validate(mProduct, results);
		
		// check if there are any errros
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("errorMsg", "Validation failed for Product Submission!");
			
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		// create a new product record
		productDAO.add(mProduct);
		
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	// return categories on all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		return categoryDAO.list();
	}
}
