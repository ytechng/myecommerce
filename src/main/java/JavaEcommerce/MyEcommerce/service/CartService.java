package JavaEcommerce.MyEcommerce.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaEcommerce.MyEcommerce.dao.CartLineDAO;
import JavaEcommerce.MyEcommerce.dao.ProductDAO;
import JavaEcommerce.MyEcommerce.dto.Cart;
import JavaEcommerce.MyEcommerce.dto.CartLine;
import JavaEcommerce.MyEcommerce.dto.Product;
import JavaEcommerce.MyEcommerce.model.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductDAO productDAO; 
	

	// get cart of the logged in user
	private Cart getCart() {
		
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	// return entire cartlines of the logged in user
	public List<CartLine> getCartLines() {
		
		return cartLineDAO.list(this.getCart().getId());
	}

	public String updateCartLine(int cartLineId, int count) {

		// fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if (cartLine == null) {
			return "result=error";
			
		} else { // update
			Product product = cartLine.getProduct();
			
			double oldTotal = cartLine.getTotal();
			
			if (product.getQuantity() <= count) {
				count = product.getQuantity();
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			
			cartLineDAO.update(cartLine); // update cart line
			
			Cart cart = this.getCart();			
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart); // update cart
			
			return "result=updated"; 
		}
	}

	public String deleteCartLine(int cartLineId) {
		// fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if (cartLine == null) {
			return "result=error";
			
		} else { 
			// update the cart
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			
			cartLineDAO.updateCart(cart);
			
			// remove the cart line
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";
		}
	}

	public String addCartLine(int productId, int productCount) {
		
		productCount = 1;
		
		String response = null;		
		Cart cart = this.getCart();		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		
		if (cartLine == null) { // add new cart line
		
			cartLine = new CartLine();
			
			// fetch the product
			Product product = productDAO.get(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(productCount);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			response = "result=added";
			
		} else { // update cart line
			
			
			
		}
		
		
		return response;
	}
}
