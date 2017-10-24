package JavaEcommerce.MyEcommerce.model;

import java.io.Serializable;

import JavaEcommerce.MyEcommerce.dto.Address;
import JavaEcommerce.MyEcommerce.dto.User;

public class RegisterModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Address billing;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address address) {
		this.billing = address;
	}

}
