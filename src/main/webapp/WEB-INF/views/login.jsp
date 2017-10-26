<!-- Namespaces -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!-- Create variables for css, js and images -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="fa" value="/resources/font-awesome-4.7.0" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Ecommerce - ${title}</title>
    
    <script>
    	window.menu = '${title}';
    	window.contextRoot = '${contextRoot}';
    	window.images = '${images}/products';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- Font Awesome -->
    <link href="${fa}/css/font-awesome.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="${css}/app.css" rel="stylesheet">

  </head>

  <body>
	
	<div class="wrapper">
	    <!-- Navigation -->
	    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${contextRoot}/home">My
					Ecommerce</a>
			</div>
		</nav>

	    <!-- Page Content -->
	    <div class="content">
	    	<div class="col-md-6 mx-auto">
	    		<!-- display error msg if login failed -->
	    		<c:if test="${not empty errorMsg}">
		    		<div class="alert alert-danger col-md-6 mx-auto">
						<a class="close" data-dismiss="alert" href="#">×</a>${errorMsg}
					</div>
				</c:if>
				
				<c:if test="${not empty logout}">
		    		<div class="alert alert-danger col-md-6 mx-auto">
						<a class="close" data-dismiss="alert" href="#">×</a>${logout}
					</div>
				</c:if>
				
		    	<form class="form-horizontal" role="form" method="POST" action="${contextRoot}/login" id="frmLogin">
		            <div class="row">
		                <div class="col-md-3"></div>
		                <div class="col-md-6">
		                    <h2>Please Login</h2>
		                    <hr>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-md-3"></div>
		                <div class="col-md-6">
		                    <div class="form-group has-danger">
		                        <label for="email">E-Mail Address:</label>
		                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
		                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-at"></i></div>
		                            <input type="text" name="username" class="form-control" id="username"
		                                   placeholder="you@example.com" required autofocus>
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-md-3"></div>
		                <div class="col-md-6">
		                    <div class="form-group">
		                        <label for="password">Password:</label>
		                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
		                            <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
		                            <input type="password" name="password" class="form-control" id="password"
		                                   placeholder="Password" required>
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <div class="row">
		                <div class="col-md-3"></div>
		                <div class="col-md-6" style="padding-top: .35rem">
		                    <div class="form-check mb-2 mr-sm-2 mb-sm-0">
		                        <label class="form-check-label">
		                            <input class="form-check-input" name="remember"
		                                   type="checkbox" >
		                            <span style="padding-bottom: .15rem">Remember me</span>
		                        </label>
		                    </div>
		                </div>
		            </div>
		            <div class="row" style="padding-top: 1rem">
		                <div class="col-md-3"></div>
		                <div class="col-md-6">
		                    <button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i> Login</button>
		                    <a class="btn btn-link" href="#">Forgot Your Password?</a>
		                    
		                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                </div>
		            </div>
		        </form>
		   </div>
		</div>
		
		<!-- Footer -->
		<%@ include file="./shared/footer.jsp" %>

	    <!-- JQuery -->
	    <script src="${js}/jquery.min.js"></script>
	    <script src="${js}/popper.min.js"></script>
	    
	    <!-- jQuery validator -->
	    <script src="${js}/jquery.validate.js"></script>
	    
	    <!-- Bootstrap core JavaScript -->
	    <script src="${js}/bootstrap.min.js"></script>

	    <!-- Custom Javascript -->
	    <script src="${js}/app.js"></script>
    
    </div>

  </body>

</html>
