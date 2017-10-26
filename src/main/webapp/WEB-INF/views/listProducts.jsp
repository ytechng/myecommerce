<div class="container">
	<div class="row">

		<!-- side-bar -->
		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>
		<!-- /side-bar -->

		<!-- products -->
		<div class="col-md-9">

			<!-- breadcrumb component -->
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${userClickAllProducts == true}">
						
						<script>
							window.categoryId = '';
						</script>
						
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
					
						<script>
							window.categoryId = '${category.id}';
						</script>
					
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name} Category</li>
						</ol>
					</c:if>
				</div>
			</div>
			<!-- /breadcrumb component -->
			
			
			<div class="row">
				<div class="col-md-12">
					
					<div class="container-fluid">
						<div class="table-responsive">
											
							<table id="productListTable" class="table table-striped table-borderd">
								<thead>
									<tr>
										<th>Image</th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Qty</th>
										<th></th>
									</tr>
								</thead>
								
								<!-- tbody will get data from jQuery -->
								
								<tfoot>
									<tr>
										<th>Image</th>
										<th>Name</th>
										<th>Brand</th>
										<th>Price</th>
										<th>Qty</th>
										<th></th>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
          	</div>	
          	<!-- /.row -->
		</div>
		<!-- /products -->

	</div>
</div>