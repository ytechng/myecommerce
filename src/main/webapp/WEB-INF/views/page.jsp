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
    
    <!-- CSRF -->
    <meta name="_csrf" content="${_csrf.token}">
    <meta name="_csrf_header" content="${_csrf.headerName}">

    <title>My Ecommerce - ${title}</title>
    
    <script>
    	window.menu = '${title}';
    	window.contextRoot = '${contextRoot}';
    	window.images = '${images}/products';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- Bootstrap Datatables -->
    <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
    
    <!-- Glyphicons -->
    <link href="${fa}/css/font-awesome.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="${css}/app.css" rel="stylesheet">

  </head>

  <body>
	
	<div class="wrapper">
	    <!-- Navigation -->
	    <%@ include file="./shared/navbar.jsp" %>

	    <!-- Page Content -->
	    <div class="content">
		    <c:if test="${userClickHome == true}">
		    	<!-- Load home content file -->
		   		<%@ include file="home.jsp" %>
		   	</c:if>
		   	
		   	<c:if test="${userClickAbout == true}">
		    	<!-- Load only if user clicks about us -->
		   		<%@ include file="about.jsp" %>
		   	</c:if>
		   	
		   	<c:if test="${userClickContact == true}">
		    	<!-- Load only if user clicks contact us -->
		   		<%@ include file="contact.jsp" %>
		   	</c:if>
		   	
		   	<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
		    	<!-- Load only if user clicks contact us -->
		   		<%@ include file="listProducts.jsp" %>
		   	</c:if>
		   	
		   	<c:if test="${userClickShowProduct == true}">
		    	<!-- Load only if user clicks contact us -->
		   		<%@ include file="singleProduct.jsp" %>
		   	</c:if>
		   	
		   	<c:if test="${userClickManageProducts == true}">
		    	<!-- Load only if user clicks contact us -->
		   		<%@ include file="manageProducts.jsp" %>
		   	</c:if>
		   	
		   	<c:if test="${userClickShowCart == true}">
		    	<!-- Load only if user clicks contact us -->
		   		<%@ include file="cart.jsp" %>
		   	</c:if>
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
	    
	    <!-- Datatables Plugin -->
	    <script src="${js}/jquery.dataTables.js"></script>
	    
	    <!-- Datatables Bootstrap -->
	    <script src="${js}/dataTables.bootstrap4.js"></script>
	    
	    <!-- BootBox JS -->
	    <script src="${js}/bootbox.min.js"></script>
	    
	    <!-- Custom Javascript -->
	    <script src="${js}/app.js"></script>
    
    </div>

  </body>

</html>
