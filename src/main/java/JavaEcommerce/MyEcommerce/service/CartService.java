package JavaEcommerce.MyEcommerce.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaEcommerce.MyEcommerce.dao.CartLineDAO;
import JavaEcommerce.MyEcommerce.dto.Cart;
import JavaEcommerce.MyEcommerce.dto.CartLine;
import JavaEcommerce.MyEcommerce.model.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	

	// get cart of the logged in user
	private Cart getCart() {
		
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	// return entire cartlines of the logged in user
	public List<CartLine> getCartLines() {
		
		return cartLineDAO.list(this.getCart().getId());
	}
}
