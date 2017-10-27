package JavaEcommerce.MyEcommerce.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import JavaEcommerce.MyEcommerce.dao.UserDAO;
import JavaEcommerce.MyEcommerce.dto.Address;
import JavaEcommerce.MyEcommerce.dto.Cart;
import JavaEcommerce.MyEcommerce.dto.User;
import JavaEcommerce.MyEcommerce.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	public RegisterModel init() {
		
		return new RegisterModel();
		
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		
		registerModel.setUser(user);
	}
	
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		
		registerModel.setBilling(billing);
	}
	
	
	public String validateUser(User user, MessageContext errorMsg) {
		
		String transitionValue = "success";
		
		// checking if password matches confirmPassword
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			
			errorMsg.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match the confirm password!")
					.build());
			
			transitionValue = "failed";
		}
		
		// check the uniqueness of the user email
		if (userDAO.getUserByEmail(user.getEmail()) != null) {
			errorMsg.addMessage(new MessageBuilder()
					.error().source("email")
					.defaultText("Email address is already taken!")
					.build());
			
			transitionValue = "failed";
		}
		
		
		return transitionValue;
	}
	
	
	public String saveAll(RegisterModel model) {
		
		String transitionValue = "success";
		
		User user = model.getUser();
		
		// create cart if role is user
		if (user.getRole().equals("user")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		// encode user password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// then save the user
		userDAO.addUser(user);
		
		// get user billing address 
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		// save the address
		userDAO.addAddress(billing);
		
		return transitionValue;
		
	}

}
