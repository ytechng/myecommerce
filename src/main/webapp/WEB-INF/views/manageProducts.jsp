<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>

<div class="container">
	<div class="drop"></div>
	<div class="row">
		
		<div class="col-md-6 mx-auto">
			
			<c:if test="${not empty successMsg}">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
						
					${successMsg}
				</div> 
			</c:if>
			
			<c:if test="${not empty errorMsg}">
				<div class="alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
						
					${errorMsg}
				</div> 
			</c:if>
		
			<div class="card">
				<div class="card-header">
					<h4>Product Management</h4>
				 </div>
				 
				 <div class="card-block">
				 	<!-- Form elements here -->
				 	<div class="card-text">
				 		<html:form class="form-horizontal" modelAttribute="product" 
				 			action="${contextRoot}/manage/products " method="POST" 
				 			id="productForm" enctype="multipart/form-data">
				 			<!-- Category dropdown -->
				 			<div class="form-group row">
				 				<label class="col-md-4 col-form-label" for="categoryId">
				 					Category:
				 				</label>
				 				<div class="col-md-8">
				 					<div class="input-group">
					 					<html:select path="categoryId" id="categoryId" class="form-control" 
					 						items="${categories}" itemLabel="name" itemValue="id"/>
					 					<html:errors path="categoryId" cssClass="help-block" element="em"/>
					 					
					 					<!-- Button to call add category modal -->
					 					<c:if test="${product.id == 0}">
					 						<span class="input-group-addon fa fa-plus" data-toggle="modal" data-target="#categoryModal" style="color: #008000;" title="Add Category"></span>
					 					</c:if>
					 				</div>
				 					
				 				</div>
				 			</div>
				 							 			
				 			<!-- Product name input -->
				 			<div class="form-group row">
				 				<label class="col-md-4 col-form-label for="name">
				 					Product Name*:
				 				</label>
				 				<div class="col-md-8">
				 					<html:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/>
				 					<html:errors path="name" cssClass="help-block" element="em"/>
				 				</div>
				 			</div>
				 			
				 			<!-- Brand name input -->
				 			<div class="form-group row">
				 				<label class="col-md-4 col-form-label" for="brand">
				 					Brand Name*:
				 				</label>
				 				<div class="col-md-8">
				 					<html:input type="text" path="brand" id="brand" placeholder="Product Brand" class="form-control"/>
				 					<html:errors path="brand" cssClass="help-block" element="em"/>
				 				</div>
				 			</div>
				 			
				 			<!-- Description input -->
				 			<div class="form-group row">
				 				<label class="col-md-4 col-form-label" for="description">
				 					Description*:
				 				</label>
				 				<div class="col-md-8">
				 					<html:textarea path="description" id="description" placeholder="Description" class="form-control" rows="5"></html:textarea>
				 					<html:errors path="description" cssClass="help-block" element="em"/>
				 				</div>
				 			</div>
				 			
				 			<!-- uniPrice input -->
				 			<div class="form-group row">
				 				<label class="col-md-4 col-form-label" for="unitPrice">
				 					Product Unit Price*:
				 				</label>
				 				<div class="col-md-8">
				 					<html:input type="number" path="unitPrice" id="unitPrice" placeholder="Product Price" class="form-control"/>
				 					<html:errors path="unitPrice" cssClass="help-block" element="em"/>
				 				</div>
				 			</div>
				 			
				 			<!-- Quantity input -->
				 			<div class="form-group row">
				 				<label class="col-md-4 col-form-label" for="quantity">
				 					Quantity*:
				 				</label>
				 				<div class="col-md-8">
				 					<html:input type="number" path="quantity" id="quantity" placeholder="Product Price" class="form-control"/>
				 					<html:errors path="quantity" cssClass="help-block" element="em"/>
				 				</div>
				 			</div>
				 			
				 			<!-- File input for image upload -->
				 			<div class="form-group row">
				 				<label class="col-md-4 col-form-label" for="file">
				 					Product Image
				 				</label>
				 				<div class="col-md-8">
				 					<html:input type="file" path="file" id="file" class="form-control"/>
				 					<html:errors path="file" cssClass="help-block" element="em"/>
				 				</div>
				 			</div>
				 			
				 			<!-- Add Product button -->
				 			<div class="form-group">				 				
				 				<div class="col-md-6 mx-auto">
				 					<button type="submit" name="submit" class="${btnClass} btn-block">
				 						<span class="${faClass}"></span> ${btnTitle}
				 					</button>
				 				</div>
				 			</div>
				 			
				 			<!-- hidden fields -->
				 			<html:hidden path="id"/>
				 			<html:hidden path="code"/>
				 			<html:hidden path="merchantId"/>
				 			<html:hidden path="purchases"/>
				 			<html:hidden path="views"/>
				 			<html:hidden path="active"/>
				 			
				 		</html:form>
				 	</div>
				 </div>
			</div>
		</div>
		
		<div class="col-md-12">
			<h3>List of Products</h3>
			<hr/>
		</div>
		
		<div class="col-md-12">
			<div style="overflow: auto;">
				<table class="table table-striped table-bordered" id="adminProductsTable">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					
					<!-- tbody will get data from jQuery -->
					
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				
				</table>	
			</div>
		</div>
		
	</div>

	<!-- include category modal -->
	<%@ include file="modals/categoryModal.jsp" %>
</div>