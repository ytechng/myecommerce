package JavaEcommerce.MyEcommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import JavaEcommerce.MyEcommerce.dao.UserDAO;
import JavaEcommerce.MyEcommerce.dto.User;
import JavaEcommerce.MyEcommerce.model.UserModel;

@ControllerAdvice
@Scope("session")
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if (session.getAttribute("userModel") == null) {
			// add the user model
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.getUserByEmail(auth.getName());
			
			if (user != null) {
				
				// create new UserModel object to pass the user details
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				
				if (userModel.getRole().equals("user")) {
					// set the cart only if the login user is a buyer
					userModel.setCart(user.getCart());
				}
				
				// set the userModel in the session
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
}