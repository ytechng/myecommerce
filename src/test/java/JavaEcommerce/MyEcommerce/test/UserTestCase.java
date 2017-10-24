package JavaEcommerce.MyEcommerce.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import JavaEcommerce.MyEcommerce.dao.UserDAO;
import JavaEcommerce.MyEcommerce.dto.Address;
import JavaEcommerce.MyEcommerce.dto.Cart;
import JavaEcommerce.MyEcommerce.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	private String email = "test@gmail.com";
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("JavaEcommerce.MyEcommerce");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*@Test
	public void testUserData() {
		
		// new user record
		user = new User();
		user.setFirstName("Opeyemi");
		user.setLastName("Ajayi");
		user.setPhoneNumber("08020908829");
		user.setEmail("test@gmail.com");
		user.setPassword("test1234");
		user.setRole("user");
		
		// add the user
		assertEquals("Failed to add user", true, userDAO.addUser(user));
		
		// new user address record
		address = new Address();
		address.setFirstAddress("9 Alarape Street, Langbasa Eti-osa Ajah");
		address.setSecondAddress("3, Alhaji Orire Street, Erasco Epe");
		address.setCity("Lagos");
		address.setState("Lagos");
		address.setCountry("Nigeria");
		address.setPostalCode("23401");
		address.setBilling(true);
		
		// link with the user id
		address.setUser(user);
		
		// add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		// check if user role is 'user'
		if (user.getRole().equals("user")) {
			
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			// add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			// add a shipping address for this user
			address = new Address();
			address.setFirstAddress("3, Alhaji Orire Street, Erasco Epe");
			address.setSecondAddress("9 Alarape Street, Langbasa Eti-osa Ajah");
			address.setCity("Lagos");
			address.setState("Lagos");
			address.setCountry("Nigeria");
			address.setPostalCode("23401");
			address.setShipping(true);
			
			// link with user id
			address.setUser(user);
			
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		}
	}*/
	
	
	/*@Test
	public void testUserData() {
		
		// new user record
		user = new User();
		user.setFirstName("Opeyemi");
		user.setLastName("Ajayi");
		user.setPhoneNumber("08020908829");
		user.setEmail("test@gmail.com");
		user.setPassword("test1234");
		user.setRole("user");
		
		// check if user role is 'user'
		if (user.getRole().equals("user")) {
			
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			// attach cart with the user
			user.setCart(cart);
		}
		
		// add the user
		assertEquals("Failed to add user", true, userDAO.addUser(user));
	}*/
	
	/*@Test
	public void testUpdateCart() {
		
		String email = "test@gmail.com";
		
		// get user by email
		user = userDAO.getUserByEmail(email);
		
		// get the cart of the user
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(2);
		
		assertEquals("Failed to update cart!", true, userDAO.updateCart(cart));
	}*/
	
	/*@Test
	public void testAddAddress() {
		// first add user
		user = new User();
		user.setFirstName("Opeyemi");
		user.setLastName("Ajayi");
		user.setPhoneNumber("08020908829");
		user.setEmail("test@gmail.com");
		user.setPassword("test1234");
		user.setRole("user");
		
		assertEquals("Failed to add user", true, userDAO.addUser(user));
		
		// add the address
		address = new Address();
		address.setFirstAddress("9 Alarape Street, Langbasa Eti-osa Ajah");
		address.setSecondAddress("3, Alhaji Orire Street, Erasco Epe");
		address.setCity("Lagos");
		address.setState("Lagos");
		address.setCountry("Nigeria");
		address.setPostalCode("23401");
		address.setBilling(true);
		
		// link user to the address
		address.setUser(user);
		
		// add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		// add shipping address
		address = new Address();
		address.setFirstAddress("3, Alhaji Orire Street, Erasco Epe");
		address.setSecondAddress("9 Alarape Street, Langbasa Eti-osa Ajah");
		address.setCity("Lagos");
		address.setState("Lagos");
		address.setCountry("Nigeria");
		address.setPostalCode("23401");
		address.setShipping(true);
		
		// link user to the shipping address
		address.setUser(user);
		
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
	}*/
	
	
	/*@Test
	public void testAddAddress() {
		
		user = userDAO.getUserByEmail(email);
		
		// add new address
		address = new Address();
		address.setFirstAddress("22, Ayobo Ipaja Road, Ayobo Lagos");
		address.setSecondAddress("Off Nigerian Railway Coperation");
		address.setCity("Ayobo");
		address.setState("Lagos");
		address.setCountry("Nigeria");
		address.setPostalCode("23401");
		address.setShipping(true);
		
		// link the user to the address
		address.setUser(user);
		
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
	}*/
	
	@Test
	public void testGetAddresses() {
		
		user = userDAO.getUserByEmail(email);
		
		assertEquals("Failed to fetch the list addresses", 2, 
				userDAO.listShippingAddresses(user.getId()).size());
		
		assertEquals("Failed to fetch the billing address", "Lagos", 
				userDAO.getBillingAddress(user.getId()).getCity());
	}
	
}
