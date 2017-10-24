<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/flows-header.jsp"%>

<div class="container py-3">
	<div class="row">
		<div class="col-md-6 col-lg-6 mx-auto">
			<div class="card card-body">
				<h3 class="text-center mb-4"><span class="fa fa-user"></span> Personal Details</h3>
				<div class="alert alert-danger">
					<a class="close" data-dismiss="alert" href="#">×</a>Password is too short
				</div>
				<html:form method="POST" id="frmPersonal" modelAttribute="user">
					<fieldset>
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="First Name"
								path="firstName" type="text"/>
							
							<html:errors path="firstName" cssClass="help-block" element="em"/>
						</div>
						
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="Last Name"
								path="lastName" type="text"/>
								
							<html:errors path="lastName" cssClass="help-block" element="em"/>
						</div>
						
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="E-mail Address"
								path="email" type="text"/>
							<html:errors path="email" cssClass="help-block" element="em"/>
						</div>
						
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="Phone Number"
								path="phoneNumber" type="text" maxlength="11"/>
							<html:errors path="phoneNumber" cssClass="help-block" element="em"/>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Select Role</label>
							<label class="radio-inline">
								<html:radiobutton path="role" value="user" checked="checked"/> User
							</label>
							<label class="radio-inline">
								<html:radiobutton path="role" value="supplier"/> Supplier
							</label>
						</div>
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="Password"
								path="password" type="password"/>
							<html:errors path="password" cssClass="help-block" element="em"/>
						</div>
						<div class="form-group">
							<html:input class="form-control input-lg" placeholder="Confirm Password"
								path="confirmPassword" type="password"/>
							<html:errors path="confirmPassword" cssClass="help-block" element="em"/>
						</div>
												
						<button class="btn btn-lg btn-success btn-block" type="submit" 
							name="_eventId_billing">
							Next - Billing <span class="fa fa-chevron-right"></span>
						</button>
					</fieldset>
				</html:form>
			</div>
		</div>
	</div>
</div>

<%@ include file="../shared/flows-footer.jsp"%>