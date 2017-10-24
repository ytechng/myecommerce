<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/flows-header.jsp"%>

<div class="container py-3">
	<div class="row">
		<div class="col-md-6 col-lg-6 mx-auto">
			<div class="card card-body">
				<h3 class="text-center mb-4">Billing Details</h3>
				<div class="alert alert-danger">
					<a class="close" data-dismiss="alert" href="#">×</a>Password is too
					short.
				</div>
				<html:form method="POST" id="frmBilling" modelAttribute="billing">
					<fieldset>
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="Address Line 1"
								path="firstAddress" type="text"/>
							
							<html:errors path="firstAddress" cssClass="help-block" element="em"/>
						</div>
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="Address Line 2"
								path="secondAddress" type="text"/>
							
							<html:errors path="secondAddress" cssClass="help-block" element="em"/>
						</div>
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="City"
								path="city" type="text"/>
							
							<html:errors path="city" cssClass="help-block" element="em"/>
						</div>
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="State"
								path="state" type="text" maxlength="11"/>
							
							<html:errors path="state" cssClass="help-block" element="em"/>
						</div>						
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="Country"
								path="country" type="text"/>
							
							<html:errors path="country" cssClass="help-block" element="em"/>
						</div>
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="Postal Code"
								path="postalCode" type="text"/>
							
							<html:errors path="postalCode" cssClass="help-block" element="em"/>
						</div>
						
						<div class="row">
							<div class="col-sm">					
								<button class="btn btn-lg btn-primary" type="submit" 
									name="_eventId_personal">
									<span class="fa fa-chevron-left"></span> Previous - Personal
								</button>
							</div>
							
							<div class="col-sm">
								<button class="btn btn-lg btn-success" type="submit" 
									name="_eventId_confirm">
									Next - Confirm <span class="fa fa-chevron-right"></span>
								</button>
							</div>
						</div>
					</fieldset>
				</html:form>
			</div>
		</div>
	</div>
</div>

<%@ include file="../shared/flows-footer.jsp"%>