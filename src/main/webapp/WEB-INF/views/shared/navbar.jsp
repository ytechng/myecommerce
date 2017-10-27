<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">My Ecommerce</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item" id="home"><a class="nav-link"
					href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li class="nav-item" id="listProducts"><a class="nav-link"
					href="${contextRoot}/show/all/products">Product Lists</a></li>
				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				
				<!-- Display to Admin Users -->
				<security:authorize access="hasAuthority('admin')">
					<li class="nav-item" id="manageProducts"><a class="nav-link"
						href="${contextRoot}/manage/products">Manage Products</a></li> 
				</security:authorize>
				
				<!-- Menu to display to anonymous users -->
				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="register"><a class="nav-link"
						href="${contextRoot}/register">Sign Up</a></li>
					<li class="nav-item" id="login"><a class="nav-link"
						href="${contextRoot}/login">Login</a></li>
				</security:authorize>
				
				<!-- Display to logged in users -->
				<security:authorize access="isAuthenticated()">
					<li>
						<div class="btn-group">
						  <button type="button" class="btn btn-info dropdown-toggle" 
						  	data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    ${userModel.fullName}
						  </button>
						  <div class="dropdown-menu" id="cartDetails">
						  	<security:authorize access="hasAuthority('user')">
							  	<a class="dropdown-item" href="${contextRoot}/cart/show">
									<span class="fa fa-shopping-cart"></span>
									<span class="badge badge-pill badge-danger">${userModel.cart.cartLines}</span>
									- &#x20A6; ${userModel.cart.grandTotal}
								</a>
								
							    <div class="dropdown-divider"></div>
							</security:authorize>
						    
						    <a class="dropdown-item" href="${contextRoot}/account-logout">
						    	<span class="fa fa-sign-out" style="color:red;"></span> LogOut
						    </a>
						  </div>
						</div>
					</li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>

<script>
	window.userRole = '${userModel.role}';
</script>