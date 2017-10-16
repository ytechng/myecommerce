package JavaEcommerce.MyEcommerce.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import JavaEcommerce.MyEcommerce.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> classe) {
		// TODO Auto-generated method stub
		return Product.class.equals(classe);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		
		// check if file has been selected or not
		if (product.getFile() == null || 
				product.getFile().getOriginalFilename().equals("")) {
			
			errors.rejectValue("file", null, "Please select an image file to upload!");
			
			return;
		}
		
		if (!(
				product.getFile().getContentType().equals("image/jpeg") || 
				product.getFile().getContentType().equals("image/png") ||
				product.getFile().getContentType().equals("image/gif") 
			)) {
			
			errors.rejectValue("file", null, "Please use only image file for upload!");
			
			return;
			
		}

	}

}
