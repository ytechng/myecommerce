package JavaEcommerce.MyEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import JavaEcommerce.MyEcommerce.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {
		
		ModelAndView mv = new ModelAndView("page");
		
		if (result != null) {
			
			switch (result) {
			case "error":
				mv.addObject("message", "There was an error updating cart line");
				mv.addObject("alert", "alert alert-danger");
				break;
			case "updated":
				mv.addObject("message", "Cart line has been updated successfully!");
				mv.addObject("alert", "alert alert-success");
				break;
			case "deleted":
				mv.addObject("message", "Cart line has been removed successfully!");
				mv.addObject("alert", "alert alert-danger");
				break;
			case "added":
				mv.addObject("message", "Cart line has been added successfully!");
				mv.addObject("alert", "alert alert-success");
				break;
			}
			
		}
		
		mv.addObject("title", "Cart Details");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLines());
		
		return mv;
	}
	
	
	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {
		
		String response = cartService.updateCartLine(cartLineId, count);
		
		return "redirect:/cart/show?" + response;
	}
	
	
	@RequestMapping("/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId) {
		
		String response = cartService.deleteCartLine(cartLineId);
		
		return "redirect:/cart/show?" + response;
	}
	
	
	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {
		
		int productCount = 1;
		String response = cartService.addCartLine(productId, productCount);
		
		return "redirect:/cart/show?" + response;
	}
}
