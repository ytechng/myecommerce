<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/flows-header.jsp"%>

<div class="container py-3">

<div class="row">
	<div class="card card-body">
				<h3 class="text-center mb-4">Confirmation</h3>
				
			</div>
</div>

  <div class="row">
    <div class="col-sm">
      	<div class="card">
			<div class="card-header">
			    <strong>Personal Details</strong>
			</div>
			<div class="card-block text-center">
			    <h4 class="card-title">${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
			    <div class="card-text">
			    	<h5>Email: ${registerModel.user.email}</h5>
			    	<h5>Phone Number: Email: ${registerModel.user.phoneNumber}</h5>
			    	<h5>Role: ${registerModel.user.role}</h5>
			    </div>
			</div>
			<div class="card-footer text-muted">
				<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
			</div>
		</div>
    </div>
    
    <div class="col-sm">
      	<div class="card">
			<div class="card-header">
				<strong>Billing Details</strong>
			</div>
			<div class="card-block text-center">
			    <h4 class="card-title">${registerModel.billing.firstAddress}</h4>
			    <div class="card-text">
			    	<h4>${registerModel.billing.secondAddress}</h4>
			    	<h4>${registerModel.billing.city} - ${registerModel.billing.postalCode}</h4>
			    	<h4>${registerModel.billing.state} - ${registerModel.billing.country}</h4>
			    </div>
			</div>
			<div class="card-footer text-muted">
			   	<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
			</div>
		</div>
    </div>
  </div>
  
  <hr>
  
  <div class="row">
	<div class="col-md-2 mx-auto">
		<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-success">Confirm</a>
	</div>
  </div>
</div>

<%@ include file="../shared/flows-footer.jsp"%>