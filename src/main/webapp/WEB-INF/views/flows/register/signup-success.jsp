<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/flows-header.jsp"%>

<div class="container py-3">
	<div class="row">
		<div class="col-md-6 col-lg-6 mx-auto">
			<div class="card card-body">
				<h1 class="text-center mb-4">Success</h1>				
			</div>
			
			<div class="card">
				<h4>Welcome!</h4>
				<p>To Automobile Parts Solutions</p>
				<p>You can use your email address as username to <a href="${contextRoot}/login">login</a></p>
			</div>
			
			<div class="row">
			  <div class="col-md-4 mx-auto">
			    <a href="${contextRoot}/login" class="btn btn-success">Login Here</a>
			  </div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../shared/flows-footer.jsp"%>